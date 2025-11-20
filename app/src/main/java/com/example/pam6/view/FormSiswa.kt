package com.example.pam6.view

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormSiswa(
    //edit 1 ; parameter pilihan JK dan onSubmitButtonClicked
    pilihanJK: List<String>,
    onSubmitButtonClicked: (MutableList<String>) -> Unit,
    modifier: Modifier = Modifier
){}