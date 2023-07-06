/**
 * Introduction
 *
 * In previous codelabs, you learned how to get data from a web service using a repository pattern and parse the response into a Kotlin object.
 * In this codelab, you build on that knowledge to load and display photos from a web URL. You also revisit how to build a LazyVerticalGrid and use it to display a grid of images on the overview page.
 *
 * Prerequisites
 * Knowledge of how to retrieve JSON from a REST web service and the parsing of that data into Kotlin objects using the Retrofit and Gson libraries
 * Knowledge of a REST web service
 * Familiarity with Android architecture components, such as a data layer and repository
 * Knowledge of dependency injection
 * Knowledge of ViewModel and ViewModelProvider.Factory
 * Knowledge of coroutine implementation for your app
 * Knowledge of the repository pattern
 *
 * What you'll learn
 * How to use the Coil library to load and display an image from a web URL.
 * How to use a LazyVerticalGrid to display a grid of images.
 * How to handle potential errors as the images download and display.
 *
 * What you'll build
 * Modify the Mars Photos app to get the image URL from the Mars data, and use Coil to load and display that image.
 * Add a loading animation and error icon to the app.
 * Add status and error handling to the app.
 *
 *
 * What you'll need
 * A computer with a modern web browser, such as the latest version of Chrome
 * Starter code for the Mars Photos app with REST web services
 */