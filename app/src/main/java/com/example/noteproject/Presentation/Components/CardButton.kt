package com.example.noteproject.Presentation.Components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.noteproject.R

@Composable
fun CustomCardButton(
    modifier: Modifier,
    imageVector: ImageVector,
    surfaceBackground: Color,
    alphaValue: Float,
    shape: Shape,
    onClicked: () -> (Unit),
    shadowEvaluation: Int,
    iconPadding:Int,
    description: String?
) {

    Surface(
        modifier = modifier.shadow(shadowEvaluation.dp,shape),
        shape = shape,
        onClick = onClicked,
        color = surfaceBackground.copy(alphaValue),

    ) {
        Icon(imageVector = imageVector,
            contentDescription = description,
            tint = Color.White,
            modifier = Modifier
                .padding(iconPadding.dp)
                .fillMaxSize()

        )
    }

}

@Preview(showSystemUi = true)
@Composable
private fun CardButton() {
    Row(Modifier
        .fillMaxSize()
        .padding(top = 15.dp)
        .background(_root_ide_package_.com.example.noteproject.Presentation.theme.backGroundColor), horizontalArrangement = Arrangement.End) {
    CustomCardButton(
        modifier = Modifier.size(50.dp),
       imageVector = ImageVector.vectorResource(R.drawable.search),
        surfaceBackground = _root_ide_package_.com.example.noteproject.Presentation.theme.customButtonColor,
        onClicked = {},
        description = "preview",
        alphaValue = 1f,
        shape = RoundedCornerShape(15.dp),
        shadowEvaluation = 8,
        iconPadding = 12
    )
    }
}