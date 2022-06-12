package com.talhafaki.fuud.ui.screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.talhafaki.fuud.data.FuudRepository
import com.talhafaki.fuud.data.Result
import com.talhafaki.fuud.domain.FuudResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by talhafaki on 12.06.2022.
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: FuudRepository
): ViewModel() {

    fun getFuud(): MutableLiveData<Result<List<FuudResponse>>> {
        val ld = MutableLiveData<Result<List<FuudResponse>>>()
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getFuudList()
            ld.postValue(response)
        }
        return ld
    }

}