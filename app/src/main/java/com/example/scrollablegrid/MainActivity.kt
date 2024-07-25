package com.example.scrollablegrid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.scrollablegrid.data.Datasource
import com.example.scrollablegrid.model.Topic
import com.example.scrollablegrid.ui.theme.ScrollableGridTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ScrollableGridTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TopicApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun TopicApp(modifier : Modifier = Modifier) {
    val dataSource = Datasource()
    val allTopics = dataSource.loadTopics()

    Column(modifier = Modifier.fillMaxSize()) {
        TopicList(topicList = allTopics)
    }
}


@Composable
fun TopicList(topicList: List<Topic>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(topicList) {
            topic -> TopicCard(topic = topic )
        }
    }
}


@Composable
fun TopicCard(
    topic: Topic,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        Card(
            modifier = Modifier.weight(1f)
        ){
            Row {
                Image(
                    painter = painterResource(id = topic.imageResourceID),
                    contentDescription = stringResource(id = topic.stringResourceID),
                    modifier = Modifier
                        .width(68.dp)
                        .height(68.dp),
                    contentScale = ContentScale.Crop

                )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(
                        text = stringResource(id = topic.stringResourceID),
                        modifier = Modifier
                            .padding(top = 16.dp, end = 16.dp, bottom = 8.dp),
                        fontSize = 12.sp
                    )
                    Text(text = topic.numberDetail.toString())
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardPreview() {
    TopicCard(topic = Topic(R.drawable.architecture, R.string.architecture, 58), modifier = Modifier)
    TopicList(topicList = listOf(
        Topic(R.drawable.architecture, R.string.architecture, 58),
        Topic(R.drawable.automotive, R.string.automotive, 38),
        Topic(R.drawable.biology, R.string.biology, 58),
        Topic(R.drawable.business, R.string.business, 40)
    )

    )
    }
