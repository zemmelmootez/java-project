import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Date;

public class Client {

    public static void main(String[] args) {

        try {
            ChatRemote cr= (ChatRemote) Naming.lookup("rmi://brave-carpets-punch-34-125-101-243.loca.lt:1099/chat");

            System.out.println(cr.getAll());
            cr.AddMsg(new Message(new Date(),"c1","c2","bonjour"));
            System.out.println(cr.getAll("c2"));

         } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }
}
