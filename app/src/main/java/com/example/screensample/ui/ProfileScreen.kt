package com.example.screensample.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.screensample.R
import com.example.screensample.ui.theme.ScreenSampleTheme

data class Friend(val name: String, val picture: Int)

@Composable
fun ProfileScreen() {
    val friends = listOf(
        Friend("Jim", R.drawable.jim),
        Friend("Oliver", R.drawable.oliver),
        Friend("Carla", R.drawable.carla),
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        //verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            "My Profile",
            fontSize = 30.sp,
            modifier = Modifier.padding(vertical = 20.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.sarah_crop),
            "Profile Picture",
            contentScale = ContentScale.Crop,
            modifier = Modifier.padding(vertical = 20.dp).size(200.dp).clip(CircleShape)
        )
        Text(
            "Sarah Martel",
            fontSize = 40.sp
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            "\"Try it and see what happens.\"",
            fontStyle = FontStyle.Italic,
            fontSize = 20.sp
        )
        Text(
            "sarahmmartel@gmail.com",
            color = Color.Blue,
            fontSize = 20.sp,
            modifier = Modifier.padding(vertical = 20.dp)
        )
        HorizontalDivider(thickness = 2.dp)

        Text(
            "Friends",
            textAlign = TextAlign.Left,
            fontWeight = FontWeight.ExtraBold,
            color = Color.DarkGray,
            fontSize = 20.sp,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(vertical = 20.dp)
                .padding(horizontal = 50.dp),

        )
        HorizontalDivider(thickness = 2.dp)

        Column(modifier = Modifier.fillMaxSize()) {
            LazyColumn(modifier = Modifier.fillMaxHeight()) {

                items(friends) { friend ->
                    FriendEntry(friend)
                    HorizontalDivider(thickness = 2.dp)
                }
            }
        }
    }
}

@Composable
fun FriendEntry(friend: Friend) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier.fillMaxWidth().padding(vertical = 15.dp)
        ) {
        Spacer(modifier = Modifier.width(20.dp))
        Image(
            painter = painterResource(id = friend.picture),
            "Profile Picture",
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(80.dp).clip(CircleShape)
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
            modifier = Modifier.padding(horizontal = 20.dp).weight(1f)
            )
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    ScreenSampleTheme {
        ProfileScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun FriendPreview() {
    ScreenSampleTheme {
        val sampleFriend = Friend("Jim", R.drawable.jim)
        FriendEntry(sampleFriend)
    }
}