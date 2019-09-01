package com.mburcak.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mburcak.R


class BaseFragment : Fragment() {

    internal lateinit var baseView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        baseView = inflater.inflate(R.layout.fragment_base, container, false)
        return baseView
    }


}
