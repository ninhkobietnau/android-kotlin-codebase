package com.ninhnau.base.aiart.ui.home

import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.RelativeSizeSpan
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.navArgs
import com.ninhnau.base.aiart.R
import com.ninhnau.base.aiart.base.BaseBindingFragment
import com.ninhnau.base.aiart.databinding.FragmentPreviewBinding


class PreviewFragment : BaseBindingFragment<FragmentPreviewBinding>() {

    private val args: PreviewFragmentArgs by navArgs()

    override fun getViewBinding(): FragmentPreviewBinding {
        return FragmentPreviewBinding.inflate(layoutInflater)
    }

    override fun initEvent() {
        binding.imgPreview.setImageDrawable(ContextCompat.getDrawable(requireContext(), args.image))
        binding.imgBack.setOnClickListener {
            requireActivity().onBackPressed()
        }

        val text = "Prompt: ${args.prompt}"
        val ss1 = SpannableString(text)
        ss1.setSpan(RelativeSizeSpan(1.5f), 0, 7, 0) // set size
        ss1.setSpan(ForegroundColorSpan(ContextCompat.getColor(requireContext(), R.color.colorPrimary)), 0, 7, 0) // set color
        binding.tvPrompt.text = ss1

        val type = "Style: ${args.type}"
        val ss2 = SpannableString(type)
        ss2.setSpan(RelativeSizeSpan(1.5f), 0, 6, 0) // set size
        ss2.setSpan(ForegroundColorSpan(ContextCompat.getColor(requireContext(), R.color.colorPrimary)), 0, 6, 0) // set color
        binding.tvType.text = ss2

    }
}