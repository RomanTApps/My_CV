package tsisyk.app.mycv.database

import androidx.lifecycle.LiveData
import androidx.room.*
import tsisyk.app.mycv.network.response.InfoResponse

@Dao
interface InfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(infoEntry: InfoEntry)

    @Query("select * from MyInfo")
    fun getInfo (): LiveData<InfoEntry>
}