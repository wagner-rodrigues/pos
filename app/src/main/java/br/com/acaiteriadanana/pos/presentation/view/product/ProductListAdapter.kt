package br.com.acaiteriadanana.pos.presentation.view.product

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import br.com.acaiteriadanana.pos.R
import br.com.acaiteriadanana.pos.common.ImageUtils
import br.com.acaiteriadanana.pos.domain.Product
import br.com.acaiteriadanana.pos.domain.ProductTypeMapper
import br.com.acaiteriadanana.pos.presentation.view.product.ProductListAdapter.ViewHolder

class ProductListAdapter(private val context: Context, private val products: List<Product>) :
    Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.manage_product_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(products[position]) {
            holder.name.text = name
            holder.type.text = ProductTypeMapper.from(type)
            ImageUtils(context).loadFromByteArray(holder.image, image)
        }
    }

    override fun getItemCount() = products.size

    class ViewHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem) {
        val name: TextView = viewItem.findViewById(R.id.tvProductName)
        val type: TextView = viewItem.findViewById(R.id.tvProductType)
        val image: ImageView = viewItem.findViewById(R.id.ivProduct)
    }

}
