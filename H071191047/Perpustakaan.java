import java.util.Scanner;
public class Perpustakaan {
    String nama, buku, penerbit;
    static String penulis;
    static String jumlahhalaman;

    public Perpustakaan(String nama, String buku, String penerbit) {
        this.nama = nama;
        this.buku = buku;
        this.penerbit = penerbit;
        this.penulis = penulis;
        this.jumlahhalaman = jumlahhalaman;

    }

    public void tampil() {
        System.out.println("Nama Peminjam : " + this.nama);
        System.out.println("Nama Buku     : " + this.buku);
        System.out.println("Penerbit Buku : " + this.penerbit);
        System.out.println("Penulis       : " + this.penulis);
        System.out.println("jumlah Halaman: " + this.jumlahhalaman);
    }

    public static void main(String[] args) {
        String nama, buku, penerbit;
        int a, z = 0, menu = 0;
        Perpustakaan[] perpus = new Perpustakaan[1024];
        Scanner getstr = new Scanner(System.in);
        Scanner getint = new Scanner(System.in);
        while (menu != 3) {
            System.out.print("Menu...\n1.Input\n2.Output\n3.Exit\nPilihan : ");
            menu = getint.nextInt();
            if (menu == 1) {
                z++;
                System.out.println("Masukkan data...");
                System.out.print("Nama Peminjam : ");
                nama = getstr.nextLine();
                System.out.print("Nama Buku     : ");
                buku = getstr.nextLine();
                System.out.print("Penerbit Buku : ");
                penerbit = getstr.nextLine();
                System.out.println("Penulis     :");
                penulis = getstr.nextLine();
                System.out.println("Jumlah Halaman: ");
                jumlahhalaman = getstr.nextLine();
                System.out.println();
                perpus[z]=new Perpustakaan(nama,buku,penerbit);
            }
            else if(menu==2){
                if(z<1){
                    System.out.println("Data Masih Kosong...");
                }
                else{
                    a=0;
                    while(a<z){
                        a++;
                        System.out.println("---"+a+"---");
                        perpus[a].tampil();
                    }
                }
            }
            else if(menu==3){
                System.out.println("Keluar...");
            }
            else{
                System.out.println("Masukkan Menu Yang Tersedia...");
            }
        }
    }
}