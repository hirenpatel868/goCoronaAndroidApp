package dev.skymansandy.base.util.location

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import android.widget.Toast
import androidx.preference.PreferenceManager
import dev.skymansandy.base.R
import dev.skymansandy.base.ui.base.BaseActivity
import java.util.*

object LocaleUtils {
    private var sLocale: Locale? = null

    fun setLocale(locale: Locale) {
        sLocale = locale
        sLocale?.let {
            Locale.setDefault(it)
        }
    }

    private fun updateConfig(activity: Activity) {
        sLocale?.let {
            val configuration = Configuration()
            configuration.setLocale(it)
            activity.baseContext.resources.updateConfiguration(
                configuration,
                activity.baseContext.resources.displayMetrics
            )
            if (activity is BaseActivity<*, *, *, *>) {
                activity.recreate()
                activity.recreate()
            }
        }
    }

    fun setupLocale(context: Context) {
        val localeStr = PreferenceManager.getDefaultSharedPreferences(context).getString(
            context.getString(R.string.pref_key_app_language),
            context.getString(R.string.pref_app_language_english)
        )
        localeStr?.let {
            setLocale(Locale(it))
            if (context is Activity)
                updateConfig(context)
            Toast.makeText(
                context,
                context.resources.configuration.locale.toString(),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    @SuppressLint("ApplySharedPref")
    fun updateAppLanguage(context: Context, localeString: String) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString(
            context.getString(R.string.pref_key_app_language), localeString
        ).commit()
        setupLocale(context)
    }
}