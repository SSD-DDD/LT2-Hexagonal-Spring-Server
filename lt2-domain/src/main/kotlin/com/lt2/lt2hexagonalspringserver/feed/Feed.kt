package feed

import annotation.Aggregate
import java.util.UUID

@Aggregate
class Feed(

    val id: UUID,

    val title: String,

    val content: String,

    val userId: UUID
)