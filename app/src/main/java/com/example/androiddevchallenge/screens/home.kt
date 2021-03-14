package com.example.androiddevchallenge.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Spa
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import com.example.androiddevchallenge.*
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun HomeScreen() {
    var searchText by remember { mutableStateOf("") }
    val mainState = rememberScrollState()
    val xFabOffset = -148.dp
    val yFabOffset = 44.dp
    Scaffold(scaffoldState = rememberScaffoldState(), bottomBar = {
        MySmootheBottomAppBar()
    }, floatingActionButton = {
        FloatingActionButton(
            onClick = { /*TODO*/ },
            backgroundColor = MaterialTheme.colors.primary,
            modifier = Modifier.offset(x = xFabOffset, y = yFabOffset)
        ) {
            Icon(
                imageVector = Icons.Default.PlayArrow,
                contentDescription = "Play",
                modifier = Modifier.size(24.dp)
            )
        }
    }) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp)
                .verticalScroll(state = mainState)
        ) {
            Spacer(modifier = Modifier.height(56.dp))
            TextField(value = searchText, onValueChange = { searchText = it }, label = {
                Row(verticalAlignment = Alignment.Bottom) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "",
                        modifier = Modifier.size(18.dp)
                    )
                    Text(
                        text = "Search",
                        style = MaterialTheme.typography.body1
                    )
                }
            }, modifier = Modifier.fillMaxWidth())
            Text(
                text = stringResource(id = R.string.favorite_collections),
                modifier = Modifier.paddingFromBaseline(top = 40.dp),
                style = MaterialTheme.typography.h2
            )
            Spacer(modifier = Modifier.height(8.dp))
            //  Collection Cards
            val fcState1 = rememberScrollState()
            val fcState2 = rememberScrollState()
            val topList = favouriteCollectionImageResources.subList(0, 3)
            val bottomList = favouriteCollectionImageResources.subList(3, 6)
            CollectionCards(topList, fcState1)
            Spacer(modifier = Modifier.height(8.dp))
            CollectionCards(assetList = bottomList, state = fcState2)
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(id = R.string.align_your_body),
                modifier = Modifier.paddingFromBaseline(top = 40.dp),
                style = MaterialTheme.typography.h2
            )
            Spacer(modifier = Modifier.height(8.dp))
            //  Align Your Body Items
            val bodyState = rememberScrollState()
            ScrollingRowComposable(alignYourBodyImageResources, bodyState)

            Text(
                text = stringResource(id = R.string.align_your_mind),
                modifier = Modifier.paddingFromBaseline(top = 40.dp),
                style = MaterialTheme.typography.h2
            )
            Spacer(modifier = Modifier.height(8.dp))
            //  Align Your Mind Items
            val mindState = rememberScrollState()
            ScrollingRowComposable(alignYourMindImageResources, mindState)
        }

    }
}

@Composable
fun ScrollingRowComposable(imageResources: List<Asset>, state: ScrollState) {
    Row(Modifier.horizontalScroll(state)) {
        imageResources.forEach {
            Column(
                modifier = Modifier.wrapContentWidth()
                    .padding(end = 8.dp)
            ) {
                Surface(
                    shape = CircleShape, modifier = Modifier
                        .size(88.dp)
                ) {
                    Image(
                        painter = painterResource(id = it.imageResource),
                        contentDescription = it.imageName,
                        contentScale = ContentScale.Crop
                    )
                }
                Text(
                    text = it.imageName,
                    modifier = Modifier
                        .paddingFromBaseline(24.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun CollectionCards(assetList: List<Asset>, state: ScrollState) {
    Row(
        modifier = Modifier
            .horizontalScroll(state)
    ) {
        assetList.forEach {
            Card(
                modifier = Modifier
                    .size(192.dp, 56.dp)
                    .padding(end = 8.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = it.imageResource),
                        contentDescription = it.imageName,
                        modifier = Modifier.size(56.dp),
                        contentScale = ContentScale.FillBounds
                    )
                    Text(
                        text = it.imageName,
                        modifier = Modifier.padding(start = 16.dp),
                        style = MaterialTheme.typography.h3
                    )
                }
            }
        }
    }
}

@Composable
fun MySmootheBottomAppBar() {
    BottomAppBar(modifier = Modifier, backgroundColor = Color.Transparent, elevation = 8.dp) {
        BottomNavigationItem(selected = true, onClick = { /*TODO*/ }, icon = {
            Icon(
                imageVector = Icons.Default.Spa,
                contentDescription = "Home", modifier = Modifier.size(18.dp)
            )
        }, label = { Text(text = "HOME", style = MaterialTheme.typography.caption) })
        BottomNavigationItem(selected = false, onClick = { /*TODO*/ }, icon = {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = "Profile", modifier = Modifier.size(18.dp)
            )
        }, label = { Text(text = "PROFILE", style = MaterialTheme.typography.caption) })
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