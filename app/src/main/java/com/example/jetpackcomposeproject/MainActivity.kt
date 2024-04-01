package com.example.jetpackcomposeproject

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import kotlinx.coroutines.launch
import kotlin.random.Random

val TAG = MainActivity::class.java.simpleName

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //Greetings("Aman")//1st
            //ExploringModifier()

            /*val imageTitle = "Aman Ullah"
            val contentDescription = "Aman Ullah is talking over the phone"
            val painter = painterResource(id = R.drawable.profile_image)
            Column {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.5F)
                        .padding(5.dp)
                ) {
                    ImageCard(
                        painter = painter,
                        title = imageTitle,
                        contentDescription = contentDescription
                    )
                }
                ExploreTextProperties()
                Spacer(modifier = Modifier.height(10.dp))
                ColorBox(Modifier.fillMaxWidth().fillMaxHeight(0.2F))
            }*/

            //UserName()

           // LoadList()

//            LazyColumList()
            //LazyColumList2()
            //ExploreConstraintLayout()
            //EffectHandler()
            //BoxAnimation()
            CreateBizCard()

        }
    }
}

@Composable
fun Greetings(name: String) {
    Column(
        modifier = Modifier
            .background(Color.Blue)
            .width(300.dp)
            .height(400.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        Text(text = "Hello $name")
        Text(text = "How are you $name")
        Text(text = "Welcome")
    }
}

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Preview() {
    //Greetings(name = "Aman")
    //ExploringModifier()
    /*Column {
        val painter = painterResource(id = R.drawable.profile_image)
        ImageCard(
            painter = painter,
            title = "Profile Image",
            contentDescription = "Profile Image Description"
        )

        Spacer(modifier = Modifier.height(10.dp))

        ExploreTextProperties()

        ColorBox(Modifier.fillMaxWidth().fillMaxHeight(0.2F))
    }*/

    //UserName()

   // LoadList()
    //LazyColumList()
    //LazyColumList2()
    //ExploreConstraintLayout()
    //EffectHandler()
    BoxAnimation()

}

@Composable
fun ExploringModifier() {
    Column(
        modifier = Modifier
            .background(Color.Green)
            .fillMaxWidth(0.7F)
            .height(300.dp)
            .padding(30.dp)
            .border(4.dp, Color.Blue)
            .padding(5.dp)
            .border(5.dp, Color.Magenta)
            .padding(5.dp)
            .border(5.dp, Color.Cyan)
            .padding(5.dp)
        /*.requiredHeight(600.dp)*/
    ) {
        Text(text = "Hello")
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "How")
        Text(text = "Are you")
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = "Click me", modifier = Modifier.clickable {
            Log.d(TAG, "ExploringModifier: You clicked me")
        })
    }
}

@Composable
fun ImageCard(
    painter: Painter,
    title: String,
    contentDescription: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),

        ) {

        Box(
            modifier = Modifier
                .height(200.dp)
                .clip(RoundedCornerShape(15.dp))
        ) {
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ), startY = 150F
                        )
                    )
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                contentAlignment = Alignment.BottomCenter
            ) {

                Text(text = title, style = TextStyle(color = Color.White, fontSize = 16.sp))
            }
        }
    }
}

@Composable
fun ExploreTextProperties() {

    val fontFamily = FontFamily(
        Font(R.font.roboto_slab_black, FontWeight.Black),
        Font(R.font.roboto_slab_thin, FontWeight.Thin),
    )
    //Simple attributes
    val myText = "Jetpack Compose"
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF101010))
                .padding(5.dp)
        ) {

            Text(
                text = myText,
                color = Color.White,
                fontSize = 20.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.ExtraBold,
                fontFamily = fontFamily,
                textDecoration = TextDecoration.Underline
            )

        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF505050))) {

            Text(text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color.Yellow,
                        fontSize = 40.sp
                    )
                ) {
                    append("J")
                }
                append("etpack ")

                withStyle(
                    style = SpanStyle(
                        color = Color.Green,
                        fontSize = 40.sp
                    )
                ) {
                    append("C")
                }

                append("ompose")
            },
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                modifier = Modifier
                    .padding(5.dp)
            )
        }
    }

}

// Recomposition
@Composable
fun ColorBox(modifier: Modifier = Modifier) {

    val color = remember {
        mutableStateOf(Color.Yellow)
    }
    Box(
        modifier = modifier
            .background(color.value)
            .clickable {
                color.value = Color(
                    Random.nextFloat(),
                    Random.nextFloat(),
                    Random.nextFloat(),
                    1F
                )
            }
    ) {

    }
}

