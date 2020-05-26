package tsisyk.app.mycv.database


import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "work_experience", indices = [Index(value = ["firmName"], unique = true)])
data class WorkExperienceEntry(
    var date: String,
    @PrimaryKey(autoGenerate = false)
    @SerializedName("firm_name")
    var firmName: String,
    var logo: String,
    var languages: String,
    var libraries: String,
    var location: String,
    var position: String,
    var responsibility: String,
    var team: String,
    var tools: String
)