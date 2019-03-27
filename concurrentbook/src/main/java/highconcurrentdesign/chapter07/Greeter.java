package highconcurrentdesign.chapter07;

import akka.actor.UntypedAbstractActor;

/**
 * @author raowei
 * @date 2019-03-27
 */
public class Greeter extends UntypedAbstractActor {
    @Override
    public void onReceive(Object message) throws Throwable {
        if (message == Msg.GREET) {
            System.out.println("Hello World");
            this.getSender().tell(Msg.DONE,this.getSelf());
        } else {
            this.unhandled(message);
        }

    }
    public  enum Msg{
        GREET,DONE
    }
}