//Text Field with snackBar
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserName() {
    val snackBarHostState = remember { SnackbarHostState() }
    var textFieldState by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        snackbarHost = { snackBarHostState }
    ) { innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            TextField(
                value = textFieldState,
                label = {
                    Text(text = "Enter your name")
                },
                onValueChange = {
                    textFieldState = it
                },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(10.dp))

            Button(onClick = {
                Log.d(TAG, "UserName: Hello $textFieldState")
                scope.launch {

                    snackBarHostState.showSnackbar("Hello, ${textFieldState.trim()}!")
                }
            }) {
                Text(text = "Submit")
            }
        }
    }

}

@Composable
fun LoadUserList() {

    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .verticalScroll(scrollState)) {
        for (i in 0..50) {
            Text(text = "User $i",
                fontStyle = FontStyle.Normal,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(25.dp)
            )
        }
    }
}

@Composable
fun LoadList() {

    val scrollState = rememberScrollState()
    Column(modifier = Modifier.verticalScroll(scrollState)) {
        for (i in 0..50) {
            Text(
                text = "item $i",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                textAlign = TextAlign.Center // Center the text horizontally
            )
        }
    }
}

@Composable
fun LazyColumList() {
    LazyColumn {
        items(5000) {
            Text(text = "User $it",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(25.dp)
                    .background(Color.Green)
            )
        }

    }
}

@Composable
fun LazyColumList2() {
    LazyColumn {
        itemsIndexed(
            listOf("item 1","item 2", "item 3", "item 4", "item 5")
        ) { index, item ->
            Text(text = "$item $index",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(25.dp)
                    .background(Color.Green)
            )
        }

    }
}

@Composable
fun ExploreConstraintLayout() {

    val constraints = ConstraintSet {
        val greenBox = createRefFor("greenBox")
        val redBox = createRefFor("redBox")
        val blueBox = createRefFor("blueBox")
        val yellow = createRefFor("yellowBox")
        val magentaBox = createRefFor("magentaBox")

        val guideline = createGuidelineFromTop(0.5F)

        constrain(greenBox) {
           // top.linkTo(parent.top)
            top.linkTo(guideline)
            start.linkTo(parent.start)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }

        constrain(redBox) {
            top.linkTo(parent.top)
            start.linkTo(greenBox.end)
            end.linkTo(parent.end)

            width = Dimension.value(100.dp)
            //width = Dimension.fillToConstraints
            height = Dimension.value(100.dp)
        }

        constrain(blueBox) {
            top.linkTo(greenBox.bottom)
            bottom.linkTo(greenBox.bottom)
            start.linkTo(greenBox.start)
            end.linkTo(greenBox.end)

            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }

        constrain(yellow) {
            start.linkTo(blueBox.end)
            end.linkTo(blueBox.end)
            top.linkTo(blueBox.top)
            bottom.linkTo(blueBox.bottom)

            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }

        constrain(magentaBox) {
            top.linkTo(greenBox.top)
            bottom.linkTo(greenBox.bottom)
            start.linkTo(greenBox.end)
            end.linkTo(greenBox.end)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }

        createHorizontalChain(greenBox, redBox, chainStyle = ChainStyle.Spread)
    }

    ConstraintLayout(constraints, modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier
            .background(Color.Green)
            .layoutId("greenBox"))

        Box(modifier = Modifier
            .background(Color.Red)
            .layoutId("redBox"))

        Box(modifier = Modifier
            .background(Color.Blue)
            .layoutId("blueBox"))

        Box(modifier = Modifier
            .background(Color.Yellow)
            .layoutId("yellowBox"))

        Box(modifier = Modifier
            .background(Color.Magenta)
            .layoutId("magentaBox"))
    }
}

@Composable
fun EffectHandler() {
    var i = 0
    var text by remember {
        mutableStateOf("")
    }

    Button(onClick = { text += "#" }) {
        i++
        Text(text = text)
    }
}

