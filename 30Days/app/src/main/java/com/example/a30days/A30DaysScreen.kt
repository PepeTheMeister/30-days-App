package com.example.a30days

import android.content.res.Configuration
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a30days.model.Day
import com.example.a30days.repository.DaysRepository.days
import com.example.a30days.ui.theme.A30DaysTheme


@Composable
fun DaysListItem(modifier: Modifier = Modifier){
    LazyColumn (
        modifier = modifier
    ){
        items(days){ item ->
            DayItem(
                day = item, numDay = days.indexOf(item) + 1,
                modifier = Modifier.padding(vertical = 8.dp,
                    horizontal = 16.dp), color = MaterialTheme.colorScheme.onBackground)
        }
    }
}




@Composable
fun DayItem(modifier: Modifier = Modifier, numDay: Int, day: Day, color: Color){
    var expanded by remember { mutableStateOf(false) }
    Card(
        elevation = CardDefaults.cardElevation(2.dp),
        modifier = modifier.animateContentSize(
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioNoBouncy,
                stiffness = Spring.StiffnessMedium
            ))
            .background(MaterialTheme.colorScheme.background),
        onClick = { expanded = !expanded }
    ){
        Column (
            modifier = Modifier.fillMaxWidth()
                .padding(16.dp)
        ){
            Text(
                text = "Day $numDay",
                style = MaterialTheme.typography.bodySmall,
                color = color
            )
            Text(
                text = stringResource(day.title),
                style = MaterialTheme.typography.bodyLarge,
                color = color
            )
            Image(
                painter = painterResource(day.img),
                contentDescription = null
            )
            Spacer(modifier = Modifier.height(8.dp))
            if(expanded){
                Text(
                    text = stringResource(day.descr),
                    style = MaterialTheme.typography.bodyMedium,
                    color = color
                )
            }

        }
    }
}




@Preview("Light Theme", showSystemUi = true)
@Preview("Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES, showSystemUi = true)
@Composable
fun GreetingPreview() {
    A30DaysTheme {
        DayItem(numDay= 1,
            day = Day(title = R.string.title1,
                descr = R.string.desc1,
                img = R.drawable.photo1,
                ),
            color = MaterialTheme.colorScheme.onBackground
            )
    }
}