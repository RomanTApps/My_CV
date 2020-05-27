package tsisyk.app.mycv.database


import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class WorkExperienceDetaileEntry(
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