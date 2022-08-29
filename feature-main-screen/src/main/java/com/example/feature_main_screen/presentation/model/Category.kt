package com.example.feature_main_screen.presentation.model

import com.example.feature_main_screen.R

enum class Category(val title: String, val iconId: Int) {
    PHONES(title = "Phones", iconId =R.drawable.ic_phones) ,
    COMPUTER(title = "Computer", iconId =R.drawable.ic_computer),
    HEALTH(title = "Health", iconId =R.drawable.ic_health),
    BOOKS(title = "Books", iconId =R.drawable.ic_books),
    TEST1(title = "Test1", iconId =R.drawable.ic_holder),
    TEST2(title = "Test2", iconId =R.drawable.ic_holder),
    TEST3(title = "Test3", iconId =R.drawable.ic_holder)
}