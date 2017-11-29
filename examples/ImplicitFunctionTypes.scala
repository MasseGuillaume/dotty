
case class Request(url: String)
case class Response(body: String, statusCodes: Int)

object Action {
  def apply(body: implicit Request => Response): Action = {
    new Action(body)
  }
}
class Action(body: implicit Request => Response){
  def run(request: Request): Response = {
    body(request)
  }
}

trait Controller {
  def Url(implicit r: Request): String = {
    r.url
  }
  def Ok(content: String): Response = {
    Response(content, 200)
  }
}

object MyController extends Controller {
  def echo = Action { // Automatically inserts `implicit request =>`
    Ok(s"Got request from")
  }
}

object Main {
  def main(arg: Array[String]): Unit = {
  }
}