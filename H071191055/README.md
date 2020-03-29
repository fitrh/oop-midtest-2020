#Tema Project
##Academic System
- Sistem Informasi Akademik Sederhana
- Terdapat Mahasiswa, Dosen, dan Matakuliah
- Setiap Mahasiswa dapat mengambil beberapa Matakuliah
- Setiap Matakuliah memiliki SKS dan Dosen Pengajar
- Jumlah SKS Matakuliah yang dapat diambil oleh Mahasiswa tidak boleh melebihi batas maksismum SKS Mahasiswa tersebut
- Setiap Mahasiswa memiliki 1 Dosen Pembimbing
- Dosen Pembimbing dapat memilki lebih dari 1 Mahasiswa bimbingan
- Dosen Pembimbing dapat melihat daftar Mahasiswa bimbingannya beserta detail dari Mahasiswa tersebut, termasuk mengenai Matakuliah yang diambil
- Setiap Mahasiswa dapat melihat detail dari daftar Matakuliah yang diambil
- 1 Matakuliah hanya dapat diambil 1 kali
- Terdapat aktifitas untuk melihat nilai IPS
- Setiap Mahasiswa hanya dapat melihat data miliknya

#Spesifikasi Project
##Dalam project ini terdapat 10 file dengan ekstensi .java dan 6 file dengan ekstensi .txt
- MahasiswaData.java, di dalamnya terdapat kelas MahasiswaData yang berfungsi sebagai database dari mahasiswa. Data yang ada adalah username, password dan profil dari mahasiswa.
- Mahasiswa.java, di dalamnya terdapat kelas Mahasiswa yang dimiliki oleh user mahasiswa, dan user tersebut dapat mengakses profil, mengisi krs, dsb yang bisa dilakukan oleh mahasiswa.
- DetailMahasiswa.java, di dalamnya terdapat kelas DetailMahasiswa yang berisi data seperti nama, nim, program studi, semester, dan dosen pembimbing akademik dari seorang user mahasiswa.
- Dosen.java, di dalamnya terdapat interface Dosen yang mempunyai method abstrak dengan fungsi untuk memasukkan data mahasiswa bimbingannya, menampilkan daftar mahasiswa bimbingannya dan menampilkan detail setiap mahasiswa bimbingannya.
- DosenPAData.java, di dalamnya terdapat kelas DosenPAData yang berfungsi sebagai database dari dosen pa. Data yang ada adalah username, password, profil dari dosen, dan mahasiswa bimbingan dari dosen PA.
- DosenPA.java, di dalamnya terdapat kelas DosenPA yang dimiliki oleh user dosen, dan dosen tersebut dapat mengakses profil, melihat daftar mahasiswa bimbingan dsb dari seorang user dosen.
- DetailDosenPA.java, di dalamnya terdapat kelas DetailDosenPA yang berisi data seperti nama, nomor telepon, email dari seorang user dosen.
- Menu.java, di dalamnya terdapat kelas Menu yang berisi menu dari mahasiswa dan dosen. Menu mahasiswa meliputi lihat profil, menu krs, daftar mata kuliah, lihat ips, dan logout. Sedangkan menu dosen meliputi lihat profil, lihat daftar mahasiswa bimbingan, dan logout.
- Login.java, di dalamnya terdapat kelas Login yang berisi proses login yang terdapat behavior untuk melakukan verifikasi username dan password dari masing - masing mahasiswa dan dosen.
- MataKuliah.java, di dalamnya terdapat kelas MataKuliah yang berisi data seperti kode mata kuliah, nama mata kuliah, sks, dosen pengajar dari sebuah mata kuliah.
- MatKulData.java, di dalamnya terdapat kelas MatKulData yang menjadi database dari mata kuliah. Database ini mengolah semua data dari mata kuliah yang ada.
- Main.java, di dalamnya terdapat kelas Main yang berfungsi untuk menjalankan program ini.
- DetailDosen.txt, berperan sebagai penyimpan data detail dari para dosen dengan format penulisan id;nama dosen;no telepon;email;
- DetailMahasiswa.txt, berperan sebagai penyimpan data detail dari para mahasiswa dengan format penulisan id;nama mahasiswa;nim;program studi;semester;dosen pembimbing;
- ListAkunDosen.txt, berperan sebagai penyimpan data dari akun para dosen dengan format penulisan id;username dosen;password;
- ListAkunMahasiswa.txt, berperan sebagai penyimpan data dari akun para mahasiswa dengan format penulisan id;username mahasiswa;password;
- ListMatKul.txt, berperan sebagai penyimpan data dari mata kuliah dengan format penulisan id;nama matkul;sks;dosen pengajar;
- MahasiswaBimbingan.txt, berperan sebagai penyimpan data dari mahasiswa bimbingan dari dosen PA dengan format penulisan id;username  mahasiswa,dst;

