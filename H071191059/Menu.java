import java.io.IOException;
import java.util.Scanner;

class Menu {
    public static void ser() throws IOException {
        Scanner sc = new Scanner(System.in);
        for (boolean b = true; b;) {
            System.out.println();
            System.out.println(">>>>> TO DO LIST <<<<<");
            System.out.println("(1) Lihat to do list");
            System.out.println("(2) Tambah to do list");
            System.out.println("(3) Update to do list");
            System.out.println("(4) Detail kegiatan");
            System.out.println("(5) Hapus to do list");
            System.out.println("(6) Keluar");
            System.out.println(">>>>>>>>>> <<<<<<<<<<<");
            System.out.println();

            ListTDL tdl = new TDL();
            int a = sc.nextInt();

            try {
                switch (a) {

                    // Lihat kegiatan
                    case 1:
                        tdl.showList();
                        break;

                    // Tambah kegiatan
                    case 2:
                        sc.nextLine();
                        tdl.add();
                        break;

                    // Update detail kegiatan
                    case 3:
                        System.out.print("Index: ");
                        tdl.update(sc.nextInt() - 1);
                        break;

                    // Menampilkan detail 1 kegiatan
                    case 4:
                        System.out.print("Index: ");
                        tdl.detail(sc.nextInt() - 1);
                        break;

                    // Hapus kegiatan
                    case 5:
                        System.out.print("Index: ");
                        tdl.delete(sc.nextInt() - 1);
                        break;

                    // Keluar
                    case 6:
                        b = false;
                        break;

                    default:
                        System.out.println("Salah input!");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (IndexOutOfBoundsException ie) {
                System.out.println("");
            }
        }
    }
}