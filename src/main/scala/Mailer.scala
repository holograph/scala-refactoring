/**
 * Created by tomerga on 8/23/15.
 */
class Mailer {
  type Body = String

  trait Template[T] { def render(entity: T): Body }

  val userDeletion = new Template[User] { def render(user: User) = s"Deleted: $user" }

  def notify[T](template: Template[T], entity: T): Unit = println(template render entity)

}
