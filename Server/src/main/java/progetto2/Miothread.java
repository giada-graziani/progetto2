package progetto2;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Miothread extends Thread {
    Socket s;
    public Miothread(Socket s){
        this.s=s;
    }

    public void run(){
        try  {
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());

            //client
            String stringaRicevuta;
            do{
                stringaRicevuta= in.readLine();//legge la stringa del socket
                if(stringaRicevuta.equals("!")){
                    s.close();
                    System.out.println("...server terminato");
                }
                else{
                System.out.println("ricevuto: "+stringaRicevuta); //stampa la stringa minuscola

                String stringaMaiuscola= stringaRicevuta.toUpperCase(); //trasforma la stringa maiuscola
                out.writeBytes(stringaMaiuscola + '\n');//invia la stringa dopo averla modificata
                }
            }while(!stringaRicevuta.equals("!"));
        
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
