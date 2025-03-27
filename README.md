# UI-Workshop

Follow along with the presentation and use this guide to help you get started on making your own screens using Jetpack Compose.

## 📝 **Getting Started**

1. Open **Android Studio**.
2. Create a **New Project** → Select **Empty Compose Activity**.
![new project window](/images/new_project.png)

3. Name your project (Only letters, numbers, and _. No dashes). Also confirm that your project is saving in your desired location.
4. Accept the default settings for `Package name` and  **Minimum SDK**. As of today, that is `API 24`.
5. Click **Finish**. It might take a few minutes to get everything set up.

## 📐 **Plan out your Screen**

* It's good to have a plan before you jump right into coding.

* It doesn't need to be perfect, and you'll often change your idea as you proceed.

* Consider the essential elements and their relative positions to other elements on the screen. As your include multiple screens, consider how they will link together. Where does each button tap take the user? What will be the first screen seen when opening the app?

### **Example: Profile Screen**
![screen wireframe](/images/ScreenDrawing.png)

* Think about how you can divide your design into rows and columns. With a vertical screen like this, you'll often need a **`column`** to align items that are stacked on top of each other, like the photo, profile name, quote, and email.

* Use a **`Row`** for elements that are arranged in a row, such as each Friend entry. The friend pic, name, and three dot icon can be placed in a row, and that row placed in a column to keep track of the list of friends.

![screen wireframe marked](/images/ScreenDrawingMarked.png)

## 📁 File Organization

### 🙋‍♀️ Where to place images

* Be sure to paste your images into the following folder:

`\path\to\your\project\ProjectName\app\src\main\res\drawable`

