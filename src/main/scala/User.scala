/**
 * Created by tomerga on 8/23/15.
 */
sealed trait UserStatus
case object New extends UserStatus
case object Deleted extends UserStatus

class User(var name: String,
           var age: Int,
           initialStatus: UserStatus = New) {

  private var _status = initialStatus
  def status = _status

  def delete(): Unit = {
    _status = Deleted
    Mailer.notify(Mailer.userDeletion, this)
  }

  override def toString = s"User($name, $age, $status)"
}
