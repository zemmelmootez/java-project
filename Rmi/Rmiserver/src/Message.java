import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {

    Date date;
    String id_src;
    String id_dest;
    String msg;

    public Message(){

    }
    public Message(Date date, String id_src, String id_dest, String msg) {
        this.date = date;
        this.id_src = id_src;
        this.id_dest = id_dest;
        this.msg = msg;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getId_src() {
        return id_src;
    }

    public void setId_src(String id_src) {
        this.id_src = id_src;
    }

    public String getId_dest() {
        return id_dest;
    }

    public void setId_dest(String id_dest) {
        this.id_dest = id_dest;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Message{" +
                "date=" + date +
                ", id_src='" + id_src + '\'' +
                ", id_dest='" + id_dest + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
