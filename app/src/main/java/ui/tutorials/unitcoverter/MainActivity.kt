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
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ui.tutorials.unitcoverter.ui.theme.UnitCoverterTheme
import kotlin.math.roundToInt

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

    var inputValue  by remember { mutableStateOf("") }
    var outputValue by remember { mutableStateOf("") }
    var inputUnit   by remember { mutableStateOf("Centimeters") }
    var outputUnit  by remember { mutableStateOf("Meters") }
    var iExpanded   by remember { mutableStateOf(false) }
    var oExpanded   by remember { mutableStateOf(false) }
    val conversionFactor = remember { mutableStateOf(1.00) }
    val oConversionFactor = remember { mutableStateOf(1.00) }


    var customTextStyle = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontSize = 32.sp,
        color = Color.DarkGray
    )

    var customTextStyle2 = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontSize = 16.sp,
        color = Color.DarkGray
    )

    fun convertUnits(){

        // ?: - elvis operator
        val inputValueDouble = inputValue.toDoubleOrNull() ?: 0.0
        val result = (inputValueDouble * conversionFactor.value * 100.0 / oConversionFactor.value ).roundToInt() / 100.00
        outputValue = result.toString()
    }


    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Unit Converter",style = customTextStyle)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = inputValue,
            onValueChange = {
                inputValue = it
                convertUnits()
        //Here goes what should happen , when the Value of our OutLinedTextField changes} )
            },
            label = {Text("Enter Value")})
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            //Input Box
            Box {

                Button(
                    //Input Button
                    onClick = { iExpanded = true },
                    shape = RoundedCornerShape(0.dp)
                    ) {
                    Text(text = inputUnit)
                    Icon(Icons.Default.ArrowDropDown,
                        contentDescription = "Arrow Down")
                }
                DropdownMenu(expanded = iExpanded, onDismissRequest = { iExpanded = false }) {
                    DropdownMenuItem(text = { Text(text = "Centimeters") }, onClick = {
                        inputUnit = "Centimeters"
                        iExpanded = false
                        conversionFactor.value = 0.01
                        convertUnits()
                    })
                    DropdownMenuItem(text = { Text(text = "Meters") }, onClick = {
                        inputUnit = "Meters"
                        iExpanded = false
                        conversionFactor.value = 1.0
                        convertUnits()
                    })
                    DropdownMenuItem(text = { Text(text = "Feet") }, onClick = {
                        inputUnit = "Feet"
                        iExpanded = false
                        conversionFactor.value = 0.3048
                        convertUnits()
                    })
                    DropdownMenuItem(text = { Text(text = "Milimeters") }, onClick = {
                        inputUnit = "Milimeters"
                        iExpanded = false
                        conversionFactor.value = 0.001
                        convertUnits()
                    })
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            //Output Box
            Box {
                //Output Button

                Button(
                    onClick = { oExpanded = true },
                    shape = RoundedCornerShape(0.dp)
                    ) {
                    Text(text = outputUnit)
                    Icon(Icons.Default.ArrowDropDown,
                        contentDescription = "Arrow Down")
                }
                DropdownMenu(expanded = oExpanded, onDismissRequest = { oExpanded = false }) {
                    DropdownMenuItem(text = { Text(text = "Centimeters") }, onClick = {
                        outputUnit = "Centimeters"
                        oExpanded = false
                        oConversionFactor.value = 0.01
                        convertUnits()
                    })
                    DropdownMenuItem(text = { Text(text = "Meters") }, onClick = {
                        outputUnit = "Meters"
                        oExpanded = false
                        oConversionFactor.value = 1.00
                        convertUnits()
                    })
                    DropdownMenuItem(text = { Text(text = "Feet") }, onClick = {
                        outputUnit = "Feet"
                        oExpanded = false
                        oConversionFactor.value = 0.3048
                        convertUnits()
                    })
                    DropdownMenuItem(text = { Text(text = "Milimeters") }, onClick = {
                        outputUnit = "Milimeters"
                        oExpanded = false
                        oConversionFactor.value = 0.001
                        convertUnits()
                    })
                }
            }
            //Here all the UI elements will be stacked below each other



        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Result: ${outputValue} ${outputUnit}",
            style = customTextStyle2




            )
    }
}










@Preview(showBackground = true)
@Composable
fun UnitConverterPreview(){
    UnitConverter()
}