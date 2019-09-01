package com.mburcak.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

// object printer by Muhammed Çağatay
import com.cagataymuhammet.objectprinter.ObjectPrinter
import com.mburcak.R
import com.mburcak.model.UserModel
import com.mburcak.networking.Service
import com.mburcak.networking.ServiceApi
import com.mburcak.networking.ServiceApiClient
import com.mburcak.ui.adapter.UserAdapter

// retrofit
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class ListFragment : Fragment() {
    internal lateinit var listView: View

    val serviceClient by lazy {
        ServiceApiClient.create()
    }

    var disposable: Disposable? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment



        listView = inflater.inflate(R.layout.fragment_list, container, false)

        getAllUsers()

        return listView
    }

    fun getAllUsers() {

        disposable = serviceClient.getUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                        result -> Log.v("USERS", "" + result)
                    bindToRecycleview(result)

                },
                { error -> Log.e("ERROR", error.message) }
            )
    }



    fun bindToRecycleview(userList:List<UserModel>)
    {
        val recyclerView = listView.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        var recyclerViewAdapter = UserAdapter(userList)
        recyclerView.adapter = recyclerViewAdapter
    }



    override fun onPause() {
        super.onPause()
        disposable?.dispose()
    }


}
