import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatRemote  extends Remote {


    void AddMsg(Message s) throws RemoteException;
    String getAll() throws  RemoteException;
    String getAll(String id) throws  RemoteException;
}
