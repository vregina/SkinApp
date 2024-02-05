package com.example.skinapp.Feedback

import com.example.skinapp.R

sealed class FeedbackType(val image: Int) {
    object Success: FeedbackType(image = R.drawable.ic_success)
    object Error: FeedbackType(image = R.drawable.ic_error)

}