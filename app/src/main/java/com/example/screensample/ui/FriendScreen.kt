/*
    This version of the Screen only lists one friend. It omits the advanced topics listed in the
    README.md, which explain how to create a separate function for each friend, how to make a data
    class, and load the data from a list using LazyColumn.
 */

package com.example.screensample.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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

@Composable
fun FriendScreen() {
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
            Spacer(modifier = Modifier.height(30.dp))

            Text(
                "My profile",
                fontSize = 30.sp,
                modifier = Modifier.padding(vertical = 20.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.sarah_crop),
                contentDescription = "Sarah",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(vertical = 20.dp)
                    .size(200.dp)
                    .clip(CircleShape)
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
                    .padding(horizontal = 50.dp)
            )
            HorizontalDivider(thickness = 2.dp)
        }

        // Start of the column which holds rows of Friends
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            // Row for Jim
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 15.dp)
            ) {
                Spacer(modifier = Modifier.width(20.dp))

                Image(
                    painterResource(id = R.drawable.jim),
                    contentDescription = "Jim",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                )

                Spacer(modifier = Modifier.width(20.dp))

                Text(
                    "Jim",
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
    }
}

@Preview(showBackground = true)
@Composable
fun FriendScreenPreview() {
    FriendScreen()
}