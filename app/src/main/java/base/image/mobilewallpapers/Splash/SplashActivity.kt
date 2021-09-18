package base.image.mobilewallpapers.Splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import base.image.mobilewallpapers.MainActivity
import base.image.mobilewallpapers.R
import base.image.mobilewallpapers.databinding.ActivitySplashBinding
import base.image.mobilewallpapers.databinding.ActivitySplashNewBinding

class SplashActivity : AppCompatActivity() {


    private var pStatus = 0
    private lateinit var binding: ActivitySplashBinding
    val mViewModel:SplashViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mViewModel.flagVal.observe(this,{

        })
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //progress bar
        val progressBar = binding.progressBar
        val txtProgress = binding.txtProgress
        // var handler = Handler(Looper.getMainLooper())
        var handler : Handler = Handler(Looper.getMainLooper())

        Thread {
            while (pStatus <= 100) {
                handler.post(Runnable {
                    progressBar.setProgress(pStatus)
                    txtProgress.setText(pStatus.toString() + "%")
                })
                try {
                    Thread.sleep(100)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
                pStatus =pStatus+4
            }
            val intent = Intent(applicationContext ,MainActivity::class.java)
            startActivity(intent)
        }.start()
    }
}