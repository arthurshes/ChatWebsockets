package workwork.test.chatwebsockets.data

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import workwork.test.chatwebsockets.data.model.ContactPersonModel
import workwork.test.chatwebsockets.data.model.CreateUserModel
import workwork.test.chatwebsockets.data.model.SendStatus

interface ApiService {

    @GET("checkContacts/get")
    suspend fun getMyContacts(@Query("checkNumber")numberContact:String):ContactPersonModel

    @POST("signIn/createAccount")
    suspend fun createAccount(@Body createUserModel: CreateUserModel): SendStatus

}