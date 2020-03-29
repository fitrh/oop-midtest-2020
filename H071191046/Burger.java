public abstract class Burger  {
    static String jenis;
    static int jumlah;
    static double harga;

    public Burger (String jenis, int jumlah, double harga) {
        this.jenis = jenis;
        this.jumlah = jumlah;
        this.harga = harga;
    }
    
	public void showStatus() {
        System.out.println("Your Burger\t: " + jenis);
        System.out.printf("Harga/pc\t: Rp. %.3f" , harga);
    }
}