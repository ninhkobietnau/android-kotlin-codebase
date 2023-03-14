package com.ninhnau.base.aiart.ui.history

import android.util.Log
import androidx.lifecycle.*
import com.ninhnau.base.aiart.domain.entity.local.ImageLocal
import com.ninhnau.base.aiart.domain.usecase.AddImageUseCase
import com.ninhnau.base.aiart.domain.usecase.DeleteImageUseCase
import com.ninhnau.base.aiart.domain.usecase.GetAllImageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val addImageUseCase: AddImageUseCase,
    private val getAllImageUseCase: GetAllImageUseCase,
    private val deleteImageUseCase: DeleteImageUseCase
) : ViewModel() {

    private val _imageList = MediatorLiveData<List<ImageLocal>>()
    val imageList: LiveData<List<ImageLocal>> get() = _imageList
    private var imageListSource: LiveData<List<ImageLocal>> = MutableLiveData()

    fun addImage(imageLocal: ImageLocal) {
        viewModelScope.launch(Dispatchers.Main) {
            withContext(Dispatchers.IO) {
                addImageUseCase.invoke(imageLocal)
            }
        }
    }

    fun getImage() {
        viewModelScope.launch(Dispatchers.Main) {
            _imageList.removeSource(imageListSource)
            withContext(Dispatchers.IO) {
                imageListSource = getAllImageUseCase.invoke()
            }
            try {
                _imageList.addSource(imageListSource) {
                    if (it != null) {
                        _imageList.value = it
                    }
                }
            } catch (e: Exception) {
                Log.d("ninhnau", "getImage: error = $e")
            }
        }
    }

    fun deleteImage(id: Int) {
        viewModelScope.launch(Dispatchers.Main) {
            withContext(Dispatchers.IO) {
                deleteImageUseCase.invoke(id)
            }
        }
    }

}