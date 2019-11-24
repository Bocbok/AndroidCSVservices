package com.cic.mappermission

import android.app.IntentService
import android.content.Intent
import android.os.IBinder
import java.io.FileWriter
import java.io.IOError
import java.io.IOException
import java.lang.Exception

class ServiceCSV : IntentService("ServiceCSV") {

    override fun onHandleIntent(p0: Intent?) {

        val path = getExternalFilesDir(null)
        var fileWriter : FileWriter? = null

        print(path)

        try {
            fileWriter = FileWriter(path.toString() + "coord.csv", true)
            val coord = p0?.extras?.getString("coord")
            fileWriter.append(coord + '\n')
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            try {
                fileWriter!!.flush()
                fileWriter.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

    override fun onBind(p0: Intent?): IBinder? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}