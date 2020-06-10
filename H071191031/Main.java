import java.util.*;
import java.time.LocalDate; 

public class Main {
  List<pet> allPet = new ArrayList<pet>();
  List<owner> pemilik = new ArrayList<owner>();
  String[] login = new String[]{"pemilik_petclinic","pegawai_petclinic"};
  String[] pw = new String[]{"pemilik54321","pegawai67891"};
  List<String> listLogin = Arrays.asList(login);
	List<String> listPass = Arrays.asList(pw);

	public static void main(String[] args) {
    Main obj = new Main();
    Scanner obj1 = new Scanner(System.in);
    Random rand = new Random();
    int majorLoop = 1;
    while(majorLoop==1){
      System.out.println("\n======= PET CLINIC =======");
		  System.out.println("\nSelamat datang di Pet Clinic. Silahkan pilih aksi berikut. ");
      System.out.println("(a) Daftar sebagai Pelanggan\n(b) Login Pemilik\n(c) Login Pegawai\n(d) Login Pelanggan\n");
      System.out.println("**Masukkan Pilihan selain a, b, c dan d untuk mengakhiri program. \nPilihan anda : ");
		  String pillogin = obj1.nextLine();

      if(pillogin.equalsIgnoreCase("a")){
        System.out.println("\nSilahkan masukkan data Owner pada form berikut!");
	      System.out.println("Nama Lengkap: ");
		    String namalengkap = obj1.nextLine();
		    System.out.println("Alamat: ");
		    String alamat = obj1.nextLine();
		    System.out.println("Nomor Telepon/HP: ");
		    String notelp = obj1.nextLine();
		    int rando = rand.nextInt(1000);

  		  owner s = new owner();
	  	  s.setNamaOwner(namalengkap);
		    s.setKodeOwner(namalengkap.charAt(0)+Integer.toString(rando));
		    s.setAlamat(alamat);
		    s.setNotelp(notelp);
        obj.pemilik.add(s);
        obj.OpsiPelanggan(obj.allPet, s);

      }else if(pillogin.equalsIgnoreCase("b")||pillogin.equalsIgnoreCase("c")){
      
        System.out.println("Username : ");
		    String uname = obj1.nextLine();
        System.out.println("Password : ");
		    String pass = obj1.nextLine();
      
        if(obj.listLogin.contains(uname) && obj.listPass.contains(pass)){
          int loop = 1;
          while(loop==1){
            System.out.println("\nSelamat Datang. Silahkan pilih aksi anda: ");
            System.out.println("1). Melihat Daftar Peliharaan\n2). Melihat Daftar Pelanggan\n3). Logout");
            System.out.println("Pilihan anda : ");
		        String da = obj1.nextLine();
            int daf = Integer.parseInt(da);
            if(daf==1){
              if(obj.allPet.isEmpty()==true){
                System.out.println("Data Hewan Kosong.");            
              }else{
                LihatDataHewan(obj.allPet);
              }
            }else if(daf==2){
              if(obj.allPet.isEmpty()==true){
                System.out.println("Data Hewan Kosong.");            
              }else{
                LihatDataPelanggan(obj.pemilik);
              }
            }else if(daf==3){
               loop=2;
            }else{
              System.out.println("Pilihan salah. Silahkan Coba lagi.");
            }
          }
        }else{
          System.out.println("Data salah. Silahkan Coba lagi.");
        }
      }else if(pillogin.equalsIgnoreCase("d")){
        System.out.println("Nama Lengkap : ");
		    String naml = obj1.nextLine();
        System.out.println("Kode Owner : ");
		    String kodo = obj1.nextLine();
        for(int i =0;i<obj.pemilik.size();i++){
          if(obj.pemilik.get(i).getNamaOwner().equalsIgnoreCase(naml)&&obj.pemilik.get(i).getKodeOwner().equalsIgnoreCase(kodo)){
            obj.OpsiPelanggan(obj.allPet, obj.pemilik.get(i));
          }else{
            System.out.println("Data salah. Silahkan coba lagi.");
          }
        }
      }else{
        System.out.println("Terima kasih.");
        majorLoop=2;
      }
    } 
  }

