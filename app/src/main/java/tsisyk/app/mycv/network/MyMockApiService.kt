package tsisyk.app.mycv.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import tsisyk.app.mycv.network.response.InfoResponse
import tsisyk.app.mycv.network.response.WorkExperienceResponse

interface MyMockApiService {

    @GET("info.json")
    fun getInfo(): Deferred<InfoResponse>


    @GET("work.json")
    fun getWorkExperience(): Deferred<WorkExperienceResponse>

    companion object{
        operator fun invoke( connectivityInterceptor: ConnectivityInterceptor): MyMockApiService{

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(connectivityInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://server452015.nazwa.pl/test_cv_app/")
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyMockApiService::class.java)
        }
    }
}