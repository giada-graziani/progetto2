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
        Socket s= s1.accept();

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());

        //client
        String stringaRicevuta;
        do{
            stringaRicevuta= in.readLine();//legge la stringa del socket
            if(stringaRicevuta.equals("!")){
                s.close();
                s1.close();
                System.out.println("...server terminato");
            }
            else{
            System.out.println("ricevuto: "+stringaRicevuta); //stampa la stringa minuscola

            String stringaMaiuscola= stringaRicevuta.toUpperCase(); //trasforma la stringa maiuscola
            out.writeBytes(stringaMaiuscola + '\n');//invia la stringa dopo averla modificata
            }
        }while(!stringaRicevuta.equals("!"));

        s.close();
        s1.close();
        System.out.println("...server terminato");
    }
}