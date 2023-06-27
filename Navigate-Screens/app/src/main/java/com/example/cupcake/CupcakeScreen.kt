/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.cupcake

import android.content.Context
import android.content.Intent
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.cupcake.data.DataSource.flavors
import com.example.cupcake.data.DataSource.quantityOptions
import com.example.cupcake.ui.OrderSummaryScreen
import com.example.cupcake.ui.OrderViewModel
import com.example.cupcake.ui.SelectOptionScreen
import com.example.cupcake.ui.StartOrderScreen

/**
 * enum values that represent the screens in the app
 */
enum class CupcakeScreen(@StringRes val title: Int) {
    Start(title = R.string.app_name),
    Flavor(title=R.string.flavor),
    Pickup(title=R.string.choose_pickup_date),
    Summary(title=R.string.order_summary)
}

/**
 * Composable that displays the topBar and displays back button if back navigation is possible.
 */
@Composable
fun CupcakeAppBar(
    currentScreen: CupcakeScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(currentScreen.title)) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}

@Composable
fun CupcakeApp(
    viewModel: OrderViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = CupcakeScreen.valueOf(
        backStackEntry?.destination?.route ?: CupcakeScreen.Start.name
    )
    Scaffold(
        topBar = {
            CupcakeAppBar(
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = {
                    navController.navigateUp()
                },
                currentScreen = currentScreen
            )
        }
    ) { innerPadding ->
        val uiState by viewModel.uiState.collectAsState()

        NavHost(
            navController = navController,
            startDestination = CupcakeScreen.Start.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route= CupcakeScreen.Start.name) {
                StartOrderScreen(
                    quantityOptions = quantityOptions,
                    onNextButtonClicked = {
                        viewModel.setQuantity(it)
                        navController.navigate(CupcakeScreen.Flavor.name)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(id = R.dimen.padding_medium))
                )
            }
            composable(route= CupcakeScreen.Flavor.name) {
                val context = LocalContext.current
                SelectOptionScreen(
                    subtotal = uiState.price,
                    onNextButtonClicked = {navController.navigate(CupcakeScreen.Pickup.name)},
                    onCancelButtonClicked = {
                        cancelOrderAndNavigateToStart(viewModel, navController)
                    },
                    options = flavors.map{
                        id -> context.resources.getString(id)
                    },
                    onSelectionChanged = {
                        viewModel.setFlavor(it)
                    },
                    modifier = Modifier.fillMaxHeight()
                )
            }
            composable(route = CupcakeScreen.Pickup.name) {
                SelectOptionScreen(
                    subtotal = uiState.price,
                    options = uiState.pickupOptions,
                    onNextButtonClicked = {
                        navController.navigate(CupcakeScreen.Summary.name)
                    },
                    onCancelButtonClicked = {
                        cancelOrderAndNavigateToStart(viewModel, navController)
                    },
                    onSelectionChanged = {
                        viewModel.setDate(it)
                    },
                    modifier = Modifier.fillMaxHeight()
                )
            }
            composable(route = CupcakeScreen.Summary.name) {
                val context = LocalContext.current
                OrderSummaryScreen(
                    orderUiState = uiState,
                    onCancelButtonClicked = {
                        cancelOrderAndNavigateToStart(viewModel, navController)
                    },
                    onSendButtonClicked = {
                        subject: String,
                        summary: String ->
                            shareOrder(context, subject = subject, summary = summary)
                    },
                    modifier = Modifier.fillMaxHeight()
                )
            }
        }
    }
}

/**
 * Resets the [OrderUiState] and pops up to [CupcakeScreen.Start]
 */
private fun cancelOrderAndNavigateToStart(
    viewModel: OrderViewModel,
    navController: NavHostController
) {
    viewModel.resetOrder()
    navController.popBackStack(CupcakeScreen.Start.name, inclusive = false)
}

/**
 * Creates an intent to share order details
 */
private fun shareOrder(
    context: Context,
    subject: String,
    summary: String
) {
    // Create an ACTION_SEND implicit intent with order details in the intent extras
    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_SUBJECT, subject)
        putExtra(Intent.EXTRA_TEXT, summary)
    }
    context.startActivity(
        Intent.createChooser(
            intent,
            context.getString(R.string.new_cupcake_order)
        )
    )
}


/**
 * In modern Android development,
 * multiscreen apps are created using the Jetpack Navigation component.
 * The Navigation Compose component allows you to easily build multi screen apps in Compose using a declarative approach,
 * just like building user interfaces. This codelab introduces the essentials of the Navigation Compose component,
 * how to make the AppBar responsive,
 * and how to send data from your app to another app using intents—all while demonstrating best practices in an increasingly complex app.
 *
 * What you'll learn ->
 * Create a NavHost composable to define routes and screens in your app.
 * Navigate between screens using a NavHostController.
 * Manipulate the backstack to navigate to previous screens.
 * Use intents to share data with another app.
 * Customize the AppBar, including the title and back button.
 *
 *
 * What you'll build ->
 * You'll implement navigation in a multiscreen app.
 *
 * What you'll need ->
 * The latest version of Android Studio
 * An internet connection to download the starter code
 *
 * Define routes and create a NavHostController ->
 * Parts of the Navigation Component
 * The Navigation component has three main parts:
 *
 * NavController: Responsible for navigating between destinations—that is, the screens in your app.
 * NavGraph: Maps composable destinations to navigate to.
 * NavHost: Composable acting as a container for displaying the current destination of the NavGraph.
 * In this codelab, you'll focus on the NavController and the NavHost. Within the NavHost,
 * you'll define the destinations for the Cupcake app's NavGraph.
 *
 * Note*
 * NavHostController is a subclass of the NavController class that provides additional functionality for use with a NavHost composable.
 *
 * There are two notable parameters.
 * navController: An instance of the NavHostController class. You can use this object to navigate between screens,
 * for example, by calling the navigate() method to navigate to another destination.
 * You can obtain the NavHostController by calling rememberNavController() from a composable function.
 * startDestination: A string route defining the destination shown by default when the app first displays the NavHost.
 * In the case of the Cupcake app, this should be the Start route.
 * Like other composables, NavHost also takes a modifier parameter.
 *
 * Note*
 * You should now be able to navigate through each screen of your app.
 * Notice that by calling navigate(), not only does the screen change,
 * but it's actually placed on top of the backstack.
 * Also, when you press the system back button, you can navigate back to the previous screen.
 * The app stacks each screen on top of the previous one, and the back button ( bade5f3ecb71e4a2.png) can remove them.
 * The history of screens from the startDestination at the bottom to the topmost screen that was just shown is known as the backstack.
 *
 * Doc ->
 * Send simple data to other apps
 * https://developer.android.com/training/sharing/send#kotlin
 *
 * Summary
 * Learn More ->
 *  - Navigating with Compose https://developer.android.com/jetpack/compose/navigation
 *  - Navigation principles https://developer.android.com/guide/navigation/navigation-principles
 *  - Jetpack Compose Navigation https://developer.android.com/codelabs/jetpack-compose-navigation#0
 *  - Types of Navigation https://material.io/design/navigation/understanding-navigation.html
 */