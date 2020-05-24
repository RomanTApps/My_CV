package tsisyk.app.mycv.repository

import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import tsisyk.app.mycv.database.InfoDao
import tsisyk.app.mycv.database.InfoEntry
import tsisyk.app.mycv.network.NetWorkDataSource
import tsisyk.app.mycv.network.response.InfoResponse

class CvRepositoryImpl(
    private val infoDao: InfoDao,
    private val netWorkDataSource: NetWorkDataSource
) : CvRepository {

    override suspend fun getInfo(): LiveData<InfoEntry> {
        return withContext(Dispatchers.IO){
            return@withContext infoDao.getInfo()
        }
    }

    init {
        netWorkDataSource.fetchedInfo.observeForever { presistFetchedInfo(it)}
    }

    private fun presistFetchedInfo (infoResponse: InfoResponse){
        GlobalScope.launch(Dispatchers.IO) { infoDao.upsert(infoResponse.InfoEntry) }
    }
}