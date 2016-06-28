import akka.actor.{Actor, ActorSystem, Props}
import akka.dispatch.Envelope
import akka.event.Logging
import akka.routing.RoundRobinPool

/**
  * Created by Administrator on 2016/6/28.
  */
object MyActor {

  def main(args: Array[String]) {

    val system = ActorSystem("Zhang")
    val router2 = system.actorOf(RoundRobinPool(5).props(Props[MyActor]),"router2")


    router2 ! "test"
    router2 ! "test"
    router2 ! "test"
    router2 ! "test"
    router2 ! "test"

  }

}


class MyActor extends Actor{
  val log = Logging(context.system, this)
  Envelope
  def receive = {
    case "test" => {
      log.info("received test")
      println(self.path.name)
    }
    case _ => log.info("received unknown message")
  }
}