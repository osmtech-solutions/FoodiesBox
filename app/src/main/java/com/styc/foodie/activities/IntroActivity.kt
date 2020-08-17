package com.styc.foodie.activities

import android.Manifest
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.github.appintro.AppIntro
import com.github.appintro.AppIntroFragment
import com.styc.foodie.R

class IntroActivity : AppIntro() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Make sure you don't call setContentView!
        showStatusBar(true)

        askForPermissions(
                permissions = arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION),
                slideNumber = 2,
                required = true)

        // Call addSlide passing your Fragments.
        // You can use AppIntroFragment to use a pre-built fragment
        addSlide(AppIntroFragment.newInstance(
                title = "Order Food from top and favourite restaurants",
                description = "You are few steps away to order today's cuisine",
                imageDrawable = R.drawable.first_slide,
                //backgroundDrawable = R.drawable.splashwall,
                titleColor = Color.WHITE,
                descriptionColor = Color.WHITE,
                backgroundColor = Color.BLACK,
                titleTypefaceFontRes = R.font.abeezee,
                descriptionTypefaceFontRes = R.font.abeezee
        ))
        addSlide(AppIntroFragment.newInstance(
                title = "With a wide collection of cuisines",
                description = "We required location permission to serve you better!",
                imageDrawable = R.drawable.second_slide,
                //backgroundDrawable = R.color.colorBlack,
                titleColor = Color.WHITE,
                descriptionColor = Color.WHITE,
                backgroundColor = Color.BLACK,
                titleTypefaceFontRes = R.font.abeezee,
                descriptionTypefaceFontRes = R.font.abeezee
        ))
        addSlide(AppIntroFragment.newInstance(
                title = "Delivered quickly to your doorstep",
                description = "Ready to see top restaurants to order?",
                imageDrawable = R.drawable.third_slide,
                //backgroundDrawable = R.color.colorBlack,
                titleColor = Color.WHITE,
                descriptionColor = Color.WHITE,
                backgroundColor = Color.BLACK,
                titleTypefaceFontRes = R.font.abeezee,
                descriptionTypefaceFontRes = R.font.abeezee
        ))
    }

    override fun onSkipPressed(currentFragment: Fragment?) {
        super.onSkipPressed(currentFragment)
        // Decide what to do when the user clicks on "Skip"
        val intent = Intent(this@IntroActivity, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onDonePressed(currentFragment: Fragment?) {
        super.onDonePressed(currentFragment)
        // Decide what to do when the user clicks on "Done"
        val intent = Intent(this@IntroActivity, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onUserDeniedPermission(permissionName: String) {
        // User pressed "Deny" on the permission dialog
    }
    override fun onUserDisabledPermission(permissionName: String) {
        // User pressed "Deny" + "Don't ask again" on the permission dialog
    }
}