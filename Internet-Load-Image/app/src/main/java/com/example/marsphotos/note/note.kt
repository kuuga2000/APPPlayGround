package com.example.marsphotos.note

/**
 * Display a downloaded image
 *
 * Displaying a photo from a web URL might sound straightforward,
 * but there is quite a bit of engineering to make it work well.
 * The image has to be downloaded, internally stored(cached),
 * and decoded from its compressed format to an image that Android can use.
 * You can cache the image to an in-memory cache, a storage-based cache, or both.
 * All this has to happen in low-priority background threads so the UI remains responsive.
 * Also, for the best network and CPU performance,
 * you might want to fetch and decode more than one image at once.
 *
 * Fortunately, you can use a community-developed library called Coil to download,
 * buffer, decode, and cache your images.
 * Without the use of Coil, you would have much more work to do.
 *
 * Coil basically needs two things:
 * The URL of the image you want to load and display.
 * An AsyncImage composable to actually display that image.
 *
 * link : Coil => https://coil-kt.github.io/coil/
 */