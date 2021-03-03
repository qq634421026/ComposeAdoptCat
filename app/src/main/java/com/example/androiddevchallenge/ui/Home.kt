package com.example.androiddevchallenge.ui

import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import com.example.androiddevchallenge.MainViewModel
import kotlinx.coroutines.launch
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun Home() {
    val snackbarHostState = SnackbarHostState()
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Puppy Finder")
                }
            )
        },
        snackbarHost = {
            SnackbarHost(snackbarHostState)
        }
    ) {
        val viewModel: MainViewModel = viewModel()
        val currentDog = viewModel.currentDog
        DogList(viewModel.dogs) { dog ->
            if (currentDog == null) {
                viewModel.showDog(dog)
            }
        }
        if (currentDog != null) {
            DogDetails(currentDog) {
                coroutineScope.launch {
                    snackbarHostState.showSnackbar("You have adopted ${currentDog.name}")
                }
            }
        }
    }
}