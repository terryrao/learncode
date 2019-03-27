package highconcurrentdesign.chapter07;

import akka.actor.*;
import com.typesafe.config.ConfigFactory;

/**
 * @author raowei
 * @date 2019-03-27
 */
public class WatchActor extends UntypedAbstractActor {

    public WatchActor(ActorRef actorRef) {
        getContext().watch(actorRef);
    }

    @Override
    public void onReceive(Object message) throws Throwable {
        if (message instanceof Terminated) {
            System.out.println(String.format("%s has terminated ",((Terminated ) message).getActor().path()));
            getContext().system().terminate();
        }else {
            unhandled(message);
        }
    }


    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("deadWatch", ConfigFactory.load());
        ActorRef work = system.actorOf(Props.create(MyWorker.class),"MyWork");
        ActorRef wacther = system.actorOf(Props.create(WatchActor.class, work),"Watchor");
        work.tell(MyWorker.Msg.WORKING,ActorRef.noSender());
        work.tell(MyWorker.Msg.DONE,ActorRef.noSender());
        work.tell(PoisonPill.getInstance(),ActorRef.noSender());

    }
}
