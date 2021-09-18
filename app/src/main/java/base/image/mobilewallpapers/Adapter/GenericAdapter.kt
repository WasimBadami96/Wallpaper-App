package base.image.mobilewallpapers.Adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class GenericAdapter<T>(val itemList:List<T>,val viewBinding: ViewBinding) : RecyclerView.Adapter<GenericViewHolder<T>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenericViewHolder<T> {
        return GenericViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: GenericViewHolder<T>, position: Int) {
        bindData(holder,itemList[position])
    }

    override fun getItemCount(): Int = itemList.size

    abstract fun bindData(holder: GenericViewHolder<T>,model:T)

}

class GenericViewHolder<T>(val viewBinding: ViewBinding) : RecyclerView.ViewHolder(viewBinding.root) {
    val mBinding = viewBinding.root
    fun bindData(model: T){

    }
}
