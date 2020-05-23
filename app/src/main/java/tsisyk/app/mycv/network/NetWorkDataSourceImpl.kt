package tsisyk.app.mycv.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import tsisyk.app.mycv.network.response.InfoResponce

class NetWorkDataSourceImpl(private val myMockApiService: MyMockApiService) : NetWorkDataSource {

    private val _fetchedInfo = MutableLiveData<InfoResponce>()

    override val fetchedInfo: LiveData<InfoResponce>
        get() = _fetchedInfo

    override suspend fun fetchInfo() {

        try {
            _fetchedInfo.postValue(myMockApiService.getPrimaryInformation().await())
        } catch (e: NoWifiException) {
            Log.e("Error",  e.toString())
        }
    }
}