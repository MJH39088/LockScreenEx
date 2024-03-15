package com.hmj3908.lockscreenex

import android.os.Bundle
import android.view.MotionEvent
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.hmj3908.lockscreenex.viewmodel.LockScreenViewModel
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.hmj3908.lockscreenex.databinding.ActivityLockScreenBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LockScreenActivity: AppCompatActivity() {

    private lateinit var binding: ActivityLockScreenBinding
    private val viewModel: LockScreenViewModel by viewModels()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_lock_screen)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        window.addFlags(
            WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED or
                    WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD or
                    WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON or
                    WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON)

        viewModel.imageUrl.observe(this) { imageUrl ->
            Glide.with(this)
                .load(imageUrl)
                .into(binding.imageView)
        }



    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return when (event.action) {
            MotionEvent.ACTION_MOVE -> {
                finish()
                true
            }
            else -> super.onTouchEvent(event)
        }
    }
}