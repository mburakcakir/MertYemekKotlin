package com.mburcak.ui.activity

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.ListFragment

// Created Fragments
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mburcak.R
import com.mburcak.ui.fragment.ContactFragment
import com.mburcak.ui.fragment.GalleryFragment
import com.mburcak.ui.fragment.LocationFragment
import com.mburcak.ui.fragment.MenuFragment

open class BaseActivity : AppCompatActivity() {

    internal var bottomNavigationView: BottomNavigationView? = null

    internal var menuFragment = MenuFragment()
    internal var locationFragment = LocationFragment()
    internal var listFragment = com.mburcak.ui.fragment.ListFragment()
    internal var galleryFragment = GalleryFragment()
    internal var contactFragment = ContactFragment()
    internal lateinit var toolbar: Toolbar

    //  BaseFragment baseFragment = new BaseFragment();

    fun changeFragment(fragment: Fragment, text: String) {

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()

        toolbar = findViewById(R.id.toolbar)
        toolbar.title = text


    }


}
