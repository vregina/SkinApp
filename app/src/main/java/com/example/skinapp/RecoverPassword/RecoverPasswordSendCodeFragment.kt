package com.example.skinapp.RecoverPassword

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import com.example.skinapp.R

class RecoverPasswordSendCodeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.recover_password_send_code_fragment, container, false)
        view.findViewById<ComposeView>(R.id.cv_recover_password_send_code_container).  setContent {
            ForgotPasswordForm()
        }
        return view
    }

    @Composable
    fun ForgotPasswordForm() {
        //escafod? em vez de surface com topbar bottom bar
        Surface  {
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
                    title = "Recuperação de senha",
                    description = "Insira seu email cadastrado, enviaremos um código para atualizar a senha."
                )
                EmailEditText()
            }
            Column(
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                SendButton(buttonText = "Enviar") {
                    //navHost
                    (activity as RecoverFlow).firstStep()
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
    fun Header(title: String, description: String) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                style = MaterialTheme.typography.titleLarge,
                text = title
            )
            Text(
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray,
                text = description
            )
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun EmailEditText() {
        var text by remember { mutableStateOf("") }
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp)
                .background(Color.White),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White
            ),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_user),
                    contentDescription = null,
                    tint = Color.Gray
                )
            },
            textStyle = MaterialTheme.typography.titleLarge,
            placeholder = { Text(text = "Email") },
            value = text,
            onValueChange = { text = it }
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
    fun PreviewRecoverPassword() {
        ForgotPasswordForm()
    }

}