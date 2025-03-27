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

