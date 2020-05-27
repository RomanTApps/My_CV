package tsisyk.app.mycv.repository

import androidx.lifecycle.LiveData
import tsisyk.app.mycv.database.InfoEntry
import tsisyk.app.mycv.database.WorkExperienceDetaileEntry
import tsisyk.app.mycv.database.WorkExperienceEntry

interface MyCvRepository {
    suspend fun getInfo(): LiveData<InfoEntry>

    suspend fun getWorkExperience(): LiveData< List<WorkExperienceEntry>>

    suspend fun getWorkExperienceDetails(firmName: String): LiveData<WorkExperienceDetaileEntry>
}