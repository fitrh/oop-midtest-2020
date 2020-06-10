### Library


 - Sistem Peminjaman Buku Perpustakaan

 - Terdapat User

 - Terdapat daftar User yang berkunjung

 - User dapat mengambil buku untuk dibaca

 - User yang ingin meminjam buku, harus menjadi Member perpustakaan

 - Setiap buku memiliki detail buku yang memuat jenis buku, penulis, penerbit, jumlah halaman, dll

 - Aktifitas peminjaman buku memiliki jadwal peminjaman dan jadwal pengemblian

 - Jika User mengembalikan buku setelah jadwal pengembalian, maka akan dikenai denda yang dihitung perhari

 - Terdapat log yang berisi daftar proses peminjaman

 - User dapat melihat riwayat buku yang dibaca dan buku yang dipinjaman

 - Riwayat yang dapat dilihat oleh user, hanya riwayat milikinya


### Spesifikasi


 - Setidaknya Java 8 diperlukan untuk menjalankan project ini.


### Alur Kerja

  *Sebagai pengunjung
	
	- Masuk sebagai pengunjung tidak membutuhkan persyaratan (seperti mempunyai username dan password), namun, tetap harus mencatatkan
		nama untuk dimasukkan ke daftar pengunjung perpustakaan pada hari tersebut.

	- Pengunjung dapat melihat, memeriksa detail, atau membaca buku, namun belum diperbolehkan meminjam buku.

	- Jika ingin menjadi anggota, pengunjung harus membayar Rp. 30.000,00

	- Aktivitas pengunjung seperti membaca buku dicatat ke dalam buku riwayat aktivitas.

 *Sebagai anggota perpustakaan

	- Saat ingin masuk perpustakaan sebagai anggota, harus menulis username dan password library terdahulu, jika salah tidak boleh masuk

	- Anggota dapat melihat, memeriksa detail, atau membaca buku, dan telah diperbolehkan meminjam buku.

	- Batas peminjaman buku adalah 3 hari, lebih dari itu dikenakan denda perhari.

	- Aktivitas anggota seperti membaca dan meminjam buku dicatat ke dalam buku riwayat aktivitas.

	- Walaupun telah masuk berkali-kali dalam hari yang berbeda, anggota tetap dapat melihat riwayat aktivitas hari-hari sebelumnya

### Contoh input-output

	*Output > :  
_________________________________________________
|_|_|_|_|_|_|_|     PERPUSTAKAAN    |_|_|_|_|_|_|_|
||/            ---------------------            \||
|| 1. Masuk perpustakaan sebagai pengunjung      ||
|| 2. Masuk perpustakaan sebagai anggota/member  ||
|| 3. Pergi                                      ||
||                                               ||
>

	-Input : 1

	*Output > : 

> Silahkan masukkan nama :

	-Input : Deril
	
	*Output > : 

> (INFO) riwayat aktivitas pengunjung dicatat perhari dan tidak disimpan

(Dalam perpustakaan) -> (Sebagai pengunjung)
 1. Lihat daftar buku
 2. Periksa detail buku
 3. Baca buku
 4. Lihat riwayat aktivitas
 5. Lihat daftar pengunjung yang masuk perpustakaan hari ini
 6. Mendaftar menjadi anggota perpustakaan
 7. Keluar
>

	-Input : 3

	*Output > : 

 _________                 _________
|_|_|_|_|_|  DAFTAR BUKU  |_|_|_|_|_|
 1. Buku Harry Potter
 2. Buku Percy Jackson
 3. Buku Narnia
 4. Buku Cara menghasilkan 1000$ tanpa keluar rumah
> Pilih buku :
	
	-Input : 1

	*Output > : 

 _____
|_|_|_| BUKU Harry Potter |_|_|_|
> Harry Potter..

(Dalam perpustakaan) -> (Sebagai pengunjung)
 1. Lihat daftar buku
 2. Periksa detail buku
 3. Baca buku
 4. Lihat riwayat aktivitas
 5. Lihat daftar pengunjung yang masuk perpustakaan hari ini
 6. Mendaftar menjadi anggota perpustakaan
 7. Keluar
>

	-Input : 4

	*Output > : 

(Riwayat aktivitas di perpustakaan)
-21:31 -> Pertama kalinya memasuki perpustakaan
-21:33 -> Membaca Harry Potter


(Dalam perpustakaan) -> (Sebagai pengunjung)
 1. Lihat daftar buku
 2. Periksa detail buku
 3. Baca buku
 4. Lihat riwayat aktivitas
 5. Lihat daftar pengunjung yang masuk perpustakaan hari ini
 6. Mendaftar menjadi anggota perpustakaan
 7. Keluar
>

	-Input : 7

	*Output > : 

> Keluar dari perpustakaan..
 _________________________________________________
|_|_|_|_|_|_|_|     PERPUSTAKAAN    |_|_|_|_|_|_|_|
||/            ---------------------            \||
|| 1. Masuk perpustakaan sebagai pengunjung      ||
|| 2. Masuk perpustakaan sebagai anggota/member  ||
|| 3. Pergi                                      ||
||                                               ||
>

	-Input : 3

	*Output > : 

> Berjalan pergi..


	-Input : 4

	*Output > : 

### Bagian projek yang menerapkan OOP

 - Class Buku dan User menerapkan konsep Object dan Class

 - Menerapkan konsep Constructor saat data dari file diubah menjadi objek

 - Class Buku dan User menerapkan konsep Encapsulation terutama dalam method setter getter

 - Class User menerapkan inheritance kepada dua kelas anak, Guest dan Member

 - Class User merupakan class Abstract karena mempunyai method abstrak, yaitu method untuk melihat riwayat aktivitas

 - Menerapkan polimorfisme saat berubah dari pengunjung(Guest) menjadi anggota(member);

 - Alasan tidak menggunakan interface karena merasa program ini hanya membutuhkan konsep abctract class dan inheritance

### Hal yang ingin diimprove

 - Menerapkan class Admin (turunan dari class User) yang merupakan administrator perpustakaan
     yang nantinya bisa mengakses semua log dari para pengunjung/member


