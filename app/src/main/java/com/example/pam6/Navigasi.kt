package com.example.pam6

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pam6.model.Siswa
import com.example.pam6.view.FormSiswa
import com.example.pam6.view.TampilData
import com.example.pam6.viewmodel.SiswaViewModel

enum class Navigasi {
    Formulir,
    Detail
}

@Composable
fun SiswaApp(
    //edit 1 : parameter viewModel
    navController: NavHostController = rememberNavController(),
    modifier: Modifier,
    viewModel: SiswaViewModel = viewModel ()
){
    Scaffold { isiRuang->
        //edit 2 ; tambahkan variabel uiState
        val uiState = viewModel.statusUI.collectAsState()
        NavHost(
            navController = navController,
            startDestination = Navigasi.Formulir.name,

            modifier = Modifier.padding(isiRuang)){
            composable(route = Navigasi.Formulir.name){
                //edit 3 ; tambahkan variabel konteks
                val konteks = LocalContext.current
                FormSiswa (
                    //pilihanJK = JenisK.map { id -> konteks.resources.getString(id) },
                    OnSubmitBtnClick = {
                        navController.navigate(Navigasi.Detail.name)
                    }
                )
            }
            composable(route = Navigasi.Detail.name){
                TampilData(
                    onBackBtnClick = {cancelAndBackToFormulir(navController)}
                )
            }
        }
    }
}
private fun cancelAndBackToFormulir(
    navController: NavHostController
) {
    navController.popBackStack(Navigasi.Formulir.name, inclusive = false)
}