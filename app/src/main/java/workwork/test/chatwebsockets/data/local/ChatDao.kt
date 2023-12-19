package workwork.test.chatwebsockets.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ChatDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMyInfo(chatPersonEntity: MyInfoEntity)

    @Query("SELECT *FROM MyInfoEntity")
    suspend fun getMyInfo():MyInfoEntity

    @Delete
    suspend fun deleteMyInfo(chatPersonEntity: MyInfoEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertChatPerson(chatPersonEntity: ChatPersonEntity)

    @Query("SELECT *FROM ChatPersonEntity")
    fun getMyChats():Flow<List<ChatPersonEntity>>

    @Delete
    suspend fun deleteChat(chatPersonEntity: ChatPersonEntity)

}