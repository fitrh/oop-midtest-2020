import java.util.ArrayList;
import java.util.HashMap;

public class Member extends User{
	
	Member(){}
	
	Member(String nama, int uang){
		this.nama= nama;
		this.uang= uang;
	}
	
	Member(String nama, int uang, HashMap<String,String> daftarLog){
		this.nama= nama;
		this.uang= uang;
		this.daftarLog= daftarLog;
	}
	
	@Override
	void lihatRiwayatAktivitas() {
		
		System.out.println("(Riwayat aktivitas di perpustakaan)");
		
		for(int i=0; i<Main.daftarTanggal.size(); i++) {
			System.out.println((i+1)+". "+Main.daftarTanggal.get(i));
		}
		
		System.out.print("> Pilih tanggal : ");
		
		String input= xx.next();
		int indeksTanggal= Integer.parseInt(input)-1;
		
		if(daftarLog.get(Main.daftarTanggal.get(indeksTanggal))==null || daftarLog.get(Main.daftarTanggal.get(indeksTanggal)).length()==0){
			daftarLog.put(Main.setTanggal(), "-Tidak melakukan apapun-");
		}
		System.out.println(daftarLog.get(Main.daftarTanggal.get(indeksTanggal)));
	}
	
}
