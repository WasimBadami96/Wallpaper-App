package base.image.mobilewallpapers.Adapter

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import base.image.mobilewallpapers.R


class RecentAdapterview(val list: MutableList<recModel?>) : RecyclerView.Adapter<RecentAdapterview.viewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recentrowitem,parent,false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {

       /* if (item != null) {
            holder.img1.setImageResource(item.image_one)

        }
        if (item !=null)
        {
            holder.img2.setImageResource(item.image_two)
        }
        if (item !=null)
        {
            holder.img3.setImageResource(item.image_three)
        }*/


        val item = list[position]
        //
         val mBitmap1 = convertBase64ToBitmap(item!!.image_one)
         if (mBitmap1 != null)
             holder.img1.setImageBitmap(mBitmap1)
         else
         {

         }
        //
        val mBitmap2 = convertBase64ToBitmap(item!!.image_two)
        if (mBitmap2 != null)
            holder.img2.setImageBitmap(mBitmap2)
        else
        {

        }
        //
        val mBitmap3 = convertBase64ToBitmap(item!!.image_three)
        if (mBitmap3 != null)
            holder.img3.setImageBitmap(mBitmap3)
        else
        {

        }
    }

    override fun getItemCount(): Int {

        return list.size
    }

    inner class viewHolder(itemview : View) : RecyclerView.ViewHolder(itemview)
    {
        var img1 = itemview.findViewById<ImageView>(R.id.imageView_1)
        var img2 = itemview.findViewById<ImageView>(R.id.imageView_2)
        var img3 = itemview.findViewById<ImageView>(R.id.imageView_3)
    }
    private fun convertBase64ToBitmap(b64: String): Bitmap? {

        val solution = b64.split("base64,")[1];
        val imageAsBytes = Base64.decode(solution.toByteArray(), Base64.DEFAULT)
        return BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.size)
    }

}