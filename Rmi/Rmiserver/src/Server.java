import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Server {


    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(5000);
            ChatImplementation imp=new ChatImplementation();
            String url="rmi://localhost:5000/chat";
            Naming.rebind(url,imp);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        System.out.println("i'm server");
    }
}
