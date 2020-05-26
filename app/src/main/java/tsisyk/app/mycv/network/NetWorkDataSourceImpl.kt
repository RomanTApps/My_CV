package tsisyk.app.mycv.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import tsisyk.app.mycv.network.response.InfoResponse
import tsisyk.app.mycv.utils.NoWifiException

class NetWorkDataSourceImpl(private val myMockApiService: MyMockApiService) : NetWorkDataSource {

    private val _downloadedMyInfo = MutableLiveData<InfoResponse>()

    override val downloadedMyInfo: LiveData<InfoResponse>
        get() = _downloadedMyInfo

    override suspend fun fetchInfo() {

        try {
            _downloadedMyInfo.postValue(myMockApiService.getInfo().await())
        } catch (e: NoWifiException) {
            Log.e("Error",  e.toString())
        }
    }
}