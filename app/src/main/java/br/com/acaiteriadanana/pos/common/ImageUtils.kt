package br.com.acaiteriadanana.pos.common


import android.content.Context
import android.widget.ImageView
import br.com.acaiteriadanana.pos.R
import com.bumptech.glide.Glide

class ImageUtils(val context: Context) {

    fun loadFromUrl(imageUrl: String, imageView: ImageView) =
        Glide
            .with(context)
            .load(imageUrl)
            .placeholder(R.drawable.ic_loading_product)
            .into(imageView)

    fun loadFromByteArray(imageView: ImageView, image: ByteArray) {
        Glide.with(context)
            .load(image)
            .placeholder(R.drawable.ic_loading_product)
            .into(imageView);
    }
}