@Composable
fun BoxAnimation() {

    var sizeState by remember {
        mutableStateOf(200.dp)
    }

    val size by animateDpAsState(targetValue = sizeState,
        /*curve animation*/
        tween(
            durationMillis = 1000,
            delayMillis = 100,
            easing = FastOutSlowInEasing
        )

        /*bouncy animation*/
        /*spring(
            Spring.DampingRatioHighBouncy
        )*/

        /*Key frames animateion*/
        /*keyframes {
            durationMillis = 4000
            sizeState at 0 with LinearEasing
            sizeState * 1.5F at 2000 with FastOutLinearInEasing
            sizeState * 2F at 4000 with FastOutSlowInEasing
        }*/



    )

    /*infinite loop animation*/
    var inifiniteTransition = rememberInfiniteTransition()
    val color by inifiniteTransition.animateColor(
        initialValue = Color.Red,
        targetValue = Color.Green,
        animationSpec = infiniteRepeatable(
            tween(
                durationMillis = 2000
            ),
            repeatMode = RepeatMode.Reverse
        )
    )
    Box(modifier = Modifier
        .size(size)
        .background(color),
        contentAlignment = Alignment.Center) {

        Button(onClick = {
            sizeState += 50.dp
        }) {
            Text(text = "Increase Size")
        }
    }
}

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CreateBizCard() {
    var portfolioVisibilityState by remember {
        mutableStateOf(false)
    }
    Surface(modifier = Modifier
        .fillMaxSize()
        .padding(10.dp)) {
        Card(modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
            shape = RoundedCornerShape(10.dp)) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                CreateProfileImage()
                Divider()
                Text(text = "Aman Ullah", fontWeight = FontWeight.Bold, fontSize = 14.sp, fontStyle = FontStyle.Normal, color = Color.Blue)
                Text(text = "aman@gmail.com", fontSize = 12.sp, fontWeight = FontWeight.Medium)

                Button(onClick = {
                                 portfolioVisibilityState = !portfolioVisibilityState
                                 },
                    shape = RoundedCornerShape(5.dp)
                ) {
                    Text(text = "Portfolio")
                }
                if (portfolioVisibilityState) {
                    PortfolioContent()
                }else {
                    Box() {

                    }
                }

            }

        }
    }
}

@Composable
private fun PortfolioContent() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.LightGray)
        .border(2.dp, Color.Gray, RectangleShape)
    ) {
        LazyColumn {
            items(50) { index ->
                Spacer(modifier = Modifier.height(5.dp))
                val constraints = ConstraintSet {
                    val imageBox = createRefFor("imageBox")
                    val titleBox = createRefFor("titleBox")
                    val descriptionBox = createRefFor("descriptionBox")

                    constrain(imageBox) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)

                        width = Dimension.wrapContent
                        height = Dimension.wrapContent
                    }

                    constrain(titleBox) {
                        start.linkTo(imageBox.end)
                        top.linkTo(parent.top)

                        width = Dimension.wrapContent
                        height = Dimension.wrapContent
                    }

                    constrain(descriptionBox) {
                        start.linkTo(imageBox.end)
                        top.linkTo(titleBox.bottom)
                        bottom.linkTo(parent.bottom)

                        width = Dimension.wrapContent
                        height = Dimension.wrapContent
                    }

                    createVerticalChain(titleBox, descriptionBox)
                }

                ConstraintLayout(constraints, modifier = Modifier.fillMaxWidth()) {
                    CreateProfileImage(
                        modifier = Modifier
                            .size(50.dp)
                            .padding(2.dp)
                            .layoutId("imageBox")
                    )
                    Text(
                        text = "Project $index", modifier = Modifier.layoutId("titleBox"),
                        fontWeight = FontWeight.Bold
                    )
                    Text(text = "Description $index", modifier = Modifier.layoutId("descriptionBox"))

                    Divider()
                }
            }
        }
    }
}

@Composable
private fun CreateProfileImage(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .size(70.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(width = 2.dp, Color.LightGray)
    ) {

        Image(
            painter = painterResource(id = R.drawable.profile_image),
            contentDescription = "Profile Image",
            contentScale = ContentScale.FillBounds
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CreateCircularProgress(
    percentage: Float,
    number: Int,
    fontSiz: TextUnit = 25.sp,
    radius: Dp = 50.dp,
    color: Color = Color.Green,
    strokeWidth: Dp = 8.dp,
    animationDuration: Int = 1000,
    animDelay: Int = 0

) {
    var animationPlayed by remember {
        mutableStateOf(false)
    }

    val currentPercentage = animateFloatAsState(
        targetValue = if (animationPlayed) percentage else 0f,
        animationSpec = tween(
            durationMillis = animationDuration,
            delayMillis = animDelay
            )
    )

    LaunchedEffect(key1 = true) {
        animationPlayed = true
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.size(radius * 2f)) {

        Canvas(modifier = Modifier.size(radius * 2f)) {
            drawArc(
                color = color,
                -90f,
                360 * currentPercentage.value,
                useCenter = false,
                style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
            )
        }

        Text(
            text = (currentPercentage.value * number).toInt().toString(),
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
    }
    
}
