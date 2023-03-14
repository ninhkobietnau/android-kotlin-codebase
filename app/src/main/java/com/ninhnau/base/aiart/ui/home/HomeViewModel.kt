package com.ninhnau.base.aiart.ui.home

import android.util.Log
import androidx.lifecycle.*
import com.ninhnau.base.aiart.domain.entity.AIArt
import com.ninhnau.base.aiart.domain.usecase.GetAIArtUseCase
import com.ninhnau.base.common.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAIArtUseCase: GetAIArtUseCase
) : ViewModel() {

    private val _artList = MediatorLiveData<AIArt>()
    val artList: LiveData<AIArt> get() = _artList
    private var artListSource: LiveData<Resource<AIArt>> = MutableLiveData()

    fun getArt(prompt: String) {
        viewModelScope.launch(Dispatchers.Main) {
            _artList.removeSource(artListSource)
            withContext(Dispatchers.IO) {
                artListSource = getAIArtUseCase.invoke(prompt)
            }
            try {
                _artList.addSource(artListSource) {
                    if (it != null) {
                        _artList.value = it.data ?: AIArt(emptyList())
                        when (it.status) {
                            Resource.Status.ERROR -> {
                                Log.d("ninhnau", "getArt: err")
                            }
                            Resource.Status.SUCCESS -> {
                                Log.d("ninhnau", "getArt: succ")
                            }
                            else -> {
                                Log.d("ninhnau", "getArt: loading")
                            }
                        }
                    } else {
                        Log.d("ninhnau", "getArt: res null")
                    }
                }
            } catch (e: Exception) {

            }
        }
    }
}