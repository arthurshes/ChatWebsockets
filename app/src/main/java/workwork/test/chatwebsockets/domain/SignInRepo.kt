package workwork.test.chatwebsockets.domain

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query
import workwork.test.chatwebsockets.data.ApiService
import workwork.test.chatwebsockets.data.local.ChatPersonEntity
import workwork.test.chatwebsockets.data.local.MainDb
import workwork.test.chatwebsockets.data.local.MyInfoEntity
import workwork.test.chatwebsockets.data.model.ContactPersonModel
import workwork.test.chatwebsockets.data.model.CreateUserModel
import workwork.test.chatwebsockets.data.model.SendStatus
import javax.inject.Inject

interface SignInRepo  {


    suspend fun insertMyInfo(chatPersonEntity: MyInfoEntity)


    suspend fun getMyInfo(): MyInfoEntity


    suspend fun deleteMyInfo(chatPersonEntity: MyInfoEntity)


    suspend fun insertChatPerson(chatPersonEntity: ChatPersonEntity)


    fun getMyChats(): Flow<List<ChatPersonEntity>>


    suspend fun deleteChat(chatPersonEntity: ChatPersonEntity)

    suspend fun getMyContacts(numberContact:String): ContactPersonModel


    suspend fun createAccount( createUserModel: CreateUserModel): SendStatus
}