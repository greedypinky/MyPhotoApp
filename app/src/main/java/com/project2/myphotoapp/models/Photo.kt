package com.project2.myphotoapp.models

import java.io.Serializable

/**
 * Created by ritalaw on 2018-04-04.
 */

data class Photo(var id:String,
                 var likes:Int,
                 var favorites:Int,
                 var tags:String,
                 val previewlURL:String,
                 val webformatURL:String) : Serializable {



}
