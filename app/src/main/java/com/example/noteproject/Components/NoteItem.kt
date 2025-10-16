package com.example.noteproject.Components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.noteproject.R
import com.example.noteproject.ui.theme.Typography

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NoteItem(modifier: Modifier = Modifier, title: String, color: Color,onClicked:()->(Unit)) {
    var isDeleteView: Boolean by remember { mutableStateOf(false) }
    Surface(
        modifier = modifier
            .combinedClickable(
            onClick = onClicked,
            onLongClick = {isDeleteView=!isDeleteView}
        ),
        shape = RoundedCornerShape(8.dp),

        color = if (isDeleteView) Color.Red else color
    ) {
        Row(
            Modifier
                .padding(
                    top = 22.dp,
                    bottom = 21.dp,
                    end = 29.dp,
                    start = 49.dp
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = if (isDeleteView) Arrangement.Center else Arrangement.Start

        ) {
            if (isDeleteView)
                Icon(
                    painter = painterResource(R.drawable.ic_delete),
                    contentDescription = "delete", Modifier.padding(12.dp), tint = Color.White
                )
            else
                Text(
                    title,
                    style = Typography.titleLarge.copy(fontSize = 25.sp, color = Color.Black)
                )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun NoteItemPrev() {

    NoteItem(
        modifier = Modifier
            .padding(top = 35.dp, start = 23.dp, end = 23.dp)
            .fillMaxWidth(),
        title = "UI concepts worth exsisting",
        color = Color.Cyan
    ){}

}