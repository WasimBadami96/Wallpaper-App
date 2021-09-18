package base.image.mobilewallpapers.Adapter

import android.widget.TextView
import base.image.mobilewallpapers.R
import base.image.mobilewallpapers.databinding.ItemRowRecentBinding

class RecentAdapter(itemList: List<catModel>, viewBinding: ItemRowRecentBinding) :
    GenericAdapter<catModel>(itemList, viewBinding) {
    override fun bindData(holder: GenericViewHolder<catModel>, model: catModel) {
        val dummyTv = holder.itemView.findViewById<TextView>(R.id.dummy_tv)

    }
}

/*
class dummyAdapter<T>(binding :ItemRowRecentBinding): RecyclerView.Adapter<GenericViewHolder<T>>(binding.root) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenericViewHolder<T> {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: GenericViewHolder<T>, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
    }
*/

