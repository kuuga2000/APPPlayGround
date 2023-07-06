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

package com.example.marsphotos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import com.example.marsphotos.ui.MarsPhotosApp
import com.example.marsphotos.ui.theme.MarsPhotosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            MarsPhotosTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MarsPhotosApp()
                }
            }
        }
    }
}

/**
 * Conclusion ->
 *
 * Congratulations on completing this codelab and
 * refactoring the Mars Photos app to implement the repository pattern and dependency injection!
 *
 * The app's code is now following Android best practices for the data layer,
 * which means it is more flexible, robust, and easily scalable.
 *
 * These changes also helped make the app more easily testable.
 * This benefit is very important, as the code can continue to evolve while making sure it still behaves as expected.
 *
 * Don't forget to share your work on social media with #AndroidBasics!
 *
 *
 * Learn more ->
 *
 * Android developer documentation:
 * Dependency injection in Android https://developer.android.com/training/dependency-injection
 * Guide to app architecture - Data layer https://developer.android.com/topic/architecture/data-layer
 *
 * Other:
 * Coupling https://en.wikipedia.org/wiki/Coupling_(computer_programming)
 *
 * https://developer.android.com/static/codelabs/basic-android-kotlin-compose-add-repository/img/f7f372187c75f57f_856.png
 */
