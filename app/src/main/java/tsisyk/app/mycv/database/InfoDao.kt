package tsisyk.app.mycv.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface InfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(infoEntry: InfoEntry)

    @Query("select * from MyInfo where id = 1")
    fun getInfo (): LiveData<InfoEntry>
}