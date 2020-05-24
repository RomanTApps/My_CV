package tsisyk.app.mycv.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import tsisyk.app.mycv.network.response.InfoResponse
import tsisyk.app.mycv.utils.NoWifiException

class NetWorkDataSourceImpl(private val myMockApiService: MyMockApiService) : NetWorkDataSource {

    private val _fetchedInfo = MutableLiveData<InfoResponse>()

    override val fetchedInfo: LiveData<InfoResponse>
        get() = _fetchedInfo

    override suspend fun fetchInfo() {

        try {
            _fetchedInfo.postValue(myMockApiService.getPrimaryInformation().await())
        } catch (e: NoWifiException) {
            Log.e("Error",  e.toString())
        }
    }
}