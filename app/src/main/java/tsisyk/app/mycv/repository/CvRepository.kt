package tsisyk.app.mycv.repository

import androidx.lifecycle.LiveData
import tsisyk.app.mycv.database.InfoEntry

interface CvRepository {
    suspend fun getInfo(): LiveData<InfoEntry>
}