/**
 * Created by tomerga on 8/23/15.
 */
object ScopingShowcase extends App {

  object Mailer {
    type Body = String

    trait Template[T] { def render(entity: T): Body }

    val userDeletion = new Template[User] { def render(user: User) = s"Deleted: $user" }

    def notify[T](template: Template[T], entity: T): Unit = println(template render entity)
  }

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


  val user = new User("Jeffrey Lebowski", 47)
  user.delete()
}
