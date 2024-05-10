package com.appcognito.testcodes.navigation

sealed class Screens(var route: String) {

    object  Home : Screens("home")
    object  ImagePicker : Screens("ImagePicker")
    object  MultipleImagePicker : Screens("MultipleImagePicker")
    object  Setting : Screens("setting")
}