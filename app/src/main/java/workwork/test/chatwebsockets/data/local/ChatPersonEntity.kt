package workwork.test.chatwebsockets.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("ChatPersonEntity")
data class ChatPersonEntity(
    @PrimaryKey(autoGenerate = true)
    var id:Int?=null,
    val name:String,
    val numberPhone:String,
    val token:String
)
