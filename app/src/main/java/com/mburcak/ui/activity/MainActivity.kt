package com.mburcak.ui.activity

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mburcak.R
import com.mburcak.di.DynamicConstants
import com.mburcak.util.ContactUtils

class MainActivity : BaseActivity() {
    //  private TextView mTextMessage;
    //  @BindView(R.id.btnWhatsApp) Button btnWhatsApp;
    internal lateinit var btnWhatsApp: Button

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_menu -> {
                //     mTextMessage.setText(R.string.menu);
                changeFragment(menuFragment, getString(R.string.textMenu))
                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_location -> {
                changeFragment(locationFragment, getString(R.string.textLocation))
                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_list -> {
                changeFragment(listFragment, getString(R.string.textList))
                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_gallery -> {
                changeFragment(galleryFragment, getString(R.string.textGallery))
                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_contact -> {
                changeFragment(contactFragment, getString(R.string.textContact))
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        changeFragment(menuFragment, getString(R.string.textWelcome))
        //  mTextMessage = findViewById(R.id.message);

        bottomNavigationView = findViewById(R.id.nav_view)
        bottomNavigationView!!.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        btnWhatsApp = findViewById(R.id.btnWhatsApp)

        btnWhatsApp.setOnClickListener { ContactUtils().connectWhatsapp(this@MainActivity) }

        chooseNotificationFragment()

    }

    fun chooseNotificationFragment() {

        if (!DynamicConstants.MOVE_FRAGMENT_NAME_BY_NOTIFICATION.equals("")) {

            if (DynamicConstants.MOVE_FRAGMENT_NAME_BY_NOTIFICATION.equals("menu")) {
                changeFragment(menuFragment, "")
            } else if (DynamicConstants.MOVE_FRAGMENT_NAME_BY_NOTIFICATION.equals("location")) {
                changeFragment(locationFragment, "")
            } else if (DynamicConstants.MOVE_FRAGMENT_NAME_BY_NOTIFICATION.equals("list")) {
                changeFragment(listFragment, "")
            } else if (DynamicConstants.MOVE_FRAGMENT_NAME_BY_NOTIFICATION.equals("contact")) {
                changeFragment(galleryFragment, "")
            } else {
                //   DynamicConstants.MOVE_FRAGMENT_NAME_BY_NOTIFICATION="";
                changeFragment(contactFragment, "")
            }
        }

    }
}
