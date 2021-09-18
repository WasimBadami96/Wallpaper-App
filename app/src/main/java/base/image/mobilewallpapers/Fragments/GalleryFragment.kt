package base.image.mobilewallpapers.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import base.image.mobilewallpapers.Adapter.ImageType
import base.image.mobilewallpapers.Adapter.RecentAdapterview
import base.image.mobilewallpapers.Adapter.recModel
import base.image.mobilewallpapers.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.util.ArrayList

class GalleryFragment private constructor(): Fragment() {

    lateinit var myRecyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.galleryfragment, container, false)
    }

    var mPath:String = "Recent"
    companion object{
        const val GALLERY_TYPE = "GALLERY_TYPE_KEY"
        fun newInstance(type: ImageType): GalleryFragment{
            val args = Bundle()
            args.putSerializable(GALLERY_TYPE,type)
            val fragment = GalleryFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myRecyclerView = view.findViewById(R.id.recent_recyclerview)
        arguments?.let {
            mPath = ImageType.getPathName(it.getSerializable(GALLERY_TYPE) as ImageType)
        }

        val mRef = FirebaseDatabase.getInstance()
            .getReferenceFromUrl("https://wallpaper-5aadf-default-rtdb.asia-southeast1.firebasedatabase.app")
            .child("$mPath/")
        mRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val rList: MutableList<recModel?> = ArrayList<recModel?>()
                for (postSnapshot in dataSnapshot.children) {
                    try {
                        val rec: recModel? = postSnapshot.getValue(recModel::class.java)
                        rList.add(rec)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
                myRecyclerView.adapter = RecentAdapterview(rList)
            }

            override fun onCancelled(databaseError: DatabaseError) {

                Toast.makeText(
                    activity,
                    databaseError.message + "  " + databaseError.details, Toast.LENGTH_LONG
                ).show()
            }
        })

    }
}