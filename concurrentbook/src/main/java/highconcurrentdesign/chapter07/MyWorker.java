package highconcurrentdesign.chapter07;

import akka.actor.UntypedAbstractActor;

/**
 * @author raowei
 * @date 2019-03-27
 */
public class MyWorker extends UntypedAbstractActor {
    public enum Msg{
        WORKING,DONE,CLOSED
    }

    @Override
    public void preStart() throws Exception {
        System.out.println("MyWorking is starting");
    }

    @Override
    public void postStop() throws Exception {
        System.out.println("MyWorking is stopping");
    }

    @Override
    public void onReceive(Object message) throws Throwable {
        if (Msg.WORKING == message) {
            System.out.println("I'm working");
        }else if (message == Msg.DONE) {
            System.out.println("Stop working");
        }else if (message == Msg.CLOSED) {
            System.out.println("I'll stop");
            getSender().tell(Msg.CLOSED,getSelf());
            getContext().stop(getSelf());
        }else {
            unhandled(message);
        }
    }
}
