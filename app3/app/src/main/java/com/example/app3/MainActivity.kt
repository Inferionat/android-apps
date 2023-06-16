package com.example.app3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement


import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.app3.ui.theme.App3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App3Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val posts = listOf(
                        Post("Rahul", painterResource(id = R.drawable.profile1), painterResource(
                            id = R.drawable.post1 )),
                        Post("andrew", painterResource(id = R.drawable.profile2),
                            painterResource(id = R.drawable.post2)),
                        Post("michel", painterResource(id = R.drawable.profile3),
                            painterResource(id = R.drawable.post3)),
                        Post("toby", painterResource(id = R.drawable.profile4),
                            painterResource(id = R.drawable.post4))
                    )

                    LazyColumn{
                        items(posts){ p ->
                            Greeting(username = p.name, profile = p.profile, post = p.postPic)
                        }
                    }

                }
            }
        }
    }



    @Composable
    fun Greeting(username: String, profile: Painter, post: Painter, modifier: Modifier = Modifier) {

        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            Row {
                Image(
                    painter = profile,
                    contentDescription = "My Name is Ram",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .size(40.dp)
                        .clip(CircleShape)



                )
                Spacer(modifier = Modifier.width(10.dp))

                Text(
                    text = username,
                    fontSize = 25.sp,
                    modifier = Modifier.weight(1f)
                )
                Icon(
                    painter = painterResource(id = R.drawable.more),
                    contentDescription = "more"
                )


            }

            Spacer(Modifier.size(10.dp))

            Image(
                painter = post,
                contentDescription = "do",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .fillMaxWidth()
            )

            Spacer(Modifier.size(10.dp))

            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Icon(
                    painter = painterResource(id = R.drawable.heart),
                    contentDescription = "hear"
                )
                Icon(
                    painter = painterResource(id = R.drawable.comment),
                    contentDescription = "comment"
                )
                Icon(
                    painter = painterResource(id = R.drawable.share),
                    contentDescription = "share"
                )
            }

        }

    }


    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        App3Theme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {

                val posts = listOf(
                    Post("Rahul", painterResource(id = R.drawable.profile1), painterResource(
                    id = R.drawable.post1 )),
                    Post("andrew", painterResource(id = R.drawable.profile2),
                    painterResource(id = R.drawable.post2)),
                    Post("michel", painterResource(id = R.drawable.profile3),
                        painterResource(id = R.drawable.post3)),
                    Post("toby", painterResource(id = R.drawable.profile4),
                        painterResource(id = R.drawable.post4))
                )

                LazyColumn{
                    items(posts){ p ->
                        Greeting(username = p.name, profile = p.profile, post = p.postPic)
                    }
                }

            }
        }
    }
    
    data class Post( val name : String, val profile : Painter, val postPic : Painter)
}
