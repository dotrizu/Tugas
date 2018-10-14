/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modul_06.Tugas;

/**
 *
 * @author CHP_SONE
 */
public class Nomor_02_Cerita extends Thread{
    static int pasien;
    String p1 = "1", p2 = "2";

    public void run() {
        for (pasien = 0; pasien < 10; pasien++) {
            System.out.println("Pasien ke " + (pasien + 1) + " di periksa oleh Dokter");
        }
        System.out.println("");

        for (pasien = 0; pasien < 10; pasien++) {
            
            if ((pasien +1) % 2 == 0) {
                System.out.print("Perawat "+p1+" merawat pasien ke "+ (pasien+1));
            }else{
                System.out.print("Perawat "+p2+" merawat pasien ke "+(pasien+1));
                
            }
        
            for (int j = (pasien + 1); j > pasien ; j--) {
                System.out.print(", Pasien " + j + " membayar ke kasir\n");
            }
        }
        
        try{
            Thread.sleep(500);
        }catch(InterruptedException ex){
            System.out.println(ex);
        }
    }

    public static void main(String[] args) {
        System.out.println("@Rumah Sakit\nDokter  1\nPerawat 2\nKasir   1\n-------------------------------------------");
        System.out.println("Datang 10 Pasien untuk memeriksakan diri...\n");
        
        Thread th = new Nomor_02_Cerita();
        th.start();
    }
}
