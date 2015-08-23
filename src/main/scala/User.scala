/**
 * Created by tomerga on 8/23/15.
 */
sealed trait UserStatus
case object New extends UserStatus
case object Deleted extends UserStatus

case class User(name: String, age: Int, status: UserStatus = New)

class UserManager(mailer: Mailer) {

  object Templates {
    val deletion = new mailer.Template[User] { def render(user: User) = s"Deleted: $user" }
  }

  def delete(user: User) = {
    mailer.notify(Templates.deletion, user)
    user.copy(status = Deleted)
  }
}
