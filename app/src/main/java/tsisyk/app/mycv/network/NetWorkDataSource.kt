package tsisyk.app.mycv.network

import androidx.lifecycle.LiveData
import tsisyk.app.mycv.network.response.InfoResponse
import tsisyk.app.mycv.network.response.WorkExperienceResponse

interface NetWorkDataSource {
    val downloadedMyInfo : LiveData<InfoResponse>
    val downloadedWorkExperiance : LiveData<WorkExperienceResponse>

    suspend fun fetchInfo ()
    suspend fun fetchWorkExperience ()
}