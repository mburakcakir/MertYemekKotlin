package com.mburcak.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView

import androidx.fragment.app.Fragment
import com.mburcak.R
import com.mburcak.util.ContactUtils


class ContactFragment : Fragment() , View.OnClickListener {

    internal lateinit var contactView: View
    internal lateinit var imgPhone: ImageView
    internal lateinit var imgEmail: ImageView
    internal lateinit var imgWebsite: ImageView
    internal lateinit var imgFacebook: ImageView
    internal lateinit var imgInstagram: ImageView
    internal lateinit var imgTwitter: ImageView
     var mEditTextSubject: EditText?=null
     var mEditTextMessage: EditText?=null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var inflater = inflater

        inflater = LayoutInflater.from(container!!.context)
        contactView = inflater.inflate(R.layout.fragment_contact, container, false)
        init()
        initListeners()

        return contactView
    }

    internal fun initListeners() {
        imgPhone.setOnClickListener(this)
        imgEmail.setOnClickListener(this)
        imgWebsite.setOnClickListener(this)
        imgTwitter.setOnClickListener(this)
        imgFacebook.setOnClickListener(this)
        imgInstagram.setOnClickListener(this)
    }

    internal fun init() {
        imgPhone = contactView.findViewById(R.id.imgPhone)
        imgEmail = contactView.findViewById(R.id.imgEmail)
        imgWebsite = contactView.findViewById(R.id.imgWebsite)
        imgFacebook = contactView.findViewById(R.id.imgFacebook)
        imgInstagram = contactView.findViewById(R.id.imgInstagram)
        imgTwitter = contactView.findViewById(R.id.imgTwitter)
        mEditTextSubject = contactView.findViewById(R.id.edit_text_subject)
        mEditTextMessage = contactView.findViewById(R.id.edit_text_message)
    }

    override fun onClick(view: View) {
        ContactUtils.clickContactItems(view, activity!!,getView()!!)
    }
}
