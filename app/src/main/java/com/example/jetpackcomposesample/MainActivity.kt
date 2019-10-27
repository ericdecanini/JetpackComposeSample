package com.example.jetpackcomposesample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.foundation.DrawImage
import androidx.ui.layout.*
import androidx.ui.material.Button
import androidx.ui.material.Divider
import androidx.ui.material.MaterialTheme
import androidx.ui.res.imageResource
import androidx.ui.tooling.preview.Preview

class MainActivity : AppCompatActivity() {

    val names = listOf("Eric", "Monty", "Ben")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }

    @Preview
    @Composable
    fun App() {
        val image = +imageResource(R.drawable.panda)

        MaterialTheme {
            Column(
                crossAxisSize = LayoutSize.Expand,
                modifier = Spacing(16.dp)
            ) {
                names.forEach { name ->
                    Hello(name)
                }

                HeightSpacer(height = 16.dp)

                Button(onClick = { foo() }) {
                    Text(text = "Click Me")
                }

                HeightSpacer(height = 16.dp)

                Container(height = 120.dp, width = 120.dp) {
                    DrawImage(image = image)
                }
            }


        }
    }

    @Composable
    fun Hello(name: String) {
        Text (text = "Hello $name!")
    }

    private fun foo() {
        Toast.makeText(this, "Foo foo", Toast.LENGTH_SHORT).show()
    }

}
