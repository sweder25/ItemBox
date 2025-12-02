
package com.mij.itembox.ui.page
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mij.itembox.R
import com.mij.itembox.util.AppBackground


@Composable
fun HomePage() {

    val infiniteTransition = rememberInfiniteTransition(label = "magic")

    val scale by infiniteTransition.animateFloat(
        0.95f, 1.05f,
        animationSpec = infiniteRepeatable(
            tween(1500, easing = LinearEasing),
            RepeatMode.Reverse
        ),
        label = "scale"
    )

    val rotation by infiniteTransition.animateFloat(
        -2f, 2f,
        animationSpec = infiniteRepeatable(
            tween(2500, easing = FastOutSlowInEasing),
            RepeatMode.Reverse
        ),
        label = "rotation"
    )

    val alphaGlow by infiniteTransition.animateFloat(
        0.6f, 1f,
        animationSpec = infiniteRepeatable(
            tween(1800, easing = FastOutSlowInEasing),
            RepeatMode.Reverse
        ),
        label = "glow"
    )

    AppBackground {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Box(contentAlignment = Alignment.Center) {

                // AURA MÁGICA
                Box(
                    modifier = Modifier
                        .size(300.dp)
                        .graphicsLayer {
                            scaleX = scale
                            scaleY = scale
                            alpha = alphaGlow
                        }
                        .background(
                            Brush.radialGradient(
                                colors = listOf(
                                    Color(0x66E6D5A4),
                                    Color.Transparent
                                )
                            ),
                            shape = CircleShape
                        )
                )

                // LOGO PRINCIPAL
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo del juego",
                    modifier = Modifier
                        .size(250.dp)
                        .graphicsLayer {
                            rotationZ = rotation
                        }
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                "Bienvenidos A Dungeons & Dragons",
                color = Color(0xFFE6D5A4)
            )
        }
    }
}
