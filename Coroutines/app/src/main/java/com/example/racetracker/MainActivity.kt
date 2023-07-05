/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.racetracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.racetracker.ui.RaceTrackerApp
import com.example.racetracker.ui.theme.RaceTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RaceTrackerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    RaceTrackerApp()
                }
            }
        }
    }
}

/**
 * Structured concurrency ->
 *
 * The way you write code using coroutines is called structured concurrency.
 * This style of programming improves the readability and development time of your code.
 * The idea of structured concurrency is that coroutines have a hierarchy—tasks might launch subtasks,
 * which might launch subtasks in turn. The unit of this hierarchy is referred to as a coroutine scope.
 * Coroutine scopes should always be associated with a lifecycle.
 *
 * The Coroutines APIs adhere to this structured concurrency by design.
 * You cannot call a suspend function from a function which is not marked suspend.
 * This limitation ensures that you call the suspend functions from coroutine builders,
 * such as launch. These builders are, in turn, tied to a CoroutineScope.
 *
 * https://developer.android.com/static/codelabs/basic-android-kotlin-compose-coroutines-android-studio/img/8cb11ef243cb088_856.png
 */