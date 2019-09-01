package com.mburcak.ui.holder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mburcak.R

class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var filmName: TextView
    var filmStory: TextView
    var filmImage: ImageView? = null
    var filmYear: TextView? = null
    var filmDuration: TextView? = null
    var filmDirector: TextView? = null


    init {

        filmName = itemView.findViewById(R.id.filmTitleTV)
        filmStory = itemView.findViewById(R.id.filmStoryTV)


        //  filmImage = itemView.findViewById(com.mburcak.R.id.filmImageIV);
        //  filmYear = itemView.findViewById(com.mburcak.R.id.filmYearTV);
        //  filmDuration = itemView.findViewById(com.mburcak.R.id.filmDurationTV);
        //  filmStory = itemView.findViewById(com.mburcak.R.id.filmStoryTV);

    }

}