      public static List<LocalDate> TanggalPenitipan(LocalDate startDate,LocalDate endDate) {
        List<LocalDate> seminggu = new ArrayList<LocalDate>();
        for(int i = 0; i<7;i++){
          LocalDate tgl = startDate.plusDays(i+1);
          seminggu.add(tgl);
        }
        return seminggu;
      }

      public static void JadwalTitipKembali(pet hewan){
          Scanner obj1 = new Scanner(System.in);
          LocalDate date = LocalDate.now(); 
          System.out.println("===== PILIH TANGGAL PENITIPAN =====");
          List<LocalDate> pilihantgl = TanggalPenitipan(date, date.plusDays(7));
          for(int i = 0; i<pilihantgl.size();i++){
              System.out.println((i+1)+". "+pilihantgl.get(i));
          }
          int looptgl = 1;
          while(looptgl==1){
            System.out.println("Masukkan pilihan Tanggal : ");
            String tg = obj1.nextLine();
            int pick = Integer.parseInt(tg);
            if(pick>7 || pick<1){
              System.out.println("Pilihan salah. Masukkan ulang.");
            }else{
              LocalDate tglTerpilih = pilihantgl.get(pick-1);
              hewan.setTanggalTitip(tglTerpilih,tglTerpilih.plusDays(7));
              System.out.println("Tanggal Berhasil Ditentukan. Anda dapat menjemput peliharaan anda maksimal pada "+tglTerpilih.plusDays(7));
              looptgl=2;
          }
          }
      }
            
      public static void LihatDataHewanDijual(List<pet> allPet){
          System.out.println("\n===== DAFTAR SEMUA HEWAN PELIHARAAN DIJUAL=====");
          System.out.println(String.format(" %30s  %30s  %30s ", "KODE HEWAN", "JENIS HEWAN", "STATUS"));
            for(int i=0;i<allPet.size();i++){
                if(allPet.get(i).getStatus().equalsIgnoreCase("Dijual")){
                    System.out.println(String.format(" %30s  %30s  %30s ", allPet.get(i).getKode() , allPet.get(i).getJenisPet(), allPet.get(i).getStatus()));
                }
            }
	    }

      public static void LihatDataHewan(List<pet> allPet){
          System.out.println("\n===== DAFTAR SEMUA HEWAN PELIHARAAN =====");
          System.out.println(String.format(" %30s  %30s  %30s ", "KODE HEWAN", "JENIS HEWAN", "STATUS"));
            for(int i=0;i<allPet.size();i++){
                  System.out.println(String.format(" %30s  %30s  %30s  %30s ", allPet.get(i).getKode() , allPet.get(i).getJenisPet(), allPet.get(i).getStatus(), allPet.get(i).getEndTitip()));
                }
            }
	    
      public static void LihatDataPelanggan(List<owner> allOwner){
          System.out.println("\n===== DAFTAR SEMUA PELANGGAN =====");
          System.out.println(String.format(" %30s  %30s  %30s  %30s  %30s ", "NAMA OWNER", "KODE OWNER", "ALAMAT OWNER", "NOMOR TELEPON", "DAFTAR HEWAN"));
            for(int i=0;i<allOwner.size();i++){
              List<String> jp = new ArrayList<String>();
                for(int j=0;j<allOwner.get(i).getPets().size();j++){
                  jp.add(allOwner.get(i).getPets().get(j).getJenisPet());
                }
                System.out.println(String.format(" %30s  %30s  %30s  %30s  %30s ", allOwner.get(i).getNamaOwner() , allOwner.get(i).getKodeOwner(), allOwner.get(i).getAlamat(), allOwner.get(i).getNotelp(), jp));
            }
	    }

