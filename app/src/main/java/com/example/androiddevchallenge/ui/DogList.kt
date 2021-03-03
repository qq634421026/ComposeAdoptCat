package com.example.androiddevchallenge.ui


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.Dog
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun DogList(dogs: List<Dog>, onDogClick: (Dog) -> Unit = {}) {
    LazyColumn(
        Modifier.background(MaterialTheme.colors.secondary),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(dogs) { dog ->
            DogItem(
                dog,
                Modifier
                    .clickable {
                        onDogClick(dog)
                    }
                    .fillMaxWidth()
            )
        }
    }
}

@Composable
fun DogItem(dog: Dog, modifier: Modifier = Modifier) {
    Card(modifier) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Column {
                Text(dog.name, style = MaterialTheme.typography.h3)
                Text(dog.breed)
                Text(dog.location)
            }

            Image(
                painterResource(dog.picture),
                "Picture of dog: ${dog.name}",
                Modifier
                    .size(120.dp)
                    .padding(10.dp),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Preview
@Composable
fun DogListPreview() {
    val dogs = listOf(
        Dog(
            "Nala", "Pit Bull Terrier Mix", "Sunnyvale, CA",
            "Adult", "Female", "Large", R.drawable.img
        ),
        Dog(
            "Lulu", "Terrier Mix", "Sunnyvale, CA",
            "Young", "Female", "Medium", R.drawable.img
        ),
        Dog(
            "Billy", "American Staffordshire Terrier Mix", "Sunnyvale, CA",
            "Adult", "Male", "Large", R.drawable.img
        )
    )
    MyTheme {
        DogList(dogs)
    }
}

@Preview
@Composable
fun DogListPreviewDark() {
    val dogs = listOf(
        Dog(
            "Nala", "Pit Bull Terrier Mix", "Sunnyvale, CA",
            "Adult", "Female", "Large", R.drawable.img
        ),
        Dog(
            "Lulu", "Terrier Mix", "Sunnyvale, CA",
            "Young", "Female", "Medium", R.drawable.img
        ),
        Dog(
            "Billy", "American Staffordshire Terrier Mix", "Sunnyvale, CA",
            "Adult", "Male", "Large", R.drawable.img
        )
    )
    MyTheme(darkTheme = true) {
        DogList(dogs)
    }
}

@Preview
@Composable
fun DogItemPreview() {
    MyTheme {
        DogItem(
            Dog(
                "Nala", "Pit Bull Terrier Mix", "Sunnyvale, CA",
                "Adult", "Female", "Large", R.drawable.img
            )
        )
    }
}

@Preview
@Composable
fun DogItemPreviewDark() {
    MyTheme(darkTheme = true) {
        DogItem(
            Dog(
                "Nala", "Pit Bull Terrier Mix", "Sunnyvale, CA",
                "Adult", "Female", "Large", R.drawable.img
            )
        )
    }
}