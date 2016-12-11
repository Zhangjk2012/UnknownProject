import akka.actor.{Actor, ActorIdentity, ActorRef, ActorSystem, Identify, Props, ReceiveTimeout, Terminated}
import com.typesafe.config.ConfigFactory
import scala.concurrent.duration._

/**
  * Created by zjk on 11/12/16.
  */
object RemoteTest {
  def main(args: Array[String]) {

    val localConf = ConfigFactory.load("local.conf")
    val localSystem = ActorSystem("LocalTest", localConf)
    val local = localSystem.actorOf(Props[Local], "local")
    println(local.path)


    val remoteConf = ConfigFactory.load("remote.conf")
    val remoteSystem = ActorSystem("RemoteTest",remoteConf)
    val remote = remoteSystem.actorOf(Props[Remote], "remote")
    println(remote.path)
    Thread.sleep(4000)
    remoteSystem.stop(remote)
    //localSystem.terminate()
    //remoteSystem.terminate()
  }
}

class Local extends Actor {

  val path = "akka.tcp://RemoteTest@127.0.0.1:2553/user/remote";
  sendIdentifyRequest
  def sendIdentifyRequest = {
    context.actorSelection(path) ! Identify(path)
    //import context.dispatcher
    //context.system.scheduler.scheduleOnce(3.seconds, self, ReceiveTimeout)
  }

  override def receive: Receive = {
    case ActorIdentity(`path`, Some(actor)) => {
      actor ! "Got the actor!"
      context.watch(actor)
      context.become(receiveMsg(actor),false)
    }
    case ActorIdentity(`path`, None) => println(s"Remote actor not available: $path")
    case x:Any => println(x)
  }

  def receiveMsg(actor: ActorRef) : Receive = {
    case Terminated(`actor`) =>
      println("The remote actor terminated")
      //context.stop(self)
      context.unbecome()
      sendIdentifyRequest
  }

}

class Remote extends Actor {


  @scala.throws[Exception](classOf[Exception])
  override def preStart(): Unit = {
    println("================================================")
  }

  override def receive: Receive = {
    case str: String => println("=================" + str)
    case _ => println("111111111111111111111")
  }
}

