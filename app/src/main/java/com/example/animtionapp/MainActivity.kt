package com.example.animtionapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterExitState
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColor
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandIn
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.animtionapp.ui.theme.AnimtionappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AnimtionappTheme {
                app()
            }
        }
    }
}

@Composable
fun  app(){
    val comption2  by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.anmtion2))

    val comption  by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.anmtion1))
    var vistable by remember { mutableStateOf(false) }
    val  antion = rememberInfiniteTransition(
        label = "g"
    )

    val colr by antion.animateColor(
        initialValue =  Color.White,
        targetValue = Color(0xFFFF9800),
        animationSpec = infiniteRepeatable(
            animation = tween(2000),
            repeatMode =  RepeatMode.Restart
        ), label = ""
    )


    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color(0xFFFF5722)
            ),

    ){
        Column(
            modifier =  Modifier.align(Alignment.Center)
        ) {


            LottieAnimation(composition = comption2,modifier = Modifier
                .size(400.dp),
                iterations = LottieConstants.IterateForever,

                )


            Spacer(modifier = Modifier.height(100.dp))
            Box(
                modifier = Modifier.size(200.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Button(onClick = { vistable = !vistable },
                    colors =
                    ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color(0xFFFF5722)
                    )

                    , modifier = Modifier
                        .padding(bottom = 10.dp)
                        .height(50.dp)
                        .align(Alignment.Center)
                        .fillMaxWidth()
                ) {
                    Text(text = "Order", fontSize = 18.sp)
                }
            }

        }

    }
}


//// example animation code here
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun exampleanimation(name: String, modifier: Modifier = Modifier) {
    var vistable by remember { mutableStateOf(false) }
    val dpvie  by animateDpAsState(targetValue = if (vistable) 51.dp else 1.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioLowBouncy,
            stiffness = Spring.StiffnessVeryLow
        )  )
    val color by animateColorAsState(targetValue = if (vistable) Color.Red else Color.Green,
    animationSpec = spring(
        dampingRatio = Spring.DampingRatioLowBouncy,
        stiffness = Spring.StiffnessVeryLow
    )
    )

    val  antion = rememberInfiniteTransition(
    label = "g"
    )

    val colr by antion.animateColor(
        initialValue =  Color.Red,
        targetValue = Color.Green,
        animationSpec = infiniteRepeatable(
            animation = tween(1000),
            repeatMode =  RepeatMode.Restart
        ), label = ""
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Button(onClick = {vistable=!vistable}) {
            Text(text = "Click")
        }

        Box(modifier =
        Modifier
            .size(200.dp)
            .clip(RoundedCornerShape(dpvie))
            .background(colr))

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AnimtionappTheme {
        app()
    }
}