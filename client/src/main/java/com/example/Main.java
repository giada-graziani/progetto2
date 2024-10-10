package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("client partito...");
        Scanner scanner = new Scanner(System.in);
        Socket so= new Socket("localhost", 3000);
        BufferedReader in = new BufferedReader(new InputStreamReader(so.getInputStream()));
        DataOutputStream out = new DataOutputStream(so.getOutputStream());
    
        String stringaDaInviare;
        do{
            System.out.println("Scrivi la parola:");
            stringaDaInviare = scanner.nextLine(); 
        out.writeBytes(stringaDaInviare+ '\n'); //invia la stringa
        
        //server
        

        String stringaRicevuta = in.readLine(); //legge la stringa del server
        System.out.println("stringa ricevuta: " + stringaRicevuta); //stampa la stringa del server
        }while(!stringaDaInviare.equals("!"));

        System.out.println("...client terminato");
    }
}