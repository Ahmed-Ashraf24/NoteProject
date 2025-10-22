package com.example.noteproject.Presentation.Components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.noteproject.R

@Composable
fun CustomSearchBar(
    query: String,
    label: String,
    onQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {

    Surface(modifier, shape = RoundedCornerShape(50.dp), color = _root_ide_package_.com.example.noteproject.Presentation.theme.customButtonColor){
        Row (horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically){
            BasicTextField(
                modifier=Modifier.padding(start = 38.dp, top = 11.dp, bottom = 12.dp),
                value = query,
                onValueChange = onQueryChange,
                singleLine = true,
                textStyle = _root_ide_package_.com.example.noteproject.Presentation.theme.Typography.bodyMedium.copy(color = Color.White),
                decorationBox = { innerTextField ->
                    if (query.isEmpty()) Text(label, style = _root_ide_package_.com.example.noteproject.Presentation.theme.Typography.bodyMedium, color = _root_ide_package_.com.example.noteproject.Presentation.theme.whiteColor)
                    innerTextField()
                }
            )
            Icon(painter = painterResource(R.drawable.ic_cancel),
                "cancel searching",
                tint = _root_ide_package_.com.example.noteproject.Presentation.theme.whiteColor,
                modifier = Modifier.padding(top = 14.dp, end = 20.dp, bottom = 12.dp)
            )
        }
    }
}

@Preview
@Composable
private fun SearchBarPreview() {
    CustomSearchBar( query = "", label = "hello", onQueryChange = {})

}