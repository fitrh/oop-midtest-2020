public class Book {
	private String judul, jenis, penulis, penerbit, isi;
	private String waktuPengembalian;
	private int jumlahHalaman;
	
	Book(String a, String b, String c, String d, int e){
		judul= a; jenis= b; penulis= c; penerbit= d; jumlahHalaman= e;
	}
	
	void setIsi(String a) {isi=a ;}
	
	void setWaktuPengembalian(String a) {waktuPengembalian= a;}
	String getWaktuPengembalian() {return waktuPengembalian;}
	String getJudul() {return judul;}
	
	void detail() {
		System.out.println(" _________                 _________");
		System.out.println("|_|_|_|_|_|  DETAIL BUKU  |_|_|_|_|_|");
		System.out.println(" Judul buku      : "+judul);
		System.out.println(" Jenis buku      : "+jenis);
		System.out.println(" Penulis         : "+penulis);
		System.out.println(" Penerbit        : "+penerbit);
		System.out.println(" Jumlah halaman  : "+jumlahHalaman);
	}
	
	void bacaBuku() {
		System.out.println(" _____ ");
		System.out.println("|_|_|_| BUKU "+judul+" |_|_|_|");
		System.out.println("> "+isi);
	}
	
}
