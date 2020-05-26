package tsisyk.app.mycv.network.response



import com.google.gson.annotations.SerializedName
import tsisyk.app.mycv.database.InfoEntry

data class InfoResponse(
    val result: String,
    @SerializedName("user")
    val InfoEntry: InfoEntry
)