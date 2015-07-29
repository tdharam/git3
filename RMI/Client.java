package RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

    private Client() {}

    public static void main(String[] args) {

        String host = (args.length < 1) ? null : args[0];
        try {
            Registry registry = LocateRegistry.getRegistry(host);
            Hello stub = (Hello) registry.lookup("Hello");
            String response = stub.sayHello();
/*            Finally, the client invokes the sayHello method on the remote object's stub, which causes the following actions to happen:

            The client-side runtime opens a connection to the server using the host and port information in the remote object's stub and then serializes the call data.
            The server-side runtime accepts the incoming call, dispatches the call to the remote object, and serializes the result (the reply string "Hello, world!") to the client.
            The client-side runtime receives, deserializes, and returns the result to the caller.*/
            System.out.println("response: " + response);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
} 
