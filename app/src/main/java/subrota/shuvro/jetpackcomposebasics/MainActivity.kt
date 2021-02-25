package subrota.shuvro.jetpackcomposebasics

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import subrota.shuvro.jetpackcomposebasics.ui.theme.JetpackComposeBasicsTheme

//this is my very first project in jetpack compose
//this app cover basic of compose which is first tutorial of official jetpack compose tutorial

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SayHello(name = "Subrota Debnath")
        }
    }
}

@Composable
private fun SayHello(name: String) {

    val counterState = remember { mutableStateOf(0) }

    Column(
        //modifier = Modifier.padding(16.dp)
        modifier = Modifier
            .padding(8.dp, 16.dp, 8.dp, 16.dp)
            .background(Color.White)
    ) {

        Image(
            //can't support jpg formatted image from drawable
            painter = painterResource(id = R.drawable._img_subrota),
            contentDescription = "Subtota Debnath",
            modifier = Modifier
                .height(220.dp)
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(4.dp)),
            //content scale crop , Crop the image according to image width and height
            contentScale = ContentScale.Crop,
            alignment = Alignment.Center,
        )
        //Spacer for making distance between image and first text
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Hello, I'm $name.",
            style = typography.h5.plus(TextStyle(color = Color.White)),
            fontStyle = FontStyle.Italic,
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Blue)
        )
        Text(
            text = "I'm a android Application Developer and adding more " +
                    "text for a long line sentence",
            style = typography.h6,
            maxLines = 1, overflow = TextOverflow.Ellipsis
        )
        Text(
            text = "I am from Bangladesh",
            style = typography.body2
        )

        Spacer(modifier = Modifier.height(8.dp))
        Divider(color = Color.Blue)
        Spacer(modifier = Modifier.height(8.dp))

        Surface(color = Color.Yellow, shape = RoundedCornerShape(8.dp)) {
            Text(
                text = "Go",
                style = typography.h4,
                modifier = Modifier.padding(18.dp)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))
        Divider(color = Color.Blue)
        Spacer(modifier = Modifier.height(8.dp))

        Counter(count = counterState.value,
            updateCount = { newCount -> counterState.value = newCount })
    }

}

@Composable
fun Counter(count: Int, updateCount: (Int) -> Unit) {
    Button(onClick = { updateCount(count + 1) }) {
        Text("I've been clicked $count times")
    }
}

///to preview have to add preview annotation
@Preview
@Composable
fun previewSayHello() {
    SayHello(name = "Subrota")
}