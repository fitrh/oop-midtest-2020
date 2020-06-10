public abstract class Burger  {
    static String jenis;
    static int jumlah;
    static double harga;

    public Burger (String jenis, int jumlah, double harga) {
        this.jenis = jenis;
        this.jumlah = jumlah;
        this.harga = harga;
    }
    public abstract void setJenis(String jenis);
    public abstract String getJenis();
    public abstract void setJumlah(int jumlah);
    public abstract int getJumlah();
    public abstract void setHarga(double harga);
    public abstract double getHarga();
	public void showStatus() {
        System.out.println("Your Burger\t: " + jenis);
        System.out.printf("Harga/pc\t: Rp. %.3f" , harga);
    }
}