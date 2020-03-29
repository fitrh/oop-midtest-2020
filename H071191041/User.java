import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public abstract class User {
	protected String nama;
	protected int uang;
	
	protected Scanner xx=new Scanner(System.in);
	protected Random random= new Random();
	private int indeks= -1;
	
	HashMap <String,String> daftarLog= new HashMap<>();
	
	ArrayList <Book> bukuDipinjam= new ArrayList<>();
	
	User(){}
	
	void setIndeks(int a){indeks= a;}
	
	String getNama() {return nama;}
	int getUang() {return uang;}
	int getIndeks(){return indeks;}
	String getBukuDipinjam() {
		String semuaJudul= "";
		for(int i=0; i<bukuDipinjam.size(); i++){
			semuaJudul+= (bukuDipinjam.get(i).getJudul()+"#-#");
			semuaJudul+= (bukuDipinjam.get(i).getWaktuPengembalian()+"#-#");
		}
		return semuaJudul;
	}
	
	boolean membayar(int bayar) {
		if(uang-bayar>=0) {
			uang-= bayar;
			return true;
		}else return false;
	}
	
	Member menjadiMember() {
		return new Member(nama, uang, daftarLog);
	}
	
	String setTanggal() {
		Date date= new Date();
		return new SimpleDateFormat("yyyy/MM/dd").format(date);
	}
	
	String setWaktu() {
		Date date= new Date();
		return new SimpleDateFormat("HH:mm").format(date);
	}
	
	abstract void lihatRiwayatAktivitas();
}
