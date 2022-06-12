package com.talhafaki.fuud.ui.screen

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.talhafaki.fuud.data.Result
import com.talhafaki.fuud.domain.FuudResponse

/**
 * Created by talhafaki on 11.06.2022.
 */
@Composable
fun MainScreen(viewModel: MainViewModel = hiltViewModel()) {

    val result = viewModel.getFuud().observeAsState()

    when (result.value) {
        is Result.Loading -> {
            Text("Loading")
        }
        is Result.Success -> {
            (result.value as Result.Success<List<FuudResponse>>).data.firstOrNull().let {
                Text(it?.foodName.orEmpty())
            }
        }
        is Result.Error -> {
            Text((result.value as Result.Error).exception.message ?: "exception")
        }
    }
}