/**
 * Created by tomerga on 8/23/15.
 */
sealed trait UserStatus
case object New extends UserStatus
case object Deleted extends UserStatus

case class User(name: String, age: Int, status: UserStatus = New)

case object User {
  implicit val userDeletionTemplate =
    new Mailer.Template[Deletion.type, User] {
      def render(user: User): Mailer.Body = s"Deleted: $user"
    }
}