      public static void OpsiPelanggan(List<pet> allPet, owner s){
        Main obj = new Main();
        Scanner obj1 = new Scanner(System.in);
        List<pet> hewan = new ArrayList<pet>();
        Random r = new Random();
        int j = 1;
        while(j==1){
          System.out.println("Silahkan memilih salah satu aksi berikut. ");
		      System.out.println("1). Menitipkan\n2). Menjual\n3). Membeli\n4). Melihat Daftar semua Pet\n5). Melihat Data Pribadi Anda\n6). Log out");
		      System.out.println("Pilih aksi: ");
		      String pill = obj1.nextLine();
          int act = Integer.parseInt(pill);

          switch(act){
            case 1:
              System.out.println("Jumlah Peliharaan yang dititipkan: ");
              String jt = obj1.nextLine();
              int jlhtitip = Integer.parseInt(jt);
    	        System.out.println("Silahkan masukkan data peliharaan.");
		          for(int i=0;i<jlhtitip;i++){
                  int rando = r.nextInt(870);
			            System.out.println("Jenis Hewan: ");
		              String jenispet = obj1.nextLine();
          		        
		              pet aj = new pet();
		              aj.setKode(s.getKodeOwner()+"_"+rando);
		              aj.setStatus("Dititipkan");
		              aj.setJenisPet(jenispet);
		              aj.setKode_Owner(s.getKodeOwner());
		              hewan.add(aj);
		              allPet.add(aj);
                  s.setOwnerDariPet(hewan);
                  JadwalTitipKembali(aj);
                }break;
		        case 2:
              System.out.println("Jumlah Peliharaan yang dijual: ");
              String jj = obj1.nextLine();
              int jlhjual = Integer.parseInt(jj);
	  	        System.out.println("Silahkan masukkan data peliharaan.");
		          for(int i=0;i<jlhjual;i++){
                  int rando2 = r.nextInt(870);
		              System.out.println("Jenis Hewan: ");
		              String jenispet = obj1.nextLine();
		        
		              pet aj = new pet();
		              aj.setKode(s.getKodeOwner()+"_"+rando2);
		              aj.setStatus("Dijual");
		              aj.setJenisPet(jenispet);
		              aj.setKode_Owner(s.getKodeOwner());
		              hewan.add(aj);
		              allPet.add(aj);
                  s.setOwnerDariPet(hewan);
		          }break;
		        case 3:
              if(allPet.isEmpty()==true){
                System.out.println("Peliharaan dijual saat ini belum tersedia :(");
              } else if(allPet.isEmpty()==false){
                LihatDataHewanDijual(allPet);
                System.out.println("Kode Hewan: ");
		            String hewanbeli = obj1.nextLine();
	  	          for(int i=0;i<allPet.size();i++){
                    if(allPet.get(i).getKode().equalsIgnoreCase(hewanbeli)){
                      allPet.remove(i);
                      System.out.println("Hewan Berhasil Dibeli!");
                    }
                }
              }
		          break;
		        case 4:
              if(allPet.isEmpty()==true){
                System.out.println("Peliharaan Titipan maupun dijual saat ini kosong :(");
              } else if(allPet.isEmpty()==false){
                LihatDataHewan(allPet);break;
              }
		        case 5:
              System.out.println("DATA PRIBADI ANDA");
              System.out.println("Nama Lengkap\t\t:"+s.getNamaOwner());
              System.out.println("Kode\t\t\t\t:"+s.getKodeOwner());
              System.out.println("Alamat \t\t\t\t:"+s.getAlamat());
              System.out.println("Nomor Telepon\t\t:"+s.getNotelp());
              System.out.println("Daftar Peliharaan\t:");
              if(s.getPets().isEmpty()){
                System.out.println("Tidak ada data hewan peliharaan.");
              }else{
                System.out.println(String.format(" %30s  %30s  %30s ","KODE HEWAN","JENIS HEWAN","STATUS"));
                for(int i=0;i<s.getPets().size();i++){
                    System.out.println(String.format(" %30s  %30s  %30s ", s.getPets().get(i).getKode() , s.getPets().get(i).getJenisPet(), s.getPets().get(i).getStatus()));
                }
              }
              break;
            case 6:
              j=0;
              break;
            default:
              System.out.println("Pilihan salah. Silahkan coba lagi.");
              break;
          }
        } 
      }
}