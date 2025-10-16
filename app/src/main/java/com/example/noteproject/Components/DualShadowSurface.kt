package com.example.noteproject.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

@Composable
fun DualShadowSurface(
    modifier: Modifier = Modifier,
    color: Color,
    shape: Shape = RoundedCornerShape(15.dp),
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = modifier
            .drawBehind {
                // First shadow (left)
                drawRect(
                    color = Color.Black.copy(alpha = 0.4f),
                    topLeft = Offset(-5.dp.toPx(), 0f),
                    size = size,
                    alpha = 0.4f,
                    blendMode = BlendMode.SrcOver
                )

                // Second shadow (bottom)
                drawRect(
                    color = Color.Black.copy(alpha = 0.4f),
                    topLeft = Offset(0f, 5.dp.toPx()),
                    size = size,
                    alpha = 0.4f,
                    blendMode = BlendMode.SrcOver
                )
            }
            .clip(shape)
            .background(color, shape),
        content = content
    )
}
