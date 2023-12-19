package workwork.test.chatwebsockets.data.model

data class SendStatus(
    val message:String,
    val token:String,
    val status:Boolean,
    val codeAnswer:Int
)
