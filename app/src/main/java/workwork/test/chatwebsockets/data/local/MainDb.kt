package workwork.test.chatwebsockets.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ChatPersonEntity::class,MyInfoEntity::class], version = 1)
abstract class MainDb:RoomDatabase() {

    abstract fun getChatDao():ChatDao

}