package com.alfredo.profile

//import android.graphics.Color
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout

//import androidx.core.view.ViewCompat
//import androidx.core.view.WindowInsetsCompat
//import androidx.compose.foundation.layout.height
//import androidx.compose.ui.tooling.preview.Preview



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
        //    val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
         //   v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
         //   insets
        //}

        setContent {
            Profile()
        }
    }

    @Preview
    @Composable
    private fun Profile() {
      Column(
          Modifier
              .fillMaxWidth()
              .fillMaxHeight()
              .background(color = Color(android.graphics.Color.parseColor("#f2f1f6"))),
          horizontalAlignment = Alignment.CenterHorizontally) {
          ConstraintLayout(
              Modifier
                  .height(250.dp)
                  .background(color = Color(android.graphics.Color.parseColor("#32357a")))
          ) {
              val (topImg, profile, title, back, pen) = createRefs()

              Image(painterResource(id = R.drawable.arc_3), null, Modifier
                  .fillMaxWidth()
                  .constrainAs(topImg) {
                      bottom.linkTo(parent.bottom)
                  })
              Image(painterResource(id = R.drawable.user_2), null, Modifier
                  .fillMaxWidth()
                  .constrainAs(profile) {
                      start.linkTo(parent.start)
                      end.linkTo(parent.end)
                      bottom.linkTo(topImg.bottom)
                  })

              Text(text = "Profile",
                  style = TextStyle(
                      color = Color.White,
                      fontSize = 30.sp
                  ),
                  modifier = Modifier
                      .constrainAs(title) {
                          top.linkTo(parent.top, margin = 32.dp)
                          start.linkTo(parent.start)
                          end.linkTo(parent.end)
                      }

              )
          }

      }
    }
}