#Alur Kerja Project
- Sebelum menjalankan program ini, ada baiknya untuk memanjatkan puji dan syukur kepada Tuhan Yang Maha Esa atas selesainya project ini.
- Pertama, ubah path data dari FileReader di kelas MahasiswaData, DosenPAData, MatKulData dengan path lengkap dari file txt sesuai dengan data yang dimaksud.
- Jalankan program dengan cara masuk ke folder bin dan jalankan class Main dengan cara mengetik java app.Main pada terminal atau dapat dengan cara mengklik tombol run pada kelas Main jika menggunakan text editor Visual Studio Code.
- Setelah dijalankan akan muncul menu login dengan opsi login untuk mahasiswa dan dosen.
- Jika memilih opsi Mahasiswa maka user akan diminta memasukkan username dan password yang sama dengan data dari ListAkunMahasiswa.txt, hal yang sama juga terjadi jika memilih opsi Dosen. (akun dosen ada di ListAkunDosen.txt).
- Jika login berhasil maka user akan dibawa pada menu sesuai dengan opsi login sebelumnya. Di sini user diminta untuk memasukkan pilihan sesuka hati.
## Login sebagai Mahasiswa
- Jika user memilih opsi Profil, maka akan ditampilkan profil dari mahasiswa tersebut sesuai dengan data dari DetailMahasiswa.java .
- Jika user memilih opsi Kartu Rencana Studi, maka akan ditampilkan menu KRS yang meliputi Lihat KRS untuk melihat KRS mahasiswa (jika ada), Isi KRS untuk mengisi KRS, dan Hapus Mata Kuliah untuk menghapus mata kuliah yang ingin dihapus dari KRS.
- Jika user memilih opsi Lihat IPS, maka akan ditampikan nilai IPS dari mahasiswa tersebut.
- Jika user memilih opsi Logout, maka user akan keluar dari akun tersebut dan kembali ke menu login.
## Login sebagai Dosen
- Jika user memilih opsi Profil, maka akan ditampilkan profil dari dosen tersebut sesuai dengan data dari DetailDosenPA.java
- Jika user memilih opsi Mahasiswa yang Dibimbing, maka akan ditampikan daftar dari mahasiswa yang dibimbing dan opsi untuk menampilkan profil dari mahasiswa yang dipilih. (jika ada)
- Jika user memilih opsi Logout, maka user akan keluar dari akun tersebut dan kembali ke menu login.

