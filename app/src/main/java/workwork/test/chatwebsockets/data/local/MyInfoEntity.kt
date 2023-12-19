package workwork.test.chatwebsockets.data.local

import androidx.room.Entity

@Entity("MyInfoEntity")
data class MyInfoEntity(
    val name:String,
    val numberPhone:String,
    val token:String
)
