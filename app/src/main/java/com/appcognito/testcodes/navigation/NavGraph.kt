package com.appcognito.testcodes.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.appcognito.testcodes.screens.HomeScreen
import com.appcognito.testcodes.screens.QRscanner
import com.appcognito.testcodes.screens.MultipleImagePickerScreen
import com.appcognito.testcodes.screens.ImagePickerScreen

/**
 * @author Coding Meet
 * Created 17-01-2024 at 02:22 pm
 */

@Composable
fun SetUpNavGraph(
    navController: NavHostController,
    innerPadding: PaddingValues
) {
    NavHost(navController = navController,
        startDestination = Screens.Home.route){
        composable(Screens.Home.route){
            HomeScreen(innerPadding = innerPadding)
        }
        composable(Screens.MultipleImagePicker.route){
            MultipleImagePickerScreen(innerPadding = innerPadding)
        }
        composable(Screens.ImagePicker.route){
            ImagePickerScreen(innerPadding = innerPadding)
        }
        composable(Screens.QRscanner.route){
            QRscanner(innerPadding = innerPadding)
        }
    }
}