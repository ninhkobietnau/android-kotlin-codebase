package com.ninhnau.base.aiart.ui.home

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ninhnau.base.aiart.R
import com.ninhnau.base.aiart.base.BaseBindingFragment
import com.ninhnau.base.aiart.databinding.FragmentHomeBinding
import com.ninhnau.base.aiart.domain.entity.local.ImageLocal
import com.ninhnau.base.aiart.ui.history.HistoryViewModel
import com.ninhnau.base.aiart.util.HomeRecyclerViewClick
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseBindingFragment<FragmentHomeBinding>(), HomeRecyclerViewClick {

    private val viewModel by viewModels<HomeViewModel>()
    private val viewModelHistory by viewModels<HistoryViewModel>()
    private lateinit var adapter: ModelAdapter

    override fun getViewBinding(): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(layoutInflater)
    }

    override fun initEvent() {
        setupRecyclerView()
        viewModel.getArt("cat")
        viewModel.artList.observe(viewLifecycleOwner) {
            it.images.forEach { art ->
                val image = ImageLocal(0, art.src, art.prompt)
                viewModelHistory.addImage(image)
                Log.d("ninhnau", "onViewCreated: art = $art")
            }
        }

    }

    override fun onClick(prompt: String, image: Int, type: String) {
        val action = HomeFragmentDirections.actionNavigationHomeToPreviewFragment(prompt, image, type)
        findNavController().navigate(action)
    }

    private fun setupRecyclerView() {

        binding.recyclerAnimeGirl.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val listImage = arrayListOf(R.drawable.default_test_3, R.drawable.default_test_3, R.drawable.default_test_3, R.drawable.default_test_3)
        val listPrompt = arrayListOf("anime1", "anime2", "anime3", "anime4")
        adapter = ModelAdapter(requireContext(), listImage, listPrompt, getString(R.string.anime_girls),this)
        binding.recyclerAnimeGirl.adapter = adapter
    }
}