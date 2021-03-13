package com.example.androiddevchallenge.screens

import android.text.style.StyleSpan
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.*
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun LoginScreen() {
    Image(
        painter = painterResource(id = if (isSystemInDarkTheme()) R.drawable.dark_login else R.drawable.light_login),
        contentDescription = "Login Screen",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )

    Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(200.dp))
        Text(text = stringResource(id = R.string.log_in),modifier = Modifier.padding(bottom = 32.dp),style = MaterialTheme.typography.h1)
        TextField(value = "", onValueChange = { /*TODO*/ },modifier = Modifier.fillMaxWidth().height(56.dp),label = {Text(text = "Email Address", style = MaterialTheme.typography.body1)})
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(8.dp))
        TextField(value = "", onValueChange = { /*TODO*/ },modifier = Modifier.fillMaxWidth().height(56.dp),label = {Text(text = "Password", style = MaterialTheme.typography.body1)})
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(8.dp))
        Button(onClick = { /*TODO*/ },modifier = Modifier
            .fillMaxWidth()
            .height(72.dp), shape = MaterialTheme.shapes.medium) {
            Text(text = stringResource(id = R.string.log_in))
        }

        val signUpText = buildAnnotatedString { append(stringResource(id = R.string.sign_up1))
            append(" ")
            withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)){append(
                stringResource(id = R.string.sign_up2))}
        }

        Text(text = signUpText, style = MaterialTheme.typography.body1, modifier = Modifier.paddingFromBaseline(top = 32.dp))
    }

}

@Preview
@Composable
fun LoginScreenPreview() {
    MyTheme {
        Surface(color = MaterialTheme.colors.background) {
            LoginScreen()
        }
    }
}

@Preview
@Composable
fun LoginScreenDarkPreview() {
    MyTheme(darkTheme = true) {
        Surface(color = MaterialTheme.colors.background) {
            LoginScreen()
        }
    }
}