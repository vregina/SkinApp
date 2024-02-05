package com.example.skinapp.RecoverPassword

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import com.example.skinapp.Feedback.FeedbackType
import com.example.skinapp.R

class RecoverPasswordRedefinitionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view =
            inflater.inflate(R.layout.recover_password_redefinition_fragment, container, false)
        view.findViewById<ComposeView>(R.id.cv_recover_password_redefinition_container).setContent {
            RecoverPasswordRedefinition()
        }
        return view
    }

    @Composable
    fun RecoverPasswordRedefinition() {
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
                    title = "Redefinição de senha"
                )
                SubTitle(subTitle = "Digite uma nova senha")
                EmailEditText()
                SubTitle(subTitle = "Confirme a nova senha")
                EmailEditText()
            }
            Column(
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                SendButton(buttonText = "Redefinir") {
                    (activity as RecoverFlow).thirdStep()
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
    fun Header(title: String, textAlign: TextAlign = TextAlign.Left) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp),
            text = title,
            style = MaterialTheme.typography.titleLarge,
            textAlign = textAlign
        )
    }

    @Composable
    fun SubTitle(subTitle: String) {
        Text(
            text = subTitle,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp),
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Gray
        )
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun EmailEditText() {
        var password by remember { mutableStateOf("") }
        var passwordVisibility: Boolean by remember { mutableStateOf(false) }
        TextField(
            value = password,
            onValueChange = { password = it },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth(),
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                val showPasswordIcon: Painter = painterResource(id = R.drawable.ic_show_password)
                val hidePasswordIcon: Painter = painterResource(id = R.drawable.ic_hide_password)
                val image = if (passwordVisibility)
                    hidePasswordIcon
                else showPasswordIcon
                IconButton(onClick = {
                    passwordVisibility = !passwordVisibility
                }) {
                    Icon(image, null)
                }
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedTextColor = Color.Black,
                containerColor = Color.White,
                focusedBorderColor = Color.Black,
                unfocusedBorderColor = Color.Black
            ),
            textStyle = MaterialTheme.typography.titleLarge
        )
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
    fun PreviewRecoverPasswordRedefinition() {
        RecoverPasswordRedefinition()
    }
}
