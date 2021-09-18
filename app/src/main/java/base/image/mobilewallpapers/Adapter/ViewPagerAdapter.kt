package base.image.mobilewallpapers.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import base.image.mobilewallpapers.Fragments.*

class ViewPagerAdapter(val fragList:List<Fragment>,fragmentManager: FragmentManager ,lifecycle: Lifecycle) :FragmentStateAdapter(fragmentManager, lifecycle)
{
    override fun getItemCount(): Int =fragList.size
    override fun createFragment(position: Int): Fragment = fragList[position]
}