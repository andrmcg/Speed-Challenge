package com.example.androiddevchallenge.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun HomeScreen(){

}

@Preview
@Composable
fun HomeScreenPreview(){
    MyTheme {
        HomeScreen()
    }
}

@Preview
@Composable
fun HomeScreenDarkPreview(){
    MyTheme(darkTheme = true) {
        HomeScreen()
    }
}