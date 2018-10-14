/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modul_06.Tugas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author CHP_SONE
 */
public class Nomor_04_TCP_MultiClient {
    public static final int SERVICE_PORT = 13;
    
    public static void main(String[] args) throws IOException {
        try{
            String hostname = "localhost";
            Socket daytime = new Socket(hostname, SERVICE_PORT);
            System.out.println("Connection established\n");

            daytime.setSoTimeout(2000);

            BufferedReader br = new BufferedReader(new InputStreamReader(daytime.getInputStream()));
            String data = br.readLine();
            System.out.println(data);
            
            daytime.close();
        }catch(IOException ioe){
            System.out.println("Error "+ioe);
        }
    }
}
