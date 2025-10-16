package com.example.noteproject.Components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.noteproject.R
import com.example.noteproject.ui.theme.customButtonColor

@Composable
fun NewNoteTopBar(modifier: Modifier = Modifier, onBackClicked: () -> (Unit), onSaveClicked: ()->(Unit)){
    Row(
        modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row {
            CustomCardButton(
                modifier = Modifier.size(48.dp),
                imageVector = ImageVector.vectorResource(R.drawable.ic_back),
                surfaceBackground = customButtonColor,
                onClicked = onBackClicked,
                description = "preview",
                alphaValue = 1f,
                shape = RoundedCornerShape(15.dp),
                shadowEvaluation = 8,
                iconPadding = 11
            )        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(21.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            CustomCardButton(
                modifier = Modifier.size(50.dp),
                imageVector = ImageVector.vectorResource(R.drawable.ic_seen),
                surfaceBackground = customButtonColor,
                onClicked = {},
                description = "preview",
                shape = RoundedCornerShape(15.dp),
                alphaValue = 1f,
                shadowEvaluation = 8,
                iconPadding = 12
            )
            CustomCardButton(
                modifier = Modifier.size(50.dp),
                imageVector = ImageVector.vectorResource(R.drawable.ic_save),
                surfaceBackground = customButtonColor,
                onClicked = onSaveClicked,
                description = "preview",
                shape = RoundedCornerShape(15.dp),
                alphaValue = 1f,
                shadowEvaluation = 8,
                iconPadding = 12
            )
        }
    }
}

@Composable
fun EditNoteTopBar(modifier: Modifier = Modifier, onBackClicked:()->(Unit), onEditClicked:()->(Unit)) {
    Row(
        modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row {
            CustomCardButton(
                modifier = Modifier.size(48.dp),
                imageVector = ImageVector.vectorResource(R.drawable.ic_back),
                surfaceBackground = customButtonColor,
                onClicked = onBackClicked,
                description = "preview",
                alphaValue = 1f,
                shape = RoundedCornerShape(15.dp),
                shadowEvaluation = 8,
                iconPadding = 12
            )        }
        Row(

            verticalAlignment = Alignment.CenterVertically
        ) {

            CustomCardButton(
                modifier = Modifier.size(50.dp),
                imageVector = ImageVector.vectorResource(R.drawable.ic_edit),
                surfaceBackground = customButtonColor,
                onClicked = onEditClicked,
                description = "preview",
                shape = RoundedCornerShape(15.dp),
                alphaValue = 1f,
                shadowEvaluation = 8,
                iconPadding = 13
            )
        }
    }
}
