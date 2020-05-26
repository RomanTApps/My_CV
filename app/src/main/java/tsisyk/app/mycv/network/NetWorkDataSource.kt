package tsisyk.app.mycv.network

import androidx.lifecycle.LiveData
import tsisyk.app.mycv.network.response.InfoResponse

interface NetWorkDataSource {
    val downloadedMyInfo : LiveData<InfoResponse>

    suspend fun fetchInfo ()
}