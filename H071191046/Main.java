import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double total1, total2 = 0, total3=0, total4=0, total5=0, total6=0, total7=0, total8=0, total9=0;
        double subtotal = 0;
        double money = 0;
        String validasi = "";
        System.out.println("==SELAMAT DATANG DI BURGER KING==");
        for (String i = "Y"; i.equals("Y")||i.equals("y");) {
            System.out.println("1. MENU BURGER");
            System.out.println("2. MENU ADDITION");
            System.out.println();
            System.out.print("choose :");
            int choose = sc.nextInt();
            if (choose == 1) {
                System.out.println("Pilih Menu Burger");
                System.out.println("1. Cheese Burger");
                System.out.println("2. Beef Burger");
                System.out.println("3. Chicken Burger");
                System.out.print("Pilih Menu Burger : ");    
                int choose1 = sc.nextInt();
                if(choose1 == 1) {
                    Burger cb = new CheeseBurger();
                    System.out.print("Jumlah : ");
                    cb.jumlah = sc.nextInt();
                    cb.showStatus();
                    total1 = cb.jumlah * cb.harga;
                    System.out.printf("\nTotal\t\t: Rp. %.3f " , total1);
                    subtotal += total1;
                } else if (choose1 == 2) {
                    Burger bb = new BeefBurger();
                    System.out.print("Jumlah : ");
                    bb.jumlah = sc.nextInt();
                    bb.showStatus();
                    total2 = bb.jumlah * bb.harga;
                    System.out.printf("\nTotal\t\t: Rp. %.3f " , total2);
                    subtotal += total2;;
                } else if (choose1 == 3) {
                    Burger ch = new ChickenBurger();
                    System.out.print("Jumlah : ");
                    ch.jumlah = sc.nextInt();
                    ch.showStatus();
                    total3 = ch.jumlah * ch.harga;
                    System.out.printf("\nTotal\t\t: Rp. %.3f " , total3);
                    subtotal += total3;
                } else {
                    System.out.println("Tidak Terdapat Pilihan ini");
                }
            } else if (choose == 2) {
                System.out.println("1. Lemon Tea");
                System.out.println("2. French Fries");
                System.out.println("3. Chicken Nugget");
                System.out.println("4. King Fushion");
                System.out.println("5. Ketchup");
                System.out.println("6. Air Mineral");
                System.out.println("PILIH MENU ADDITION");
                System.out.print("Choose : ");
                int choose2 = sc.nextInt();
                if (choose2 == 1) {
                    Addition lt = new LemonTea();
                    System.out.print("Jumlah : ");
                    lt.jumlah = sc.nextInt();
                    lt.showStatus();
                    total4 = lt.jumlah * lt.harga;
                    System.out.printf("\nTotal\t\t: Rp. %.3f " , total4);
                    subtotal += total4;
                } else if (choose2 == 2) {
                    Addition ff = new FrenchFries();
                    System.out.print("Jumlah : ");
                    ff.jumlah = sc.nextInt();
                    ff.showStatus();
                    total5 = ff.jumlah * ff.harga;
                    System.out.printf("\nTotal\t\t: Rp. %.3f " , total5);
                    subtotal += total5;
                } else if (choose2 == 3) {
                    Addition cc = new ChickenNugget();
                    System.out.print("Jumlah : ");
                    cc.jumlah = sc.nextInt();
                    cc.showStatus();
                    total6 = cc.jumlah * cc.harga;
                    System.out.printf("\nTotal\t\t: Rp. %.3f " , total6);
                    subtotal += total6;
                } else if (choose2 == 4) {
                    Addition kf = new KingFushion();
                    System.out.print("Jumlah : ");
                    kf.jumlah = sc.nextInt();
                    kf.showStatus();
                    total7 = kf.jumlah * kf.harga;
                    System.out.printf("\nTotal\t\t: Rp. %.3f " , total7);
                    subtotal += total7;
                } else if (choose2 == 5) {
                    Addition ke = new Ketchup();
                    System.out.print("Jumlah : ");
                    ke.jumlah = sc.nextInt();
                    ke.showStatus();
                    total8 = ke.jumlah * ke.harga;
                    System.out.printf("\nTotal\t\t: Rp. %.3f " , total8);
                    subtotal += total8;
                } else if (choose2 == 6) {
                    Addition am = new AirMineral();
                    System.out.print("Jumlah : ");
                    am.jumlah = sc.nextInt();
                    am.showStatus();
                    total9 = am.jumlah * am.harga;
                    System.out.printf("\nTotal\t\t: Rp. %.3f " , total9);
                    subtotal += total9;
                } else {
                    System.out.println("Tidak Terdapat Pilihan ini");
                }

            }
            System.out.println("\nApa ingin memesan lagi? Y/N"); 
            i = sc.next();
        }
        System.out.printf("Total pembelian : Rp. %.3f", subtotal);
        do {
            validasi = "Y";
            System.out.print("\nUang Anda : ");
            try {
                money = sc.nextDouble();
                if (money < subtotal) {
                    validasi = "N";
                    System.out.println("Tidak Cukup Uangta Bos");
                }
            } catch (Exception e) {
                validasi = "N";
                System.out.println("Wrong Input");
                sc.nextLine();
            }
        } while (validasi == "N");
        if (money == subtotal) {
            System.out.println("Payment Success!");
            System.out.println("Thanks for coming");
        } else if (money > subtotal){
            double change = money - subtotal;
            System.out.printf("Kembalian : Rp %.3f" , change );
            System.out.println("\nPayment Success!");
            System.out.println("Thanks for coming");
        }
    }
}