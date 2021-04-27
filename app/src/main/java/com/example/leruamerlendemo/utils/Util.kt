package com.example.leruamerlendemo.utils

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.app.ActivityCompat
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.io.IOException

class Util {

    companion object{

        fun getJsonFromAsset(context: Context, fileName: String): String? {
            val jsonString: String
            try {
                jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
            } catch (ioException: IOException) {
                ioException.printStackTrace()
                return null
            }
            return jsonString
        }

        inline fun <reified T> getObjFromJson(context: Context, fileName: String): T? {
            val json = getJsonFromAsset(context, fileName)
            return if (json !== null) Json.decodeFromString(json) else null
        }
    }
}



fun Context.getResource(name:String): Drawable? {
    val resID = this.resources.getIdentifier(name , "drawable", this.packageName)
    return ActivityCompat.getDrawable(this,resID)
}