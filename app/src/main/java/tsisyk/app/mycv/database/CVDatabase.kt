package tsisyk.app.mycv.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(
    entities = [InfoEntry::class],
    version = 1
)

abstract class CVDatabase : RoomDatabase() {
    abstract fun infoDao(): InfoDao

    companion object {
        @Volatile var instance: CVDatabase? = null
        private val LOCK_STATE = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK_STATE) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, CVDatabase::class.java, "cv.db")
                .build()
    }
}