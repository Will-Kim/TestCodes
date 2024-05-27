package com.appcognito.testcodes.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.appcognito.testcodes.dialogs.QRdialog

@Composable
fun QRscanner(innerPadding: PaddingValues) {
    val code = remember {
        mutableStateOf(" ")
    }
    val showQRdialog = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
            Button(
                modifier = Modifier
                    .padding(start = 22.dp, end = 22.dp, top = 80.dp)
                    .fillMaxWidth()
                    .height(48.dp),
                onClick = {
                    // show the QRCode Reading Dialog
                    showQRdialog.value = true
                }
            ) {
                Text("Get QR Code")
            }

            Text(
                text = code.value,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp)
            )
            if (showQRdialog.value) {
                QRdialog(
                    onDismiss = {
                        showQRdialog.value = false
                    },
                    onConfirm = {
                        // handle the code detected
                        code.value = it
                    })

            }
    }
}