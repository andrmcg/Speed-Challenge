package com.example.androiddevchallenge.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Spa
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun HomeScreen() {
    var searchText by remember{ mutableStateOf("")}
    Scaffold(bottomBar = {
        MySmootheBottomAppBar()
    }) {

        Column(modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp)) {
            Spacer(modifier = Modifier.height(56.dp))
            TextField(value = searchText, onValueChange = { searchText = it },label = {
                Row(verticalAlignment = Alignment.Bottom){
                    Icon(imageVector = Icons.Default.Search, contentDescription = "",modifier = Modifier.size(18.dp))
                    Text(text = "Search",
                        style = MaterialTheme.typography.body1)
                }
            }, modifier = Modifier.fillMaxWidth())
            Text(text = stringResource(id = R.string.favorite_collections), modifier = Modifier.paddingFromBaseline(top = 40.dp),
                style = MaterialTheme.typography.h2)

            //  Collection Cards

        }

    }
}

@Composable
fun MySmootheBottomAppBar(){
    BottomAppBar(modifier = Modifier,backgroundColor = MaterialTheme.colors.background, elevation = 8.dp) {
        BottomNavigationItem(selected = true, onClick = { /*TODO*/ },icon = { Icon(
            imageVector = Icons.Default.Spa,
            contentDescription = "Home",modifier = Modifier.size(18.dp)
        )},label = {Text(text = "HOME", style = MaterialTheme.typography.caption)})
        BottomNavigationItem(selected = false, onClick = { /*TODO*/ },icon = { Icon(
            imageVector = Icons.Default.AccountCircle,
            contentDescription = "Profile",modifier = Modifier.size(18.dp)
        )},label = {Text(text = "PROFILE", style = MaterialTheme.typography.caption)})
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    MyTheme {
        HomeScreen()
    }
}

@Preview
@Composable
fun HomeScreenDarkPreview() {
    MyTheme(darkTheme = true) {
        HomeScreen()
    }
}