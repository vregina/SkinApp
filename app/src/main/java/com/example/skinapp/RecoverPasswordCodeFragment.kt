package com.example.skinapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusProperties
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment


class RecoverPasswordCodeFragment() : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                RecoverPasswordCodeForm()
            }
        }
    }

    @Composable
    fun RecoverPasswordCodeForm() {
        Surface {
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .background(Color.White)
            ) {
                LogoImage(logoId = R.drawable.ic_logo_brand)
                Header(
                    title = "Digite o código enviado em seu email"
                )
                CodeInput()
            }
            Column(
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                SendButton(buttonText = "Confirmar") {
//                    val intent =
//                        Intent(this@RecoverPasswordActivity, RecoverPasswordCodeFragment::class.java)
//                    startActivity(intent)
                }
            }
        }
    }

    @Composable
    fun LogoImage(logoId: Int) {
        Image(
            modifier = Modifier
                .padding(top = 36.dp),
            painter = painterResource(id = logoId),
            contentDescription = "Logo do app"
        )
    }

    @Composable
    fun Header(title: String) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp),
        ) {
            Text(
                style = MaterialTheme.typography.titleLarge,
                text = title
            )
        }
    }

    @OptIn(ExperimentalComposeUiApi::class)
    @Composable
    fun CodeInput() {
        val (item1, item2, item3, item4) = FocusRequester.createRefs()
        Row(
            modifier = Modifier
                .padding(top = 32.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            CodeBox(
                modifier = Modifier
                    .focusRequester(item1)
                    .focusProperties {
                        next = item2
                        previous = item1
                    }
            )
            CodeBox(
                modifier = Modifier
                    .focusRequester(item1)
                    .focusProperties {
                        next = item1
                        previous = item3
                    }
            )
            CodeBox(
                modifier = Modifier
                    .focusRequester(item1)
                    .focusProperties {
                        next = item2
                        previous = item4
                    }
            )
            CodeBox(
                modifier = Modifier
                    .focusRequester(item1)
                    .focusProperties {
                        next = item4
                        previous = item3
                    }
            )
        }
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun CodeBox(modifier: Modifier) {
        var text by remember { mutableStateOf("") }
        val maxChar = 1

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = text,
                onValueChange = {
                    if (it.length <= maxChar) text = it
                },
                singleLine = true,
                modifier = modifier
                    .width(48.dp),
                textStyle = MaterialTheme.typography.titleLarge.copy(
                    textAlign = TextAlign.Center
                ),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedTextColor = Color.Black,
                    containerColor = Color.White,
                    focusedBorderColor = colorResource(id = R.color.action),
                    unfocusedBorderColor = Color.Black
                )
            )
        }
    }

    @Composable
    fun SendButton(buttonText: String, onClick: () -> Unit) {
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 36.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(R.color.action),
                contentColor = Color.White
            ),
            onClick = onClick
        ) {
            Text(text = buttonText, fontSize = 18.sp)
        }
    }

    @Preview
    @Composable
    fun PreviewRecoverPassword() {
        RecoverPasswordCodeForm()
    }
}