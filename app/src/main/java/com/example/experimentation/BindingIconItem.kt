package com.example.experimentation

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.experimentation.databinding.RecyclerItemBinding
import com.mikepenz.fastadapter.binding.AbstractBindingItem

class BindingIconItem (
    val id: String? = null, val namee: String? = null, val age: Int? = null, val icon:String?=null
        ) : AbstractBindingItem<RecyclerItemBinding>() {

    override val type: Int
        get() = R.id.identificator

    override fun bindView(binding: RecyclerItemBinding, payloads: List<Any>) {
        with(binding) {
            name.text = namee
            this.age.text = this@BindingIconItem.age.toString()
            Glide.with(imageView.context)
                .load(icon)
                .into(imageView)
        }
    }

    override fun createBinding(inflater: LayoutInflater, parent: ViewGroup?): RecyclerItemBinding {
        return RecyclerItemBinding.inflate(inflater, parent, false)
    }
}