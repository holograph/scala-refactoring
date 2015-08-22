/**
 * Created by tomerga on 8/23/15.
 */
sealed trait UserStatus
case object New extends UserStatus
case object Deleted extends UserStatus

case class User(name: String, age: Int, status: UserStatus = New)

class UserManager(mailer: Mailer) {
  def delete(user: User) = {
    mailer.notify(mailer.userDeletion, user)
    user.copy(status = Deleted)
  }
}
