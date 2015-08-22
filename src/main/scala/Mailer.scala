/**
 * Created by tomerga on 8/23/15.
 */
sealed trait Notification
case object Creation extends Notification
case object Deletion extends Notification
case object Update extends Notification

object Mailer {
  type Body = String

  trait Template[N <: Notification, T] {
    def render(entity: T): Mailer.Body
  }
}

import Mailer._
class Mailer {
  def notify[N <: Notification, T](notification: N, entity: T)
                                  (implicit template: Template[N, T]): Unit =
    println(template render entity)
}
