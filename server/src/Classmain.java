


import java.io.*;
import java.net.*;


public class Classmain {
    public static void main(String args[]) {
        ServerSocket ser = null;
        Socket client = null;
        ObjectInputStream in = null;
        ObjectOutputStream out=null;
        try(
        ObjectOutputStream out_2=new ObjectOutputStream(new FileOutputStream("server\\fileProject\\test_3.txt"))){
            ser = new ServerSocket(2230);
            client = ser.accept();
            in = new ObjectInputStream(client.getInputStream());
            out=new ObjectOutputStream(client.getOutputStream());
            File f=new File ("server\\fileProject");
            System.out.println(f.getName());
            out.writeObject(f);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ser != null) {
                    ser.close();
                }
                ;
                if (client != null) {
                    client.close();
                }
                if (in != null) {
                    in.close();
                }
                if (out!=null){
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
