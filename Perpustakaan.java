public class Perpustakaan{

    public static void main(String args[]){
    String input;
    int JumlahBayar, denda, biaya;
    
    
    //aturan pinjam

    System.out.println("Program Perpustakaan Normal ");
    System.out.println("------------------------------");
    System.out.println("Kategori Buku dan Pengarang: ");
    System.out.println("1. Kamus, Al Munawir");
    System.out.println("2. Majalah,Uknown");
    System.out.println("3. TextBook, People");
    System.out.println("Pilih Kategori ----> [1/2/3] ");
    System.out.println("------------------------------");
    System.out.println("Aturan Peminjaman Buku ");
    System.out.println("Peminjaman maksimal 1 Minggu [7 hari] ");
    System.out.println("Denda sebanyak Rp.500,00 per hari untuk setiap koleksi");
    System.out.println("------------------------------");
    //input nama, no anggota, dan kategori buku
    
    System.out.print("Nama Anggota :");
    input = InputKeyboard.inputString();
    System.out.print("Nomor Anggota :");
    input = InputKeyboard.inputString();
    System.out.print("Pilih Kategori Buku :");
    input = InputKeyboard.inputString();
    
    //pilihan koleksi buku berdasarkan kategori
    int kategori = Integer.valueOf(input).intValue();
    
    
    if (kategori==1){
    System.out.println("Kategori Kamus : ");
    System.out.println("1. Kamus Bahasa Inggris ");
    System.out.println("2. Kamus Bahasa Jepang ");
    System.out.println("3. Kamus Bahasa Indonesia ");
    System.out.println("4. Kamus Bahasa Lontara");
    System.out.println("5. Kamus Bahasa Korea");
    } else if (kategori==2){
    System.out.println("Kategori Majalah : ");
    System.out.println("1. Chip ");
    System.out.println("2. Info komputer ");
    System.out.println("3. Intisari ");
    System.out.println("4. Tempo");
    System.out.println("5. Laras");
    } else {
    System.out.println("Kategori Textbook: ");
    System.out.println("1. Pemrograman Java GUI ");
    System.out.println("2. Tutorial Netbeans  ");
    System.out.println("3. Game 3D Menggunakan Flash ");
    System.out.println("4. Bisnis lewat Internet ");
    System.out.println("5. Pengantar Statistika");
    System.out.println("6. Pemograman Berbasis Objek Menggunakan Java");
    }
    //memasukkan pilihan koleksi yang akan dipinjam
    System.out.print("Koleksi yang Anda Pilih ? : ");
    input = InputKeyboard.inputString();
    System.out.println("Koleksi Yang Anda ingin pinjam adalah : "+input+"");
    System.out.println("");
    
    //memasukkan data lama pinjam
    System.out.print("Lama Pinjam (Jumlah Hari) : ");
    input = InputKeyboard.inputString();
    System.out.println("");
    
    //penghitungan biaya sewa dan denda
    int LamaPinjam = Integer.valueOf(input).intValue();
    if(LamaPinjam > 7) {
        if (kategori==1) {
             biaya = 2000;
            }else if (kategori==2){
                biaya = 3000;
             }else {
                 biaya = 1000;
                }denda = (LamaPinjam-7) * 500;
             }else{
                 if (kategori==1){
                      biaya = 2000;
                     }else if (kategori==2){
                         biaya = 3000;
                        }else{
                            biaya = 1000;
                        }denda =0;
                    }
    //menampilkan biaya sewa dan denda
    System.out.println("Biaya yang harus Anda Bayar : Rp. "+biaya);
    System.out.println("Denda : Rp. "+denda);
    JumlahBayar = biaya + denda;
    System.out.println("");
    System.out.println("Total Biaya yang harus dibayar : Rp. "+JumlahBayar);
    System.out.println("");
    }
}