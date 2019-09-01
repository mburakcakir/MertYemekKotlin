package com.mburcak.networking

import com.mburcak.model.UserModel
import io.reactivex.Observable
import retrofit2.http.GET

interface ServiceApi {
    /*
    @GET("moviesData.txt")
    Observable<List<FilmModel>> getFilms();
    // https://jsonparsingdemo-cec5b.firebaseapp.com/jsonData/moviesData.txt
*/
    @get:GET("posts")
    val users: Observable<List<UserModel>>
    // https://jsonplaceholder.typicode.com/posts
    /*
    @GET("users?page=2")
    Observable<List<DataModel>> getData();
    // https://reqres.in/api/users?page=2
*/
    /*
    @GET(".json")
    Observable<List<DataModel>> getData();
    // https://null-86c43.firebaseio.com/.json
*/


}