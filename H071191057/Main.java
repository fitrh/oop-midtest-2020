import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner alk = new Scanner(System.in);
        // int chs = alk.nextInt();

        System.out.println("==========================================================");
        System.out.println("\t\t\tBURGER STORE");
        System.out.println("==========================================================");
        System.out.println("\t\t\t    MENU");
        System.out.println("==========================================================");
        System.out.println("\t\t\t   BURGER");
        System.out.println("----------------------------------------------------------");
        System.out.println("1. Chicken Muffin\n2. Beef Burger\n3. Triple Burger\n4. Big Mac\n5. Cheese Burger\n6. Chicken Burger");
        System.out.println("==========================================================");
        System.out.println("\t\t\t   ADDITION");
        System.out.println("----------------------------------------------------------");
        System.out.println("1. Cola\n2. Sprite\n3. Fanta\n4. Potato\n5. Tomato(FREE)\n6. Ketchup(FREE)\n7. Air Mineral\n8. Iced Lemon\n9. Orange Juice\n10. Sundae Chocolate\n11. Sundae Strawberry");
        System.out.println("==========================================================");
        double harga = 0;
        for (String i = "Y"; i.equals("Y")||i.equals("y"); ){
            System.out.print("Masukkan nomor Burger pesanan anda beserta jumlah piecenya: "); int bg = alk.nextInt();int pc1 = alk.nextInt();
            System.out.println("----------------------------------------------------------");
            switch (bg) {
            case 1:
                ChickenMuffin cm = new ChickenMuffin(pc1);
                cm.showStatus();
                harga += cm.sum();
                break;
            case 2:
                BeefBurger bb = new BeefBurger(pc1);
                bb.showStatus();
                harga += bb.sum();
                break;
            case 3:
                TripleBurger tb = new TripleBurger(pc1);
                tb.showStatus();
                harga += tb.sum();
                break;
            case 4:
                BigMac bm = new BigMac(pc1);
                bm.showStatus();
                harga += bm.sum();
                break;
            case 5:
                CheeseBurger cb = new CheeseBurger(pc1);
                cb.showStatus();
                harga += cb.sum();
                break;
            case 6:
                ChickenBurger ckb = new ChickenBurger(pc1);
                ckb.showStatus();
                harga += ckb.sum();
                break;
            default:
                System.out.println("Pilihan anda tidak tersedia pada menu");
                break;
            }
        System.out.println("----------------------------------------------------------");
        System.out.print("Apakah anda masih ingin memesan Burger? Y/T ");i = alk.next();

        }

        for (String i = "Y"; i.equals("Y")||i.equals("y"); ){
            System.out.print("Masukkan nomor Addition pesanan anda beserta jumlah piecenya: "); int ad = alk.nextInt();int pc2 = alk.nextInt();
            System.out.println("----------------------------------------------------------");
            switch (ad) {
            case 1:
                Cola c = new Cola(pc2);
                harga += c.sum();
                c.showStatus();
                break;
            case 2:
                Sprite s = new Sprite(pc2);
                harga += s.sum();
                s.showStatus();
                break;
            case 3:
                Fanta f = new Fanta(pc2);
                harga += f.sum();
                f.showStatus();
                break;
            case 4:
                Potato p = new Potato(pc2);
                harga += p.sum();
                p.showStatus();
                break;
            case 5:
                Tomato t = new Tomato(pc2);
                harga+= t.sum();
                t.showStatus();
                break;
            case 6:
                Ketchup k = new Ketchup(pc2);
                harga += k.sum();
                k.showStatus();
                break;
            case 7:
                AirMineral am = new AirMineral(pc2);
                harga += am.sum();
                am.showStatus();
                break;
            case 8:
                IcedLemon il = new IcedLemon(pc2);
                harga += il.sum();
                il.showStatus();
                break;
            case 9:
                OrangeJuice oj = new OrangeJuice(pc2);
                harga += oj.sum();
                oj.showStatus();
                break;
            case 10:
                SundaeChocolate sc = new SundaeChocolate(pc2);
                harga += sc.sum();
                sc.showStatus();
                break;
            case 11:
                SundaeStrawberry sb = new SundaeStrawberry(pc2);
                harga += sb.sum();
                sb.showStatus();
                break;
            default:
                System.out.println("Pilihan anda tidak tersedia pada menu");
                break;
            }
            System.out.println("----------------------------------------------------------");
            System.out.print("Apakah anda masih ingin menambah Addition? Y/T ");i = alk.next();
        }

        System.out.print("Uang tunai: ");double money = alk.nextInt();
        System.out.println("----------------------------------------------------------");

        System.out.println("PAJAK\t\t\tRp " + "0.");
        System.out.printf("TOTAL\t\t\tRp %.3f \n" , harga);
        System.out.printf("TUNAI\t\t\tRp %.3f\n", money);
        System.out.println("----------------------------------------------------------");
        double kembali = money - harga;
        System.out.printf("KEMBALI\t\t\tRp %.3f\n", kembali);
        System.out.println("\t\tTerima kasih atas kunjungan anda");
        System.out.println("\t\t\tSelamat Menikmati");
    alk.close();
}
}
