package br.com.acaiteriadanana.pos.presentation.view.product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.activity.result.contract.ActivityResultContracts.TakePicturePreview
import androidx.activity.result.launch
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import br.com.acaiteriadanana.pos.R
import br.com.acaiteriadanana.pos.common.ImageUtils
import br.com.acaiteriadanana.pos.common.ResultState.Error
import br.com.acaiteriadanana.pos.common.ResultState.Loading
import br.com.acaiteriadanana.pos.common.ResultState.Success
import br.com.acaiteriadanana.pos.data.product.ProductTypeEnum
import br.com.acaiteriadanana.pos.databinding.ProductManagerFragmentBinding
import br.com.acaiteriadanana.pos.domain.Product
import br.com.acaiteriadanana.pos.presentation.viewmodel.ProductManagerViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class ProductManagerFragment : Fragment() {

    private lateinit var binding: ProductManagerFragmentBinding
    private val productManagerViewModel by viewModel<ProductManagerViewModel>()
    private val arguments: ProductManagerFragmentArgs by navArgs()

    private val takePicture = registerForActivityResult(TakePicturePreview()) {
        binding.ivProductImage.setImageBitmap(it)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ProductManagerFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureEvents()
        configureView()
        if (arguments.productId > 0L) {
            loadEditData()
        }
    }

    private fun configureView() {
        binding.spProductType.adapter =
            ArrayAdapter(requireContext(), R.layout.spinner_item, ProductTypeEnum.values()).also {
                it.setDropDownViewResource(R.layout.spinner_dropdown_item)
            }

        binding.ivProductImage.let { imageView ->
            imageView.setOnClickListener {
                takePicture.launch()
            }
        }
    }

    private fun configureEvents() {
        productManagerViewModel.productData.observe(viewLifecycleOwner, {
            when (it) {
                is Error -> showError()
                is Loading -> showLoading()
                is Success -> showSuccess(it.data)
            }
        })
    }

    private fun showSuccess(data: Product?) {
        with(binding) {
            data?.also {
                etProductName.setText(it.name)
                ImageUtils(requireContext()).loadFromByteArray(ivProductImage, it.image)
            }
        }
    }

    private fun showLoading() {
        TODO("Not yet implemented")
    }

    private fun showError() {
        TODO("Not yet implemented")
    }

    private fun loadEditData() {
        productManagerViewModel.fetchProduct(arguments.productId)
    }
}