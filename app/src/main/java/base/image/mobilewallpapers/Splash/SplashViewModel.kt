package base.image.mobilewallpapers.Splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SplashViewModel : ViewModel() {

    val flagVal:LiveData<Boolean> = MutableLiveData<Boolean>(true)

    fun test(){


    }
}