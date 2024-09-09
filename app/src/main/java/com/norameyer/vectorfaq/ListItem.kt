package com.norameyer.vectorfaq

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.norameyer.vectorfaq.data.QAEntity

@Composable
fun ListItem(
    qaEntity: QAEntity,
    onClickEdit: () -> Unit,
    onClickDelete: () -> Unit
) {

    val expanded = remember { mutableStateOf(false) }
    val rotatorState by animateFloatAsState(
        targetValue = if (expanded.value) 45f else 0f,
        label = ""
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .animateContentSize(
                animationSpec = tween(
                    delayMillis = 10,
                    easing = LinearOutSlowInEasing
                )
            ),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent),
        onClick = { expanded.value = !expanded.value }
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = qaEntity.question,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f),
                    //maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                IconButton(
                    modifier = Modifier
                        .alpha(0.7f)
                        .rotate(rotatorState),
                    onClick = { expanded.value = !expanded.value }
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "show answer"
                    )
                }

            }

            if (expanded.value) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = qaEntity.answer,
                        fontSize = 15.sp,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.weight(1f)
                    )
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {

                        IconButton(
                            modifier = Modifier.alpha(0.3f),
                            onClick = { onClickEdit() }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Create,
                                contentDescription = "edit Q@A")
                        }
                        IconButton(
                            modifier = Modifier.alpha(0.3f),
                            onClick = { onClickDelete() }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Delete,
                                contentDescription = "delete Q@A")
                        }
                    }
                }
            }
        }

    }

}