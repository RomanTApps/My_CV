package tsisyk.app.mycv.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import tsisyk.app.mycv.network.response.InfoResponse
import tsisyk.app.mycv.network.response.WorkExperienceResponse
import tsisyk.app.mycv.utils.NoWifiException

class NetWorkDataSourceImpl(private val myMockApiService: MyMockApiService) : NetWorkDataSource {

    private val _downloadedMyInfo = MutableLiveData<InfoResponse>()
    private val _downloadedWorkExperiance = MutableLiveData<WorkExperienceResponse>()

    override val downloadedMyInfo: LiveData<InfoResponse>
        get() = _downloadedMyInfo

    override val downloadedWorkExperiance: LiveData<WorkExperienceResponse>
        get() = _downloadedWorkExperiance


    override suspend fun fetchInfo() {

        try {
            _downloadedMyInfo.postValue(myMockApiService.getInfo().await())
        } catch (e: NoWifiException) {
            Log.e("Error",  e.toString())
        }
    }

    override suspend fun fetchWorkExperience() {

        try {
            _downloadedWorkExperiance.postValue(myMockApiService.getWorkExperience().await())
        } catch (e: NoWifiException) {
            Log.e("Error",  e.toString())
        }
    }
}