⚠️ Using a JPG might cause the image to rotate. If this happens, use a site [https://jpg2png.com/](https://jpg2png.com/) like to convert it to a PNG.

### 📱Where to place screens

* Create a new `kotlin file`, **`YourScreen`**, located within th **`ui`** folder.

✨ If you accidentally make the new file in the wrong folder, move it by right clicking, choose **Refactor > Move** and select the correct folder.

✨ Keeping your files organized will make it easier to work with, especially when you add in more screens, elements, databases, etc. In my own projects, I place all screens in their own **`screens`** folder.

![save screens here](/images/WhereToSaveScreens.png)
*Place your screens here in the `ui` folder*

## 🖼️ Starting your First Screen

![new kotlin file](/images/KotlinFile.png)
*Right click on the folder where you are saving your screens*

![kotlin file 2](/images/KotlinFile2.png)
*You don't need to add the .kt, just the file name*

* Your new file should only consist of the package declaration at the top. If you have class code, delete that. (It just means you selected class instead of file, but it's okay!)

* Start by making your first Composable function. Then add in the first **`Column`**.

```kotlin
@Composable
fun ProfileScreen() {
    Column() {

    }
}
```

![choose an object](/images/Import.png)

* This window will appear to suggest objects you might want to use. We know the first option is the correct one because it has the Compose symbol. Don't just choose the first one! It won't always the the one you're looking for.

## Adding in Text

* At the bare minimum, **`Text`** composables consist of the string of text, and can take in optional parameters.

```kotlin
Text(
    "My Profile",
    fontSize = 30.sp,
    modifier = Modifier.padding(vertical = 20.dp)
)
```

* The basic text styling featuers you'd expect to see, such as font size, weight (bold, italic), color, shadow, etc can be found [here](https://developer.android.com/develop/ui/compose/text/style-text).

✨ **Modifiers** are different. They allow you to add padding, sizing, make things clickable, etc. All composables can use modifiers. Read more about them [here](https://developer.android.com/develop/ui/compose/modifiers).

## We Need a Preview!

![split mode](/images/SplitMode.png)

* In order to see your code and a preview at the same time, use split mode.

* Add this preview function to the bottom of your screen file:

```kotlin
@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}
```

## Add in more Elements: Image

* For the profile picture, experiment with the size and shape that looks good to you

```kotlin
Image(
    painter = painterResource(id = R.drawable.sarah_crop),
    "Profile Picture",
    contentScale = ContentScale.Crop,
    modifier = Modifier.padding(vertical = 20.dp).size(200.dp).clip(CircleShape)
)
```

✨ Want to try something different? Instead of `clip(CircleShape)`, try `clip(RoundedCornerShape(16.dp))`

✨ Note: I cropped my photo to a square ahead of time so that it would be centered when I applied the `CircleShape` modifier.

## Add in the other Text Elements

* It's time we add in some sizing and spacing. This is a lot of trial and error. Keep in mind that different phones have different resolutions, so a screen that looks right on one phone might not look right on another! But that's a whole separate topic for another day.

### Column: Horizontal Alignment

* Regardless of screen size, we'll want to see these elements centered. For that, we use center alignment. Add these as arguments to **`Column`**:

```kotlin
Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.SpaceEvenly,
    modifier = Modifier.fillMaxSize()
) {
    // other code
}
```

## Setting up our layout: A **`Column`** with two **`Columns`**

* Your initial plan isn't likely to be the final plan. Mine wasn't! Now would be a good time to separate the profile part and the friends part into two separate columns. *To ensure that they don't overlap, we'll need to put both of those Columns inside a parent column!*

```kotlin
    // Outer column for whole screen
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .weight(2f)
        ) {
            // Code for Profile section
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            // Code for Friend section
        }
    }
```

## Make a **`Row`** for each friend

* Composables are great because you can reuse them in other screens, or within the same screen. This is like making a class and instantiating objects in various parts of your code.

* **`Row`** is like the opposite of **`Column`**. 

* For each Friend row, we have a picture, a name, and this three dot symbol.

```kotlin
Row {
    Image(painterResource(id = R.drawable.jim), contentDescription = "Jim")
    Text("Jim")
    Icon(
        imageVector = Icons.Filled.MoreVert,
        contentDescription = null
    )
}

```

✨ In Kotlin, if you aren't passing in any arguments to the function, like in **`Row`** here, then you can leave off the **`()`**. So no need for **`Row()`**.

* It doesn't look right because there's no arguments for **`Row`**

```kotlin
Row(
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.Start,
    modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 15.dp)
)
```

## Try it and see what happens

* You'll need to experiment with dimensions, see what you like and don't like.

### Spacer

* Spacers are a good way to add space between elements in a row or column. I added some spacers between many of the elements on this screen.

```kotlin
Spacer(modifier = Modifier.width(20.dp))
```

### Horizontal Divider

* A line used to separate components. I used this before and after "Friends" and to separate each Friend

```kotlin
HorizontalDivider(thickness = 2.dp)
```

### Editing the profile Image

* These are the arguments I used for the profile picture

Arguments are a way to specify which type of Image you'll use. Will you use the default Image, or one that is cropped and has modifiers?

```kotlin
Image(
    painter = painterResource(id = R.drawable.sarah_crop),
    contentDescription = "Profile Picture",
    contentScale = ContentScale.Crop,
    modifier = Modifier
        .padding(vertical = 20.dp)
        .size(200.dp)
        .clip(CircleShape)
)
```

### Editing Text

* Experiment with font sizes, padding, weight, color, or check out the documentation and see what else you can do. Here are some examples:

```kotlin
Text(
    "My Profile",
    fontSize = 30.sp,
    modifier = Modifier.padding(vertical = 20.dp)
)

Text(
    "Friends",
    textAlign = TextAlign.Left,
    fontWeight = FontWeight.ExtraBold,
    color = Color.DarkGray,
    fontSize = 20.sp,
    modifier = Modifier
        .align(Alignment.Start)
        .padding(vertical = 20.dp)
        .padding(horizontal = 50.dp)
)
```

✨ Adding padding is similar to how you'd do so on a website.

✨ Use `dp` for dimensions in spacing and padding and `sp` for font sizing.

## 🏅Advanced Topics

* The above content only covers making individual rows for each friend. Suppose you have several friends. It would be more efficient to have all of the friends in a list, in case changes are made.

### 📋 Data Classes

* Think of data classes like a struct in C++ (for Java, think of it like a class that just has data members, no methods or constructors).

* Simply list all of the fields associated with the data class:

```kotlin
data class Friend(
    val name: String, 
    val picture: Int
)
```

* Place this outside of the composable function. I put mine right under the import statements.

✨  Note the use of **`val`**. This **variable declaration** means that the value cannot be changed. The alternative to **`val`** is **`var`**, which means it can be modified (think variable). When possible, choose **`val`** over **`var`**.

⚠️ In Kotlin, the name comes first and then the data type, which is opposite from what you've seen in C++ and Java.

### ✍️ Kotlin **`list`** data structure

* Just like an array or vector, you can make a `list` to store each friend.

```kotlin
val friends = listOf(
    Friend("Jim", R.drawable.jim),
    Friend("Oliver", R.drawable.oliver),
    Friend("Carla", R.drawable.carla),
)
```
✨ Did you notice that I didn't need to specify the data type of the list? That's because with Kotlin (like Python), you don't need to! Unless the list is empty.

### Using a Separate Function for the Friend Row

* Separate the row into it's own function, you can repeatedly call it for each friend.

* Don't forget to change the hardcoded name and picture!

```kotlin
@Composable
fun FriendEntry(friend: Friend) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 15.dp)
        ) {
        Spacer(modifier = Modifier.width(20.dp))
        Image(
            painter = painterResource(id = friend.picture),
            "Profile Picture",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(20.dp))
        Text(
            friend.name,
            fontSize = 20.sp,
            modifier = Modifier.weight(2f)
        )
        Icon(
            imageVector = Icons.Filled.MoreVert,
            contentDescription = null,
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .weight(1f)
            )
    }
}
```

* Note the use of **`friend: Friend`** parameter in the function header (yes this is backwards from C++ and Java). Accessing the **`Friend`**'s attributes uses the **dot operator**, such as **`friend.name`** and **`friend.picture`**.

### 📞 Calling **FriendEntry** function from **ProfileScreen**

* In C++ or Java you might use a `for each` loop. In Kotlin, we will use a `LazyColumn` with a lambda function, which works the same way.

```kotlin
// Column to hold the list of Friends
Column(
    modifier = Modifier
        .fillMaxWidth()
        .weight(1f)
) {
    // LazyColumn uses a lambda function, similar to a for-each loop in C++ or Java
    LazyColumn(modifier = Modifier.fillMaxHeight()) {
        items(friends) { friend ->
            FriendEntry(friend)
            HorizontalDivider(thickness = 2.dp)
        }
    }
}
```

**You should now have everything needed to display the app! The last thing you need to do is make the MainActivity call your new function.**

```kotlin
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ScreenSampleTheme {
                ProfileScreen() // call your function here
            }
        }
    }
}
```

**Now try it out in the emulator. If you have multiple friends in the list, notice how the list can scroll up and down.**

## ⏭️ What's Next?

* Check out the Google Android Compose course to learn a lot more about making apps. [https://developer.android.com/courses/android-basics-compose/course](https://developer.android.com/courses/android-basics-compose/course)

