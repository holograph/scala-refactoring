/**
 * Created by tomerga on 8/23/15.
 */
object ScopingShowcase extends App {
  val user = new User("Jeffrey Lebowski", 47)
  val manager = new UserManager(new Mailer)
  manager.delete(user)
}
