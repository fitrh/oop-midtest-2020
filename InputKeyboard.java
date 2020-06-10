import java.io.*;
import java.nio.*;
public class InputKeyboard{

   protected String input;
   public  int karakter;
   
public static String inputString(){
    int karakter;
    String str ="";
    boolean selesai = false;
    while(!selesai){
        try{
            karakter = System.in.read();
            if(karakter < 0 || (char) karakter == '\n') selesai = true;
            else if ((char) karakter != '\r') str = str + (char) karakter;
        }catch(java.io.IOException e){
            System.err.println("Ada kesalahan");
            selesai = true;
        }
    }
    return str;
}
}