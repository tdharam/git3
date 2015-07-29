package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;
//http://docs.oracle.com/javase/6/docs/technotes/guides/rmi/hello/hello-world.html
//http://docs.oracle.com/javase/6/docs/technotes/guides/rmi/index.html
public interface Hello extends Remote {
    String sayHello() throws RemoteException;
}