# 🔗 Links to Keep on Hand when Working with Composables

🔤 **Compose Basics**

* [A good place to start](https://developer.android.com/develop/ui/compose/layouts/basics)

* [Positioning with `Row` and `Column`](https://medium.com/@ramadan123sayed/mastering-jetpack-compose-rows-arrangements-weights-vertical-alignment-attributes-and-532248aca80b)

* [Compose Modifiers](https://developer.android.com/develop/ui/compose/modifiers)

* [`Card` composable](https://developer.android.com/develop/ui/compose/components/card)

🖌️ **Styling Text**

* [Size, color, weight, etc](https://developer.android.com/develop/ui/compose/text/style-text)

🖼️ **Working with Images**

### Save your pictures (WEBP and PNG) inside the `drawable` folder

![Where to Drop Pictures](/images/whereToSavePics.png)

✨ You can move your pictures in by copying them from where they are stored on your computer and pasting them into the folder where your project is saved. They will need to be saved in 

`\path\to\your\project\ProjectName\app\src\main\res\drawable`

⚠️ Using a JPG might cause the image to rotate. If this happens, use a site [https://jpg2png.com/](https://jpg2png.com/) like to convert it to a PNG.

* You'll then need to use a `painterResource()` to locate the exact picture you'll use for your `Image`.

```kotlin
Image(
    painter = painterResource(id = /*variable name*/),
    "Profile Picture",
    contentScale = ContentScale.Crop,
    modifier = Modifier.size(80.dp).clip(CircleShape)
)
```

> If you are grabbing your photo straight from the `drawable` folder, your `id` will look something like:

```kotlin
painter = painterResource(R.drawable.name_of_photo), "Content Description"
```

✨ The second parameter in `painterResource()` is `contentDescription`, which is a string used by accessiblity 

* [Customizing an `Image`](https://developer.android.com/develop/ui/compose/graphics/images/customize)

🔃 **Icons**

* [How to use an `Icon`](https://developer.android.com/develop/ui/compose/graphics/images/material)

* [Library of `Icons`](https://fonts.google.com/icons)

🚀 **Additional Topics**

* [Making a `List` in Compose](https://developer.android.com/develop/ui/compose/lists)

* [Data Classes in Kotlin](https://www.baeldung.com/kotlin/data-classes)

* [Modifiers](https://developer.android.com/develop/ui/compose/modifiers)