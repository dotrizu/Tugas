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
public class Nomor_01_PenjumlahanArray extends Thread{
    static int[] hasil = new int[6];
    int A, B, C, jumlah, threadNumber;

    public Nomor_01_PenjumlahanArray(int num){
        threadNumber = num;
    }
    
    public int[] jumlah(int[] a, int[] b, int[]c){
        for (int i = 0; i < hasil.length; i++) {
            hasil[i] = a[i]+b[i]+c[i];
            System.out.print(hasil[i]+" ");
        }
        return hasil;
    }
    
    public void setIndeks(int a, int b, int c) {
        this.A = a;
        this.B = b;
        this.C = c;
    }
    
    public void tampil(int[] array){
        for(int i=0; i<array.length; i++){
            System.out.print(array[i]+ "  ");
        }
    }
    
    public void run(){
        System.out.print("Thread "+(threadNumber+1)+" : ");
        jumlah = A+B+C;
        System.out.println(A + " + " + B + " + " + C + " = " + jumlah);
            
        try{
            Thread.sleep(500);
        }catch(InterruptedException ex){
            System.out.println(ex);
        }
    }

    public static void main(String[] args) {
        int[] array1 = {6, 9, 1, 2, 3, 5};
        int[] array2 = {7, 11, 6, 4, 3, 1};
        int[] array3 = {5, 4, 3, 2, 1, 12};
        
        Nomor_01_PenjumlahanArray th = null;
        for(int i=0; i<6; i++){
            th = new Nomor_01_PenjumlahanArray(i);
            th.setIndeks(array1[i], array2[i], array3[i]);
            th.start();
        }
                
        System.out.print("Array 1: ");
        th.tampil(array1);
        
        System.out.print("\nArray 2: ");
        th.tampil(array2);
        
        System.out.print("\nArray 3: ");
        th.tampil(array3);
        
        System.out.print("\n---------------------------+\nHasil : ");
        th.jumlah(array1, array2, array3);
        System.out.println("");
        
        int total = 0;
        for(int i=0; i<hasil.length; i++){
            total += hasil[i];
        }
        System.out.println("\nTotal : "+total+"\n");
        
        
    }
}
