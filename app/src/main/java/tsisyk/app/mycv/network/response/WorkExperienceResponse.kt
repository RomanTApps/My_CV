package tsisyk.app.mycv.network.response


import com.google.gson.annotations.SerializedName
import tsisyk.app.mycv.database.WorkExperienceEntry

data class WorkExperienceResponse(
    @SerializedName("work experiance")
    var workExperienceEntry: List<WorkExperienceEntry>
)