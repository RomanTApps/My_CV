package tsisyk.app.mycv.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface WorkExperienceDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(workExperienceEntry: List<WorkExperienceEntry>)

    @Query("select * from work_experience")
    fun getWorkExperience (): LiveData<List<WorkExperienceEntry>>

    @Query("select count(firmName) from work_experience")
    fun countWorkExperience (): Int
}