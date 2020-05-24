package tsisyk.app.mycv.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MyInfo")
class InfoEntry (
    @ColumnInfo(name = "email")
    val email: String,
    @ColumnInfo(name = "github")
    val github: String,
    @ColumnInfo(name ="image")
    val image: String,
    @ColumnInfo(name ="linkedIn")
    val linkedIn: String,
    @ColumnInfo(name ="name")
    val name: String,
    @ColumnInfo(name ="position")
    val position: String,
    @ColumnInfo(name ="summary")
    val summary: String,
    @ColumnInfo(name ="tel")
    val tel: String
){
    @PrimaryKey(autoGenerate = false)
    var id: Int = 1
}

