package com.appcognito.testcodes.screens

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun ImagePickerScreen(innerPadding: PaddingValues) {
    var selectedImageUri by remember {
        mutableStateOf<Uri?>(null)
    }

    val photoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = {selectedImageUri = it }
    )

    Column(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(Color.White),
//        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally 
    ) {
        Text(
            text = "Choose a Beautiful Photo",
            fontSize = 24.sp,
            color = Color.Black
        )
        Spacer(modifier = Modifier.size(20.dp))

        Button(modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
            shape = RoundedCornerShape(8.dp),
            colors= ButtonDefaults.buttonColors(
                containerColor = Color.Blue,
                contentColor = Color.Cyan
            ),
            onClick = {
                photoPickerLauncher.launch(
                    PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                )
            }
        ) {
            Row(modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(painter = painterResource(id = android.R.drawable.ic_input_add),
                    contentDescription = "Add Image")
                Text(text = "이미지 선택", style= TextStyle(fontSize = 18.sp))
            }
        }

        AsyncImage(
            modifier = Modifier.fillMaxWidth().height(240.dp)
                .clip(RoundedCornerShape(8.dp)),
            model = selectedImageUri,
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )



    }
}

@Preview
@Composable
fun ImagePickerScreenPreview() {
    ImagePickerScreen(innerPadding = PaddingValues(all = 10.dp))
}