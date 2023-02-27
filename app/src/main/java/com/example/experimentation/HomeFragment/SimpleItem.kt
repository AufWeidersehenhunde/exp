package com.example.experimentation.HomeFragment

import android.view.View
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.experimentation.R
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem
import de.hdodenhof.circleimageview.CircleImageView
import java.lang.invoke.LambdaConversionException


class SimpleItem(
    val id: String? = null, val name: String? = null, val age: String? = null, val image:String?=null, private val ti:(SimpleItem)->Unit
) : AbstractItem<SimpleItem.ViewHolder>() {

        override val type: Int
        get() = R.id.identificator

        override val layoutRes: Int
        get() = R.layout.recycler_item

        override fun getViewHolder(v: View): ViewHolder {
            return ViewHolder(v)

        }

        class ViewHolder(view: View) : FastAdapter.ViewHolder<SimpleItem>(view) {
            var name: TextView = view.findViewById(R.id.name)
            var age: TextView = view.findViewById(R.id.age)
            var image: CircleImageView = view.findViewById(R.id.imageView)

            override fun bindView(item: SimpleItem, payloads: List<Any>) {
                name.text = item.name
                age.text = item.age
                Glide.with(image.context)
                    .load(item.image)
                    .into(image)
                image.setOnClickListener {
                    item.ti(item)
                }
            }

            override fun unbindView(item: SimpleItem) {
                name.text = null
                age.text = null
            }
        }
    }