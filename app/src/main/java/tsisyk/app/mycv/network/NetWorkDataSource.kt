package tsisyk.app.mycv.network

import androidx.lifecycle.LiveData
import tsisyk.app.mycv.network.response.InfoResponce

interface NetWorkDataSource {
    val fetchedInfo : LiveData<InfoResponce>

    suspend fun fetchInfo ()
}