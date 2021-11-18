package com.oykwon.week2_1

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintSet
import com.oykwon.week2_1.ui.theme.LayoutsCodelabTheme
import androidx.constraintlayout.compose.ConstraintLayout as ConstraintLayout1

/**
 * Created by oykwon on 2021/11/18.
 */

//@Composable
//fun ConstraintLayoutContent() {
//    ConstraintLayout1 {
//
//        // Create references for the composables to constrain
//        val (button1, button2, text) = createRefs()
//
//        Button(
//            onClick = { /* Do something */ },
//            modifier = Modifier.constrainAs(button1) {
//                top.linkTo(parent.top, margin = 16.dp)
//            }
//        ) {
//            Text("Button 1")
//        }
//
//        Text("Text", Modifier.constrainAs(text) {
//            top.linkTo(button1.bottom, margin = 16.dp)
//            centerAround(button1.end)
//        })
//
//        val barrier = createEndBarrier(button1, text)
//        Button(
//            onClick = { /* Do something */ },
//            modifier = Modifier.constrainAs(button2) {
//                top.linkTo(parent.top, margin = 16.dp)
//                start.linkTo(barrier)
//            }
//        ) {
//            Text("Button 2")
//        }
//
//    }
//}

@Preview
@Composable
fun ConstraintLayoutContentPreview() {
    LayoutsCodelabTheme {
        DecoupledConstraintLayout()
    }
}

@Composable
fun DecoupledConstraintLayout() {
    BoxWithConstraints {
        val constraints = if (maxWidth < maxHeight) {
            decoupledConstraints(margin = 16.dp) // Portrait constraints
        } else {
            decoupledConstraints(margin = 32.dp) // Landscape constraints
        }

        ConstraintLayout1(constraints) {
            Button(
                onClick = { /* Do something */ },
                modifier = Modifier.layoutId("button")
            ) {
                Text("Button")
            }

            Text("Text", Modifier.layoutId("text"))
        }
    }
}

private fun decoupledConstraints(margin: Dp): ConstraintSet {
    return ConstraintSet {
        val button = createRefFor("button")
        val text = createRefFor("text")

        constrain(button) {
            top.linkTo(parent.top, margin= margin)
        }
        constrain(text) {
            top.linkTo(button.bottom, margin)
        }
    }
}