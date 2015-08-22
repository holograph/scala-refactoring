/**
 * Created by tomerga on 8/23/15.
 */
class UserManager(mailer: Mailer) {
  def delete(user: User) = {
    mailer.notify(Deletion, user)
    user.copy(status = Deleted)
  }
}
