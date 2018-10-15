package conselheiro.antonio.registerapp

import android.content.Context

class PreferencesHelper(context: Context){
    companion object {
        val DEVELOPER_MODE = false
        private val DEVICE_TOKEN = "data.source.prefs.DEVICE_TOKEN"
    }
}