package ui.tutorials.unitcoverter

import android.graphics.drawable.Icon
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ui.tutorials.unitcoverter.ui.theme.UnitCoverterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitCoverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UnitConverter()
                }
            }
        }
    }
}

@Composable
fun UnitConverter(){
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Unit Converter")
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = "Enter Value", onValueChange = {
        //Here goes what should happen , when the Value of our OutLinedTextField changes} )
        })
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Box {

                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Select")
                    Icon(Icons.Default.ArrowDropDown,
                        contentDescription = "Arrow Down")
                }
                DropdownMenu(expanded = true, onDismissRequest = { /*TODO*/ }) {
                    DropdownMenuItem(text = { Text(text = "Centimeters") }, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text(text = "Meters") }, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text(text = "Feet") }, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text(text = "Milimeters") }, onClick = { /*TODO*/ })
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box {

                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Select")
                    Icon(Icons.Default.ArrowDropDown,
                        contentDescription = "Arrow Down")
                }
                DropdownMenu(expanded = true, onDismissRequest = { /*TODO*/ }) {
                    DropdownMenuItem(text = { Text(text = "Centimeters") }, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text(text = "Meters") }, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text(text = "Feet") }, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text(text = "Milimeters") }, onClick = { /*TODO*/ })
                }
            }
            //Here all the UI elements will be stacked below each other



        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Result:")
    }
}










@Preview(showBackground = true)
@Composable
fun UnitConverterPreview(){
    UnitConverter()
}