package com.example.noteproject.Presentation.Components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.noteproject.R


@Composable
fun CustomDialog(modifier: Modifier = Modifier, onDismiss: () -> (Unit), onConfirm:  () -> (Unit)) {
   
    AlertDialog(
        modifier=modifier,
        containerColor = _root_ide_package_.com.example.noteproject.Presentation.theme.backGroundColor,
        onDismissRequest = onDismiss,
        confirmButton = {
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top,
            ) {
                Button(onClick = onDismiss,
                    modifier = Modifier,
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
                    ){
                    Text("discard")
                }

                Button(onClick = onConfirm,
                    modifier = Modifier,
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = _root_ide_package_.com.example.noteproject.Presentation.theme.greenButtonColor),
                ){
                    Text("confirm")
                }

            }
        },
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    painter = painterResource(R.drawable.info_outline),
                    contentDescription = "",
                    tint = Color.Gray
                )
            }
        },
        text = {
            Text(
                text = "Save changes?",
                color = Color.White,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }

    )
}

@Preview(showSystemUi = true)
@Composable
private fun DialogScreenPrev() {

    CustomDialog(Modifier,{},{})


}