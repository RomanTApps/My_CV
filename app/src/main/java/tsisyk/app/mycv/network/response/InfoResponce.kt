package tsisyk.app.mycv.network.response


import com.google.gson.annotations.SerializedName

data class InfoResponce(
    var email: String,
    var github: String,
    var image: String,
    var linkedIn: String,
    var name: String,
    var position: String,
    var summary: String,
    var webpage: String
)