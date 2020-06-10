import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.*;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner alk = new Scanner(System.in);
        // untuk menentukan apa nama file Menu yang nantinya akan di pangggil
        File filebf = new File("Menu.txt");

        System.out.println("==========================================================");
        System.out.println("\t\t\tBURGER STORE");
        System.out.println("==========================================================");
        System.out.println("\t\t\t    MENU");
        System.out.println("==========================================================");

        // untuk menampilkan menu pada Burger Store yang ada pada file Menu.txt
        try (BufferedReader br = new BufferedReader(new FileReader(filebf))) {
            String barisData;

            while ((barisData = br.readLine()) != null) {
                System.out.println(barisData);
            }
        } catch (FileNotFoundException ex1) {
            // untuk mengatasi error
            System.out.println("File tidak ditemukan" + filebf.toString());
        } catch (Exception ex2) {
            // untuk mengatasi error
            System.out.println("File tidak dapat dibaca " + filebf.toString());
        }
        System.out.println("==========================================================");

        // untuk membuat file txt yang berfungsi untuk pengeprint-an semua pesanan yang dipilih
        System.out.print("Input Nama Anda:");
        String nameFile = alk.next() + ".txt";
        File fileb = new File(nameFile);

        double harga = 0;
        int item = 0;
        double money = 0;

        FileWriter file = null;
        PrintWriter writer = null;

        try {
            file = new FileWriter(nameFile);
            writer = new PrintWriter(file);

            System.out.print("Input Banyak Pesanan: ");
            int jumlah = alk.nextInt();

            writer.println("____________________________________________________________");
            writer.println(" Pesanan\t\t\tHarga\t\tTotal");
            writer.println("____________________________________________________________");
            System.out.print("Input Nomor Pesanan Anda(spasi)piece :\n");

            // untuk mengulang penginputan pesanan sebanyak yang diinginkan
            for (int i = 1; i <= jumlah; i++) {
                int bg = alk.nextInt();int pc = alk.nextInt();
                // untuk memberikan format bebrbentuk tabel pada saat memprint dan memanggil isi dari Namafile.txt
                String tbl = "%s\tx%d\t\tRp %.3f\tRp %.3f\n";
                String tbll = "%s\t\tx%d\t\tRp %.3f\tRp %.3f\t\n";

                // untuk memprint nama, harga, piece, serta sum yang isinya harga*piece ke Namafile.txt
                switch (bg) {
                    case 1:
                        Burger cm = new ChickenMuffin(pc);
                        harga += cm.getSum();
                        writer.printf(tbl, cm.getName(), pc, cm.getPrice(), cm.getSum());
                        break;
                    case 2:
                        Burger bb = new BeefBurger(pc);
                        harga += bb.getSum();
                        writer.printf(tbl, bb.getName(), pc, bb.getPrice(), bb.getSum());
                        break;
                    case 3:
                        Burger tb = new TripleBurger(pc);
                        harga += tb.getSum();
                        writer.printf(tbl, tb.getName(), pc, tb.getPrice(), tb.getSum());
                        break;
                    case 4:
                        Burger bm = new BigMac(pc);
                        harga += bm.getSum();
                        writer.printf("%s\t\tx%d\t\tRp %.3f\tRp %.3f\n", bm.getName(), pc, bm.getPrice(), bm.getSum());
                        break;
                    case 5:
                        Burger cb = new CheeseBurger(pc);
                        harga += cb.getSum();
                        writer.printf(tbl, cb.getName(), pc, cb.getPrice(), cb.getSum());
                        break;
                    case 6:
                        Burger ckb = new ChickenBurger(pc);
                        harga += ckb.getSum();
                        writer.printf(tbl, ckb.getName(), pc, ckb.getPrice(), ckb.getSum());
                        break;
                    case 7:
                        Addition c = new Cola(pc);
                        harga += c.getSum();
                        writer.printf(tbll, c.getName(), pc, c.getPrice(), c.getSum());
                        break;
                    case 8:
                        Addition s = new Sprite(pc);
                        harga += s.getSum();
                        writer.printf(tbll, s.getName(), pc, s.getPrice(), s.getSum());
                        break;
                    case 9:
                        Addition f = new Fanta(pc);
                        harga += f.getSum();
                        writer.printf(tbll, f.getName(), pc, f.getPrice(), f.getSum());
                        break;
                    case 10:
                        Addition p = new Potato(pc);
                        harga += p.getSum();
                        writer.printf(tbll, p.getName(), pc, p.getPrice(), p.getSum());
                        break;
                    case 11:
                        Addition t = new Tomato(pc);
                        harga += t.getSum();
                        writer.printf("%s\t\tx%d\t\tRp %.0f.\t\tRp %.0f.\n", t.getName(), pc, t.getPrice(), t.getSum());
                        break;
                    case 12:
                        Addition k = new Ketchup(pc);
                        harga += k.getSum();
                        writer.printf("%s\t\tx%d\t\tRp %.0f.\t\tRp %.0f.\n", k.getName(), pc, k.getPrice(), k.getSum());
                        break;
                    case 13:
                        Addition am = new AirMineral(pc);
                        harga += am.getSum();
                        writer.printf(tbl, am.getName(), pc, am.getPrice(), am.getSum());
                        break;
                    case 14:
                        Addition il = new IcedLemon(pc);
                        harga += il.getSum();
                        writer.printf(tbl, il.getName(), pc, il.getPrice(), il.getSum());
                        break;
                    case 15:
                        Addition oj = new OrangeJuice(pc);
                        harga += oj.getSum();
                        writer.printf(tbl, oj.getName(), pc, oj.getPrice(), oj.getSum());
                        break;
                    case 16:
                        Addition sc = new SundaeChocolate(pc);
                        harga += sc.getSum();
                        writer.printf("%s x%d\t\tRp %.3f\tRp %.3f\t\n", sc.getName(), pc, sc.getPrice(), sc.getSum());
                        break;
                    case 17:
                        Addition sb = new SundaeStrawberry(pc);
                        harga += sb.getSum();
                        writer.printf("%s x%d\t\tRp %.3f\tRp %.3f\t\n", sb.getName(), pc, sb.getPrice(), sb.getSum());
                        break;
                    default:
                        System.out.println("Pilihan anda tidak tersedia pada menu");
                        jumlah += 1;
                        pc -= pc;
                        break;
                }
                // untuk menghitung banyaknya item yang dipesan
                item += pc;
            }
            writer.printf("____________________________________________________________\n");

            // untuk menginput uang dari pelanggan
            System.out.print("Uang tunai: ");
            money = alk.nextInt();

            // untuk menampilkan keterangan kesalahan apabila pelanggan memberi uang yang kurang dari gran total pesanan
            // kemudian pelanggan akan diminta memasukkan uang kembali
            while (money < harga){
                System.out.println("Uang anda tidak cukup");
                System.out.print("Uang tunai: ");
                money = alk.nextInt();
            } 
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        } finally {
            try {
                // untuk menutup pemprint-an
                if (writer != null) {
                    writer.close();
                }
                if (writer != null) {
                    file.close();
                }
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }

            // untuk menampilkan semua isi Namafile.txt tadi sebagai struk belanja
            try (BufferedReader br = new BufferedReader(new FileReader(fileb))) {
                String barisData;

                while ((barisData = br.readLine()) != null) {
                    System.out.println(barisData);
                }
            } catch (FileNotFoundException ex1) {
                System.out.println("File tidak ditemukan" + fileb.toString());
            } catch (Exception ex2) {
                System.out.println("File tidak dapat dibaca " + fileb.toString());
            }
        }
        // untuk menampilkan total item, grand total, uang, pajak serta kembalian
        System.out.println(" " + item + " items");
        System.out.println("PAJAK\t\t\t\t\t\tRp " + "0.");
        if (harga != 0) {
            System.out.printf("GRAND TOTAL\t\t\t\t\tRp %.3f \n", harga);
        } else {
            System.out.printf("GRAND TOTAL\t\tRp %.0f \n", harga);
        }
        System.out.printf("TUNAI\t\t\t\t\t\tRp %.3f\n", money);
        System.out.println("____________________________________________________________");
        double kembali = money - harga;
        if (kembali > 0) {
            System.out.printf("KEMBALI\t\t\t\t\t\tRp %.3f\n", kembali);
        } else {
            System.out.printf("KEMBALI\t\t\t\t\t\tRp %.0f.\n", kembali);
        }
        System.out.println("\t>>>>> Terima kasih atas kunjungan anda <<<<<");
        System.out.println("\t\t>>>>> Selamat Menikmati <<<<<");

        alk.close();
    }
}