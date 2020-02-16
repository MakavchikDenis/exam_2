
import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class ClassMain {
    public static void main(String args[]){
        Socket soc=null;
        String str_2=new String();
        ObjectOutputStream out=null;
        ObjectInputStream in=null;
        FileOutputStream fin=null;
        File nameFile;

        try {
            soc=new Socket("192.168.100.16",2230);
            out=new ObjectOutputStream(soc.getOutputStream());
            in=new ObjectInputStream(soc.getInputStream());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                if(soc!=null){soc.close();}
                if(out!=null){out.close();}
                if(in!=null){in.close();}
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }

    }
}
