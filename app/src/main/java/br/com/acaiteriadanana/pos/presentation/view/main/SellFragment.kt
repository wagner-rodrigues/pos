package br.com.acaiteriadanana.pos.presentation.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.acaiteriadanana.pos.R
import br.com.acaiteriadanana.pos.databinding.SellFragmentBinding
import br.com.acaiteriadanana.pos.presentation.view.BaseFragment

class SellFragment : BaseFragment() {

    private lateinit var binding: SellFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.sell_fragment, container, false)
        binding = SellFragmentBinding.bind(view)
        return view
    }

}