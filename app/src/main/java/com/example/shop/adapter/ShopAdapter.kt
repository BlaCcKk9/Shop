package com.example.shop.adapter

import android.annotation.SuppressLint
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.shop.R
import com.example.shop.interfaces.ShopClickListener
import com.example.shop.model.data.Shops
import com.example.shop.utils.setImage
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.item_shop.view.*
import java.net.URL


class ShopAdapter(private val shops: List<Shops>, private val listener: ShopClickListener): BaseRecyclerViewAdapter<ShopAdapter.ShopViewHolder>() {

    companion object {
        const val LAYOUT = R.layout.item_shop
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopViewHolder {
        return ShopViewHolder(buildView(parent, viewType), listener)
    }

    override fun getItemViewType(position: Int): Int = LAYOUT


    override fun onBindViewHolder(holder: ShopViewHolder, position: Int) {
        holder.bind(shops[position])
    }

    override fun getItemCount(): Int = shops.size


    inner class ShopViewHolder(itemView: View, private val listener: ShopClickListener): BaseViewHolder(
        itemView
    ){

        fun bind(shops: Shops){
            itemView.apply {
                setupBackgroundImage(shops.backgroundUrl)
                ivShopIcon.setImage(shops.logoUrl)
                tvName.text = shops.name
                tvIsActive.text = if (shops.isActive) "" else "no delivery"
                setOnClickListener { listener.onShopClicked(shops) }
            }
        }

        @SuppressLint("CheckResult")
        private fun setupBackgroundImage(url: String){
            Single.fromCallable {
                // Here we load a simple string from the web service.
                val url = URL(url)
                val connection = url.openConnection()
                var inputStream = connection.getInputStream()
                return@fromCallable BitmapFactory.decodeStream(inputStream)
            }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ text ->
                    // And then we display it.
//                    Glide.with(context).load(BitmapDrawable(context.resources, text)).into(itemView.ivBackground)
                    itemView.ivBackground.background = BitmapDrawable(context.resources, text)
                }, {
                    it.printStackTrace()
                })
        }
    }
}