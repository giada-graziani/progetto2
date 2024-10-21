package progetto2;

import java.io.BufferedReader;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("server partito...");
        ServerSocket s1= new ServerSocket(3000);

        do{
            Socket s= s1.accept();
            Miothread t= new Miothread(s);
            t.start();
        }while(true);


    }
}