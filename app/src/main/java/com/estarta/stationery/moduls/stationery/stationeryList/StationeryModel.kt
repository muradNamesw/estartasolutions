package com.estarta.stationery.moduls.stationery.stationeryList



/**
// on below line we are return
// a function return parameters
 */

data class StationeryListModel  (
      var created_at: String,
      var price: String,
      var name: String,
      var uid: String,
      var image_ids: ArrayList<String>,
      var image_urls: ArrayList<String>,
      var image_urls_thumbnails: ArrayList<String>

 )



