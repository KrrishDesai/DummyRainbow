package p1;

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConcurrentServerLogging 
{
    static ArrayList<PrintWriter> al=new ArrayList<PrintWriter>();
    static PrintWriter pwLog;
    
    static
    {
        try 
        {
            pwLog=new PrintWriter(
                    new BufferedWriter(
                            new FileWriter("C:\\Users\\KRISHNAJI\\Desktop\\Log.txt",true)
                    ),true
            );    
        } 
        catch (IOException ex) 
        {
            System.out.println(ex);
        }
    }
    
    public static void main(String[] args) throws IOException  
    {
        ServerSocket ss=new ServerSocket(9081);
        System.out.println("Server Signing On");
        
        for (int i = 0; i < 10; i++) 
        {
            Socket soc=ss.accept();
            Conversation c=new Conversation(soc);
            c.start();
        }
        
        System.out.println("Server Signing Off");
    }

}

class Conversation extends Thread
{
    Socket soc;

    public Conversation(Socket soc) 
    {
        this.soc = soc;
    }
    
    public void run()
    {
        System.out.println("Conversation Thread"
                    + Thread.currentThread().getName()
                    + "Signing On");
        
        try 
        {
            
          BufferedReader  nis = new BufferedReader(
                    new InputStreamReader(
                            soc.getInputStream()
                    )
            );
          
            PrintWriter nos = new PrintWriter(
                    new BufferedWriter(new OutputStreamWriter(
                            soc.getOutputStream()
                    )
                    ), true);
            ConcurrentServerLogging.al.add(nos);
            
            String TimeStamp = new SimpleDateFormat(
                                        "MM/dd/yyyy HH:mm:ss"
                                   ).format(new Date());
            
            String userName=nis.readLine();
            String s=nis.readLine();
            
            while(!s.equalsIgnoreCase("end"))
            {
                for (PrintWriter o : ConcurrentServerLogging.al)
                {
                    o.println(TimeStamp + " " + userName + ": " + s );
                }
                ConcurrentServerLogging.pwLog.println(TimeStamp + " " + userName + ": " + s );
                s=nis.readLine();
            }
            nos.println(s);
        } 
        catch (IOException ex) 
        {
            System.out.println(ex);
        } 
        
        System.out.println("Conversation Thread"
                    + Thread.currentThread().getName()
                    + "Signing Off");
    } 
}
    