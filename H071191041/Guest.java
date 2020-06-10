import java.util.Random;

public class Guest extends User{
	
	Guest(){}
	
	Guest(String a, String b){
		nama= a;
		uang= 50000+(5000*random.nextInt(20));
	}
	
	@Override
	void lihatRiwayatAktivitas() {
		System.out.println("(Riwayat aktivitas di perpustakaan)");
		if(daftarLog.size()==0) {
			System.out.println(" -Anda belum melakukan apapun-");
			daftarLog.put(Main.setTanggal(), "-Tidak melakukan apapun-");
			return;
		}
		
		if(daftarLog.get(Main.setTanggal())==null){
			daftarLog.put(Main.setTanggal(), "-Tidak melakukan apapun-");
		}
		System.out.println(daftarLog.get(setTanggal()));
	}
	
}
