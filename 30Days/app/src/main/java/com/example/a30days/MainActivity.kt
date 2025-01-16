package com.example.a30days

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a30days.ui.theme.A30DaysTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            A30DaysTheme {
                A30DaysApp()
            }
        }
    }
}

@Composable
fun A30DaysApp(modifier: Modifier = Modifier) {
    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {
            TopBar30Days()
        }
    ) {
        innerPadding ->
        DaysListItem(modifier = Modifier.padding(innerPadding))
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun TopBar30Days(modifier: Modifier = Modifier){
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.top_bar_title)
            )
        },
        modifier = modifier.padding(top = 8.dp)
    )
}

