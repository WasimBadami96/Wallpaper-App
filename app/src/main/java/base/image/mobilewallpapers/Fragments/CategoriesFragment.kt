package base.image.mobilewallpapers.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import base.image.mobilewallpapers.Adapter.CategoriesAdapter
import base.image.mobilewallpapers.Adapter.RecentAdapterview
import base.image.mobilewallpapers.Adapter.catModel
import base.image.mobilewallpapers.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.util.ArrayList


class CategoriesFragment : Fragment() {

   // private var layoutManager: RecyclerView.LayoutManager? = null
   // private var adapter: RecyclerView.Adapter<CategoriesAdapter.viewHolder>? = null

    lateinit var mRecyclerView: RecyclerView
    val database = FirebaseDatabase.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_categories, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mRecyclerView = view.findViewById(R.id.recycler_viewlayout);

        //firebase data

        val mRef = FirebaseDatabase.getInstance()
            .getReferenceFromUrl("https://wallpaper-5aadf-default-rtdb.asia-southeast1.firebasedatabase.app")
            .child("Wallpaper/")
        mRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val rList: MutableList<catModel?> = ArrayList<catModel?>()
                for (postSnapshot in dataSnapshot.children) {
                    try {
                        val rec: catModel? = postSnapshot.getValue(catModel::class.java)
                        rList.add(rec)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
                mRecyclerView.adapter = CategoriesAdapter(rList)
            }

            override fun onCancelled(databaseError: DatabaseError) {

                Toast.makeText(
                    activity,
                    databaseError.message + "  " + databaseError.details, Toast.LENGTH_LONG
                ).show()
            }
        })

        //dynamic data
        /*val list02 = CategoriesAdapter(listOf(catModel("Birds",R.drawable.birds),
            catModel("Kids",R.drawable.kids),
            catModel("Sea",R.drawable.sea),
            catModel("Nature",R.drawable.nature),
            catModel("Cats",R.drawable.cats),
            catModel("Cars",R.drawable.cars),
            catModel("Pattern",R.drawable.pattern)))
        mRecyclerView.adapter = list02*/

    }


}