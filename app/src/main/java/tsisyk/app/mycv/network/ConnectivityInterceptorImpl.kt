package tsisyk.app.mycv.network

import android.content.Context
import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import okhttp3.Interceptor
import okhttp3.Response
import tsisyk.app.mycv.utils.NoWifiException

class ConnectivityInterceptorImpl(context: Context) : ConnectivityInterceptor {

    private var applicationContext = context.applicationContext

    override fun intercept(chain: Interceptor.Chain): Response {
        if (!isConnected()) throw NoWifiException()
        return chain.proceed(chain.request())
    }

    private fun isConnected(): Boolean {
        var connectivityManager = applicationContext.getSystemService(CONNECTIVITY_SERVICE)
                as ConnectivityManager
        var network = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        return network != null && network.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) &&
                network.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
    }

}


