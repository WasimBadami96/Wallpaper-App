package base.image.mobilewallpapers
import android.os.Bundle
import android.widget.Gallery
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import base.image.mobilewallpapers.Adapter.ImageType
import base.image.mobilewallpapers.Fragments.CategoriesFragment
import base.image.mobilewallpapers.Adapter.ViewPagerAdapter
import base.image.mobilewallpapers.Fragments.*
import base.image.mobilewallpapers.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val toolbar: Toolbar = binding.toolbarid
        setSupportActionBar(toolbar)
        val tablayout: TabLayout = binding.tabLayout
        val viewpager: ViewPager2 = binding.viewPager2

        val mFragList = arrayListOf<Fragment>(
            CategoriesFragment(),GalleryFragment.newInstance(ImageType.RECENT),
            GalleryFragment.newInstance(ImageType.RANDOM), GalleryFragment.newInstance(ImageType.POPULAR),
            MostPopularFragment()
        )
        val adapter = ViewPagerAdapter(mFragList,supportFragmentManager ,lifecycle)
        viewpager.adapter = adapter

        TabLayoutMediator(tablayout, viewpager )
        {
         tab ,position ->

                when (position) {
                    0 -> {
                       tab.text = "CATEGORIES"
                    }
                    1 -> {
                        tab.text = "RECENT"
                    }
                    2 -> {
                        tab.text = "RANDOM"
                    }
                    3 -> {
                        tab.text = "WEEKLY POPULAR"
                    }
                    4 -> {
                        tab.text = "MOST POPULAR"
                    }
            }
        }.attach()

    }
}