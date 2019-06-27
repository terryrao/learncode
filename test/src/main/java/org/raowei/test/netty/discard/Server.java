package org.raowei.test.netty.discard;

/**
 * @author raowei
 * @date 2019-06-26
 */
public class Server {

    public static void main(String[] args) {
        DiscardServer server;
        if (args.length > 0) {
            server = new DiscardServer(Integer.parseInt(args[0]));
        }else {
            server = new DiscardServer();
        }

        server.run();
    }
}
