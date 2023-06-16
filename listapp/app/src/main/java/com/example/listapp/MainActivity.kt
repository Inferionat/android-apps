// ...
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.listapp.R
import com.example.listapp.ui.theme.ListappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListappTheme {
                val msg1 = listOf<Message>(
                    Message("Ram", " \"A chat with one message feels a bit lonely, so we are going to change the conversation to have more than one message. You'll need to create a Conversation function that will show multiple messages. For this use case, use Compose’s LazyColumn and LazyRow."),
                    Message("Shyam", "Hello how are you."),
                    Message("Ritul", "Nice to meet you."),
                    Message("Ram", " \"A chat with one message feels a bit lonely, so we are going to change the conversation to have more than one message. You'll need to create a Conversation function that will show multiple messages. For this use case, use Compose’s LazyColumn and LazyRow."),
                    Message("Shyam", "Hello how are you."),
                    Message("Ritul", "Nice to meet you."),
                    Message("Ram", " \"A chat with one message feels a bit lonely, so we are going to change the conversation to have more than one message. You'll need to create a Conversation function that will show multiple messages. For this use case, use Compose’s LazyColumn and LazyRow."),
                    Message("Shyam", "Hello how are you."),
                    Message("Ritul", "Nice to meet you."),
                    Message("Ritul", "Nice to meet you."),
                    Message("Ram", " \"A chat with one message feels a bit lonely, so we are going to change the conversation to have more than one message. You'll need to create a Conversation function that will show multiple messages. For this use case, use Compose’s LazyColumn and LazyRow."),
                    Message("Shyam", "Hello how are you."),
                    Message("Ritul", "Nice to meet you.")  )
                Conversation(msg1)
            }
        }
    }
}

@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn{
        items(messages){  msg ->
            MessageCard(msg = msg)
        }
    }
}

@Composable
fun MessageCard(msg: Message) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(R.drawable.download),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))

        // We keep track if the message is expanded or not in this
        // variable
        var isExpanded by remember { mutableStateOf(false) }

        // We toggle the isExpanded variable when we click on this Column
        Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
            Text(
                text = msg.author,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleSmall
            )

            Spacer(modifier = Modifier.height(4.dp))

            Surface(
                shape = MaterialTheme.shapes.medium,
                shadowElevation = 1.dp,
            ) {
                Text(
                    text = msg.msg,
                    modifier = Modifier.padding(all = 4.dp),
                    // If the message is expanded, we display all its content
                    // otherwise we only display the first line
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }


            FilledIconButton(onClick = { /*TODO*/ }) {
                Text("Likes")
            }

    }
}
data class Message( val author : String, val msg : String )

@Preview
@Composable
fun mypreview(){
    ListappTheme {
        val msg1 = listOf<Message>(
            Message("Ram", " \"A chat with one message feels a bit lonely, so we are going to change the conversation to have more than one message. You'll need to create a Conversation function that will show multiple messages. For this use case, use Compose’s LazyColumn and LazyRow."),
            Message("Shyam", "Hello how are you."),
            Message("Ritul", "Nice to meet you."),
            Message("Ram", " \"A chat with one message feels a bit lonely, so we are going to change the conversation to have more than one message. You'll need to create a Conversation function that will show multiple messages. For this use case, use Compose’s LazyColumn and LazyRow."),
            Message("Shyam", "Hello how are you."),
            Message("Ritul", "Nice to meet you."),
            Message("Ram", " \"A chat with one message feels a bit lonely, so we are going to change the conversation to have more than one message. You'll need to create a Conversation function that will show multiple messages. For this use case, use Compose’s LazyColumn and LazyRow."),
            Message("Shyam", "Hello how are you."),
            Message("Ritul", "Nice to meet you."),
            Message("Ritul", "Nice to meet you."),
            Message("Ram", " \"A chat with one message feels a bit lonely, so we are going to change the conversation to have more than one message. You'll need to create a Conversation function that will show multiple messages. For this use case, use Compose’s LazyColumn and LazyRow."),
            Message("Shyam", "Hello how are you."),
            Message("Ritul", "Nice to meet you.")
        )
        Conversation(msg1)
    }
}
