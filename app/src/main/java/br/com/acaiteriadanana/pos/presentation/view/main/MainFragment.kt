package br.com.acaiteriadanana.pos.presentation.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.acaiteriadanana.pos.databinding.MainFragmentBinding
import br.com.acaiteriadanana.pos.presentation.view.BaseFragment

class MainFragment: BaseFragment() {

    private lateinit var binding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        configureEvents()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun configureEvents() = with(binding) {

    }

}