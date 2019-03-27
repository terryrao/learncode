package highconcurrentdesign.chapter07;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedAbstractActor;
import com.typesafe.config.ConfigFactory;

/**
 * @author raowei
 * @date 2019-03-27
 */
public class HellOActor extends UntypedAbstractActor {
    ActorRef actorRef;
    @Override
    public void onReceive(Object message) throws Throwable {
        if (Greeter.Msg.DONE == message) {
            actorRef.tell(Greeter.Msg.GREET,getSelf());
            this.getContext().stop(getSelf());
        }else {
            unhandled(message);
        }
    }

    @Override
    public void preStart() throws Exception {
        actorRef = this.getContext().actorOf(Props.create(Greeter.class),"greeter");
        System.out.println("create greet actor Path:" + actorRef.path());
        actorRef.tell(Greeter.Msg.GREET,getSelf());
    }

    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("hello", ConfigFactory.load("sampleh"));
        ActorRef hello = system.actorOf(Props.create(HellOActor.class), "hello");
        System.out.println("create hello actor Path : " + hello.path());

    }
}
