package com.example.skinapp.RecoverPassword

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.skinapp.Feedback.FeedbackFragment
import com.example.skinapp.Feedback.FeedbackType
import com.example.skinapp.R

class RecoverPasswordActivity : AppCompatActivity(), RecoverFlow {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.recover_password_activity)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fcv_recover_password_container, RecoverPasswordSendCodeFragment())
            .commit()
    }

    //da pra fazer uma interface com metodos do flow tipo fun flow1,2,3... e implementa aq
    //ai no fragmento usa activity as nomedainterface.flow1,2,3,

    override fun firstStep() {
        callNextStep(RecoverPasswordInputCodeFragment())
    }

    override fun secondStep() {
        callNextStep(RecoverPasswordRedefinitionFragment())
    }

    override fun thirdStep() {
        callNextStep(FeedbackFragment())
    }

    fun callNextStep(nextFragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fcv_recover_password_container, nextFragment)
            .addToBackStack(null)
            .commit()
    }
}