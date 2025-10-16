package com.example.noteproject.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.noteproject.R
import com.example.noteproject.ui.theme.Typography

@Composable
fun EmptyStateContent(modifier: Modifier, label:String, imagePainter: Painter) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(contentAlignment = Alignment.BottomCenter){
            Image(modifier=Modifier
                .width(380.dp)
                .height(247.dp),
                painter = imagePainter,
                contentDescription = "empty state"
            )
            Row(Modifier){
                Text(label, style = Typography.bodyMedium, color = Color.White)
            }
        }
    }


}
@Preview(showSystemUi = true)
@Composable
private fun EmptyStatePrev() {
    EmptyStateContent(Modifier.fillMaxSize(),"adsadasd", painterResource(
        R.drawable.ic_empty_state_search
    ))
}