package com.ninhnau.base.aiart.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.ninhnau.base.aiart.MainActivity

abstract class BaseBindingFragment<T: ViewBinding>: Fragment() {
    lateinit var binding: T

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = getViewBinding()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initEvent()
    }

    abstract fun getViewBinding(): T

    abstract fun initEvent()

    fun hideBottomNav() {
        if (requireActivity() is MainActivity) {
            (requireActivity() as MainActivity).hideBottomNav()
        }
    }

    fun showBottomNav() {
        if (requireActivity() is MainActivity) {
            (requireActivity() as MainActivity).showBottomNav()
        }
    }
}