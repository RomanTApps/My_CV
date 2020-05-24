package tsisyk.app.mycv.network

import androidx.lifecycle.LiveData
import tsisyk.app.mycv.network.response.InfoResponse

interface NetWorkDataSource {
    val fetchedInfo : LiveData<InfoResponse>

    suspend fun fetchInfo ()
}