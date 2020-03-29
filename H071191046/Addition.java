public class Addition  {
    static String jenis;
    static int jumlah;
    static double harga;

    public Addition (String jenis, int jumlah, double harga) {
        this.jenis = jenis;
        this.jumlah = jumlah;
        this.harga = harga;
    }
    
	public Addition() {
	}

	public void showStatus() {
        System.out.println("Your Addition\t: " + jenis);
        System.out.printf("Harga/pc\t: Rp. %.3f" , harga);
    }
}
