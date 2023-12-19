package workwork.test.chatwebsockets.data

import kotlinx.coroutines.flow.Flow
import workwork.test.chatwebsockets.data.local.ChatPersonEntity
import workwork.test.chatwebsockets.data.local.MainDb
import workwork.test.chatwebsockets.data.local.MyInfoEntity
import workwork.test.chatwebsockets.data.model.ContactPersonModel
import workwork.test.chatwebsockets.data.model.CreateUserModel
import workwork.test.chatwebsockets.data.model.SendStatus
import workwork.test.chatwebsockets.domain.SignInRepo
import javax.inject.Inject

class SingInRepoImpl @Inject constructor(private val apiService: ApiService,private val mainDb: MainDb):SignInRepo {

    private val dao = mainDb.getChatDao()
    override suspend fun insertMyInfo(chatPersonEntity: MyInfoEntity) {
        dao.insertMyInfo(chatPersonEntity)
    }

    override suspend fun getMyInfo(): MyInfoEntity {
        return dao.getMyInfo()
    }

    override suspend fun deleteMyInfo(chatPersonEntity: MyInfoEntity) {
       return dao.deleteMyInfo(chatPersonEntity)
    }

    override suspend fun insertChatPerson(chatPersonEntity: ChatPersonEntity) {
        dao.insertChatPerson(chatPersonEntity = chatPersonEntity)
    }

    override fun getMyChats(): Flow<List<ChatPersonEntity>> {
      return dao.getMyChats()
    }

    override suspend fun deleteChat(chatPersonEntity: ChatPersonEntity) {
        dao.deleteChat(chatPersonEntity)
    }

    override suspend fun getMyContacts(numberContact: String): ContactPersonModel {
       return apiService.getMyContacts(numberContact)
    }

    override suspend fun createAccount(createUserModel: CreateUserModel): SendStatus {
       return apiService.createAccount(createUserModel)
    }
}