#Input & Output
##Contoh input dan output pada user Mahasiswa
```
Selamat Datang di Sistem Akademik
Login :
1. Mahasiswa
2. Dosen
> 1

-- Login Mahasiswa --
Username        : H071191055
Password        : kk123
Success

-- Menu --
1. Profil
2. Kartu Rencana Studi
3. Daftar Mata Kuliah 
4. Lihat IPS
5. Logout
> 1

-- Profil --
Nama                   	: Richard Enrico Sulieanto
NIM                      	: H071191055
Program Studi    	: Ilmu Komputer - S1      
Semester              	: Semester Genap 2019/2020
Dosen Pembimbing 	: Drs. Diaraya

Anda ingin keluar ? (Y/N)
> n

-- Menu --
1. Profil
2. Kartu Rencana Studi
3. Daftar Mata Kuliah 
4. Lihat IPS
5. Logout
> 2

--Menu KRS--        
1. Lihat KRS        
2. Isi KRS
3. Hapus Mata Kuliah
> 2

-- Daftar Mata Kuliah -- 
1. Bahasa Inggris (2)    
2. Matematika Dasar 2 (3)
3. Wawasan IPTEKS (2)    
4. Pemrograman Berorientasi Objek (3)
5. Aljabar Linear (3)
6. Kewarganegaraan (2)
7. Metode Statistika (3)
8. Logika Komputer (3)
9. Technopreneurship (3)
> 1
Mata Kuliah Bahasa Inggris berhasil ditambahkan
Sisa SKS yang dapat dibelanjakan adalah 8

Done ? (Y/N)
> n

-- Daftar Mata Kuliah --
1. Bahasa Inggris (2)
2. Matematika Dasar 2 (3)
3. Wawasan IPTEKS (2)
4. Pemrograman Berorientasi Objek (3)
5. Aljabar Linear (3)
6. Kewarganegaraan (2)
7. Metode Statistika (3)
8. Logika Komputer (3)
9. Technopreneurship (3)
> 2
Mata Kuliah Matematika Dasar 2 berhasil ditambahkan
Sisa SKS yang dapat dibelanjakan adalah 5

Done ? (Y/N)
> n

-- Daftar Mata Kuliah --
1. Bahasa Inggris (2)
2. Matematika Dasar 2 (3)
3. Wawasan IPTEKS (2)
4. Pemrograman Berorientasi Objek (3)
5. Aljabar Linear (3)
6. Kewarganegaraan (2)
7. Metode Statistika (3)
8. Logika Komputer (3)
9. Technopreneurship (3)
> 3
Mata Kuliah Wawasan IPTEKS berhasil ditambahkan
Sisa SKS yang dapat dibelanjakan adalah 3

Done ? (Y/N)
> n

-- Daftar Mata Kuliah --
1. Bahasa Inggris (2)
2. Matematika Dasar 2 (3)
3. Wawasan IPTEKS (2)
4. Pemrograman Berorientasi Objek (3)
5. Aljabar Linear (3)
6. Kewarganegaraan (2)
7. Metode Statistika (3)
8. Logika Komputer (3)
9. Technopreneurship (3)
> 4
Mata Kuliah Pemrograman Berorientasi Objek berhasil ditambahkan
Sisa SKS yang dapat dibelanjakan adalah 0

Done ? (Y/N)
> n

-- Daftar Mata Kuliah --
1. Bahasa Inggris (2)
2. Matematika Dasar 2 (3)
3. Wawasan IPTEKS (2)
4. Pemrograman Berorientasi Objek (3)
5. Aljabar Linear (3)
6. Kewarganegaraan (2)
7. Metode Statistika (3)
8. Logika Komputer (3)
9. Technopreneurship (3)
> 5
SKS tidak mencukupi

Done ? (Y/N)
> n

-- Daftar Mata Kuliah --
1. Bahasa Inggris (2)
2. Matematika Dasar 2 (3)
3. Wawasan IPTEKS (2)
4. Pemrograman Berorientasi Objek (3)
5. Aljabar Linear (3)
6. Kewarganegaraan (2)
7. Metode Statistika (3)
8. Logika Komputer (3)
9. Technopreneurship (3)
> 1
Anda sudah terdaftar pada matakuliah ini

Done ? (Y/N)
> y

Anda ingin keluar dari Menu KRS ? (Y/N)
> y

Anda ingin keluar ? (Y/N)
> y

-- Menu --
1. Profil
2. Kartu Rencana Studi
3. Daftar Mata Kuliah
4. Lihat IPS
5. Logout
> 3
-- Daftar Mata Kuliah --
1. Bahasa Inggris
        Kode Mata Kuliah	: 1
        Jumlah SKS           	: 2
        Dosen             		: Sukmawati Marzuki
2. Matematika Dasar 2
        Kode Mata Kuliah  	: 2
        Jumlah SKS        	: 3
        Dosen             		: Diaraya & Armin Lawi
3. Wawasan IPTEKS
        Kode Mata Kuliah  	: 3
        Jumlah SKS        	: 2
        Dosen             		: Baharuddin
4. Pemrograman Berorientasi Objek
        Kode Mata Kuliah  	: 4
        Jumlah SKS        	: 3
        Dosen             		: Armin Lawi
5. Aljabar Linear
        Kode Mata Kuliah  	: 5
        Jumlah SKS        	: 3
        Dosen             		: Budi Nurwahyu & Muh. Zakir
6. Kewarganegaraan
        Kode Mata Kuliah  	: 6
        Jumlah SKS        	: 2
        Dosen             		: Saripuddin
7. Metode Statistika
        Kode Mata Kuliah  	: 7
        Jumlah SKS        	: 3
        Dosen             		: Sitti Sahriman Salam
8. Logika Komputer
        Kode Mata Kuliah  	: 8
        Jumlah SKS        	: 3
        Dosen             		: Nur Erawaty & Diaraya
9. Technopreneurship
        Kode Mata Kuliah  	: 9
        Jumlah SKS        	: 3
        Dosen             		: Diaraya & Hasbi

Anda ingin keluar ? (Y/N)
> y

-- Menu --
1. Profil
2. Kartu Rencana Studi
3. Daftar Mata Kuliah
4. Lihat IPS
5. Logout
> 4

IPS dari Richard Enrico Sulieanto
IPS : 2.28

Anda ingin keluar ? (Y/N)
> y

-- Menu --
1. Profil
2. Kartu Rencana Studi
3. Daftar Mata Kuliah
4. Lihat IPS
5. Logout
> 5

Anda Yakin ? (Y/N)
> y

Selamat Datang di Sistem Akademik
Login :
1. Mahasiswa
2. Dosen
>

```

#Konsep OOP
##Class & Object
Diterapkan hampir di semua kelas
##Attribute, Behavior, & Constructor
Diterapkan hampir di semua kelas
##Encapsulation
Diterapkan hampir di semua kelas pada pembuatan getter
##Inheritance
Diterapkan pada interface Dosen ke kelas DosenPA pada method abstract seperti set(), showMahasiswaBimbingan(), showDetailMahasiwaBimbingan(Integer key)
##Abstract & Interface
Diterapkan pada interface Dosen ke kelas DosenPA pada method abstract di dalamnya yang diimplements ke kelas DosenPA dan dilakukan override pada setiap method dari Interface tersebut
##Polymorphism
Tidak diterapkan karena saya tidak tahu mau diaplikasikan pada bagian mana

#Hal yang ingin diperbaiki kedepannya tentang program ini
- Ingin membuat program yang lebih efisien
- Ingin lebih sering menghindari NullPointerException
- Menambahkan konsep OOP lainnya
- Menambahkan kelas Admin untuk mengatur data - data pada program ini