package workwork.test.chatwebsockets.domain

import android.annotation.SuppressLint
import android.content.Context
import android.provider.ContactsContract
import workwork.test.chatwebsockets.data.local.ChatPersonEntity
import workwork.test.chatwebsockets.data.local.MyInfoEntity
import workwork.test.chatwebsockets.data.model.CreateUserModel
import javax.inject.Inject

class SignInUseCase @Inject constructor(private val signInRepo: SignInRepo) {

    @SuppressLint("Range")
    suspend fun getMyContacts(context: Context){
        val contacts = context.contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null)
        while (contacts?.moveToNext() == true){
            val number = contacts.getString(contacts.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
             val response = signInRepo.getMyContacts(number)
            if(response.codeAnswer!=709){
                val chatPersonEntity = ChatPersonEntity(
                    name = response.name,
                    numberPhone = response.numberPhone,
                    token = response.token
                )
                signInRepo.insertChatPerson(chatPersonEntity)
            }
        }
    }

    suspend fun signIn(number:String,name:String){
        val createUserModel = CreateUserModel(numberPhone = number, name = name)
        val response = signInRepo.createAccount(createUserModel)
        if(response.codeAnswer==202){
            val myInfoEntity = MyInfoEntity(
                token = response.token,
                name = name,
                numberPhone = number
            )
        }
    }


}