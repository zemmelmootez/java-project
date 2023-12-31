import java.io.FileInputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ChatImplementation extends UnicastRemoteObject implements ChatRemote {

    ArrayList<Message>chat=new ArrayList<Message>();

    protected ChatImplementation() throws RemoteException {
    }


    @Override
    public void AddMsg(Message s) throws RemoteException {
        chat.add(s);
    }

    @Override
    public String getAll() throws RemoteException {

       String  msg="";
        for(int i=0;i<chat.size();i++)
        {

            if (chat.get(i).id_dest.isEmpty()){
                msg+=chat.get(i).msg+"\n";

            }
        }
        return  msg;


    }

    public String getAll(String id){
        String  msg="";
        for(int i=0;i<chat.size();i++)
        {

            if (chat.get(i).id_dest.equals(id)){
                msg+=chat.get(i).toString();

            }
        }
        return  msg;
    }
}
