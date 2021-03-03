package com.example.androiddevchallenge

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.data.Dog

class MainViewModel : ViewModel() {
    val dogs by mutableStateOf(
        listOf(
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
            ),
            Dog(
                "Arnie", "Chihuahua Mix", "Mountain View, CA",
                "Young", "Male", "Small", R.drawable.img
            ),
            Dog(
                "Doby", "Mountain Dog", "Sunnyvale, CA",
                "Puppy", "Female", "Medium", R.drawable.img
            ),
            Dog(
                "Bowen", "Mountain Dog", "Sunnyvale, CA",
                "Puppy", "Male", "Medium", R.drawable.img
            ),
            Dog(
                "Rumi", "Border Collie", "Los Altos, CA",
                "Young", "Male", "Medium", R.drawable.img
            ),
            Dog(
                "Mikey", "Chihuahua & Rat Terrier Mix", "Santa Clara, CA",
                "Young", "Male", "Medium", R.drawable.img
            ),
            Dog(
                "Layla", "Chihuahua & Terrier Mix", "Santa Clara, CA",
                "Young", "Female", "Medium", R.drawable.img
            ),
            Dog(
                "Tessie", "Pit Bull Terrier Mix", "Santa Clara, CA",
                "Adult", "Female", "Large", R.drawable.img
            ),
            Dog(
                "Sia", "Pit Bull Terrier", "Santa Clara, CA",
                "Young", "Female", "Medium", R.drawable.img
            ),
        )
    )

    var currentDog: Dog? by mutableStateOf(null)

    fun showDog(dog: Dog) {
        currentDog = dog
    }

    fun closeDog() {
        currentDog = null
    }
}