package tsisyk.app.mycv.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(
    entities = [InfoEntry::class, WorkExperienceEntry::class],
    version = 1
)

abstract class MyCvDatabase : RoomDatabase() {
    abstract fun infoDao(): InfoDao
    abstract fun workExperienceDao(): WorkExperienceDao

    companion object {
        @Volatile var instance: MyCvDatabase? = null
        private val LOCK_STATE = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK_STATE) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, MyCvDatabase::class.java, "cv.db")
                .build()
    }
}