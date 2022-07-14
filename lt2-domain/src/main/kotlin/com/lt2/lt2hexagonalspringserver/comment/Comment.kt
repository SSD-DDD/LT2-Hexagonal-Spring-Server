package comment

import annotation.Aggregate
import java.util.UUID

@Aggregate
class Comment(

    val id: UUID,

    val userId: UUID,

    val feedId: UUID
)