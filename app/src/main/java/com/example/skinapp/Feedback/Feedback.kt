package com.example.skinapp.Feedback

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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.example.skinapp.R

class FeedbackFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.recover_password_code_fragment, container, false)
        view.findViewById<ComposeView>(R.id.cv_recover_password_input_code_container).setContent {
            FeedbackScreen()
        }
        return view
    }

    @Composable
    fun FeedbackScreen() {
        Surface {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .background(Color.White)
            ) {
                Header(title = "Senha refefinida com sucesso!", textAlign = TextAlign.Center)
                FeedbackImage(FeedbackType.Success)
            }
        }
    }

    @Composable
    fun FeedbackImage(feedbackType: FeedbackType) {
        Image(
            modifier = Modifier
                .padding(top = 36.dp),
            painter = painterResource(id = feedbackType.image),
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

    @Preview
    @Composable
    fun PreviewSuccessFeedback() {
        FeedbackScreen()
    }
}