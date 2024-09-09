package com.norameyer.vectorfaq

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.norameyer.vectorfaq.data.App
import com.norameyer.vectorfaq.data.MainDB
import com.norameyer.vectorfaq.data.QAEntity
import kotlinx.coroutines.launch

@Suppress("UNCHECKED_CAST")
class MainViewModel(private val db: MainDB) : ViewModel() {

    val allQA = db.dao.getAllQA()
    var qa: QAEntity? = null
    val question = mutableStateOf("")
    val answer = mutableStateOf("")

    fun insertItem() = viewModelScope.launch {
        val item = qa?.copy(question = question.value, answer = answer.value) ?:
        QAEntity(question = question.value, answer = answer.value)
        db.dao.insertItem(item)
        qa = null
        question.value = ""
        answer.value = ""
    }

    fun deleteItem(qaEntity: QAEntity) = viewModelScope.launch {
        db.dao.deleteItem(qaEntity)
    }

    companion object {
        val factory: ViewModelProvider.Factory = object  : ViewModelProvider.Factory{
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                val database = (checkNotNull(extras[ViewModelProvider.AndroidViewModelFactory.
                APPLICATION_KEY]) as App).database
                return MainViewModel(database) as T
            }
        }
    }

}