package com.mburcak.util

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import com.mburcak.R
import com.mburcak.di.Constants

class ContactUtils {

    fun connectWhatsapp(activity: Activity) {

        val url = "https://api.whatsapp.com/send?phone=" + Constants.NUMBER_WHATSAPP
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(url)
        activity.startActivity(i)
    }

    companion object {


        internal fun makeCall(activity: Activity) {
            val i = Intent(Intent.ACTION_DIAL)
            i.data = Uri.parse("tel:" + Constants.NUMBER_PHONE)
            activity.startActivity(i)
        }

        internal fun openInView(activity: Activity, url: String) {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            activity.startActivity(intent)
        }

        internal fun sendEmail(activity: Activity) {
            val emailIntent = Intent(Intent.ACTION_SENDTO)
            emailIntent.data = Uri.parse("mailto:" + "mertyemek@gmail.com")

            try {
                activity.startActivity(Intent.createChooser(emailIntent, "Send email using..."))
            } catch (ex: android.content.ActivityNotFoundException) {
                Toast.makeText(activity, "No email clients installed.", Toast.LENGTH_SHORT).show()
            }

        }

        internal fun sendEmailDialog(activity: Activity, subject: String, message: String) {
            val emailIntent = Intent(Intent.ACTION_SENDTO)
            emailIntent.data = Uri.parse("mailto:" + "mertyemek@gmail.com")
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject)
            emailIntent.putExtra(Intent.EXTRA_TEXT, message)

            try {
                activity.startActivity(Intent.createChooser(emailIntent, "Send email using..."))
            } catch (ex: android.content.ActivityNotFoundException) {
                Toast.makeText(activity, "No email clients installed.", Toast.LENGTH_SHORT).show()
            }

        }

        fun clickContactItems(view: View, activity: Activity, getView: View) {
            when (view.id) {
                R.id.imgPhone -> makeCall(activity)
                R.id.imgFacebook -> openInView(activity, Constants.URL_FACEBOOK)
                R.id.imgTwitter -> openInView(activity, Constants.URL_TWITTER)
                R.id.imgInstagram -> openInView(activity, Constants.URL_INSTAGRAM)
                R.id.imgWebsite -> openInView(activity, Constants.URL_WEBSITE)
                R.id.imgEmail -> emailControl(activity, getView)
            }
        }

        internal fun emailControl(activity: Activity, view: View) {

            val builder = AlertDialog.Builder(activity)
            builder.setTitle("Email")
            builder.setMessage("Email göndermeden önce taslak oluşturmak ister misiniz?")
            builder.setNegativeButton("Hayır") { dialog, which ->
                dialog.dismiss()
                sendEmail(activity)
            }
            builder.setPositiveButton("Evet") { dialogInterface, i ->
                val builder = AlertDialog.Builder(activity)
                builder.setTitle("Hızlı bir taslak oluşturun.")
                val viewInflated =
                    LayoutInflater.from(activity).inflate(R.layout.dialog_email_layout, view as ViewGroup, false)

                val subject = viewInflated.findViewById<EditText>(R.id.edit_text_subject)
                val message = viewInflated.findViewById<EditText>(R.id.edit_text_message)

                builder.setView(viewInflated)

                builder.setPositiveButton(android.R.string.ok) { dialog, which ->
                    dialog.dismiss()
                    sendEmailDialog(activity, subject.text.toString(), message.text.toString())
                }
                builder.setNegativeButton(android.R.string.cancel) { dialog, which -> dialog.cancel() }
                builder.show()
            }
            builder.show()
        }
    }

}