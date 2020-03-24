# Object Oriented Programming Mid Test Project

## Alur Pengumpulan *Project* ke Repositori Ini

1. **Fork** Repositori ini.
2. Pada hasil *fork* anda, Buat **Branch** dengan nama **NIM** anda.
3. Pada *branch* **NIM** anda, buat direktori dengan nama **NIM** anda.
4. Project anda disimpan didalam direktori **NIM** anda.
   > - Berkas project berupa  `.java` dimana *satu class satu file*.
   > - Struktur Project dapat menggunakan Struktur Maven, Gradle, Eclipse dan sejenisnya
5. **Push** berkas project anda ke repositori hasil *fork* pada *branch* **NIM** anda.
6. Buat **Pull Request** untuk **Merge** *branch* **NIM** dengan *branch* **master** pada repositori ini.

## Aturan Project Mid

1. Setiap orang memilih salah satu dari tema *project* yang telah disediakan.
2. *Project* yang dibuat harus memiliki semua konsep dari materi yang telah dipelajari (*Class & Object - Polymorphism*).
3. Deskripsi dari tema *project* menjelaskan mengenai gambaran dan *minimum requirement*, yang berarti project yang anda buat minimal memenuhi *requirement* tersebut.
4. Fitur *project* anda boleh dimodifikasi dan ditambahkan, selama syarat no. 3 terpenuhi.
5. Jika *project* anda membutuhkan penyimpanan data, gunakan package *java.nio* untuk baca-tulis file.
6. Didalam direktori **NIM** anda, buat file **README.md** yang menjelaskan mengenai *project* anda termasuk :
   - Spesifikasi *Project*
   - Alur Kerja
   - Contoh *input-output*, jika ada
   - Bagian dari project anda yang menerapkan konsep *object oriented*
   - Jika ada konsep *object oriented* yang tidak anda gunakan, jelaskan mengapa
   - Hal-hal yang ingin di*improve* kedepannya mengenai project yang anda buat
   - dll
7. Lakukan *commit* disetiap perubahan yang anda lakukan selama membuat *project*, hal ini akan menjadi *log* aktifitas dan bukti bahwa project tersebut adalah orisinil dari anda, sertakan *commit message* yang jelas dan deskriptif, *commit message* dapat menggunakan bahasa indonesia ataupun inggris, mengenai tata cara *commit* yang baik, sialahkan baca artikel berikut : [How to Write a Git Commit Message](https://chris.beams.io/posts/git-commit/).
8. *Project* yang dibuat harus memiliki *Main Class* yang terdapat *main method* untuk simulasi *project* anda.

9. Jika anda memiliki tema sendiri diluar dari tema yang disediakan, silahkan didiskusikan terlebih dahulu di grup.

## Tema *Project*

### Pet Clinic

- Sistem Penitipan dan Jual Beli Hewan Peliharaan
- Setiap *Pet* yang dititipkan, memiliki *Owner*
- Setiap *Pet* hanya memiliki 1 *Owner*, dan *Owner* dapat memiliki lebih dari 1 *Pet*
- Setiap *Pet* memiliki status, titipan atau dijual
- Setiap *Owner*, memiliki data pribadi, seperti nama, alamat, no. telepon, dll
- Terdapat aktifitas untuk menitipkan, membeli, atau menjual *Pet*
- Untuk aktifitas menitipkan, terdapat jadwal penitipan dan pengembalian
- Terdapat aktifitas melihat daftar *Pet* Keseluruhan, yang dititipkan, dan yang dijual
- Terdapat aktifitas untuk melihat detail dari sebuah *Pet*, termasuk spesifikasi dari *Pet* tersebut, struktur spesifikasi dari *Pet* bergantung pada jenisnya (Ayam, Kucing, Anjing, dll)
- Untuk data pribadi dari *Owner*, hanya dapat dilihat oleh *Owner* itu sendiri, Pemilik *Pet Clinic* atau pegawai dari *Pet Clinic*

### TO DO List

- Sistem untuk Mencatat Jadwal Kegiatan yang akan dilakukan
- Daftar kegiatan dimiliki oleh satu *User*
- Setiap kegiatan memiliki deskripsi
- Setiap kegiatan memiliki jadwal mulai dan jadwal selesai
- Setiap Kegiatan memiliki status selesai, sedang dikerjakan, dan selesi
- Setiap Kegiatan memiliki prioritas
- *User* hanya dapat melihat daftar kegiatan yang dibuatnya
- *User* dapat menampilkan daftar kegitan berdasarkan jadwal, prioritas, atau status
- *User* dapat menghapus dan menambah kegiatan
  
### Bank

- Sistem Bank Sederhana
- Terdapat Bank
- Terdapat Nasabah, setiap nasabah dapat memiliki lebih dari 1 akun, namun hanya terdapat 1 akun dalam 1 bank
- Setiap Nasabah memiliki Rekening, jika nasabah memiliki akun dibeberapa bank, maka masing-masing akun memiliki detail rekening yang berbeda-beda
- Nasabah dapat melakukan aktifitas menabung, transfer dan menarik uang
- Aktifitas menabung dan menarik uang hanya dapat dilakukan jika nasabah menggunakan akun yang sesuai dengan bank yang dikunjungi
- Untuk aktifitas transfer, terdapat nasabah lain yang ditransferkan
- Setiap nasabah dapat melihat log aktifitas mereka, log aktifitas dikategorikan berdasarkan aktifitas menabung, menarik, mentransfer dan ditarnsferkan
- Setiap aktifitas diatas hanya dapat dilihat oleh nasabah yang bersangkutan setelah melakukan proses autentikasi

### Library

- Sistem Peminjaman Buku Perpustakaan
- Terdapat *User*
- Terdapat daftar *User* yang berkunjung
- *User* dapat mengambil buku untuk dibaca
- *User* yang ingin meminjam buku, harus menjadi *Member* perpustakaan
- Setiap buku memiliki detail buku yang memuat jenis buku, penulis, penerbit, jumlah halaman, dll
- Aktifitas peminjaman buku memiliki jadwal peminjaman dan jadwal pengemblian
- Jika *User* mengembalikan buku setelah jadwal pengembalian, maka akan dikenai denda yang dihitung perhari
- Terdapat log yang berisi daftar proses peminjaman
- *User* dapat melihat riwayat buku yang dibaca dan buku yang dipinjaman
- Riwayat yang dapat dilihat oleh user, hanya riwayat milikinya
  
### Item Store

- Sistem Jual Beli Item
- Terdapat *Store*, masing-masing *Store* memiliki *Owner* dan daftar *Item* yang dijual
- Setiap *Item* memiliki harga, kuantitas, dan detail
- Terdapat *User*, yang dapat berperan sebagai *Player*, *Store Owner*, atau keduanya
- Setiap *User* memiliki Uang
- Setiap *User* dapat memiliki lebih dari 1 *Item*
- Terdapat Aktifitas Membeli dan Menjual
- Jika *User* membeli *Item*, maka daftar itemnya bertambah, namun jika *Item* yang dibeli telah ada dalam daftarnya, maka yang bertambah adalah kuantitas dari *Item* tersebut
- Aktifitas membeli hanya dapat terjadi jika uang dari *User* mencukupu harga *Item*
- Uang dari *User* akan bertambah jika menjual *Item*
- Proses Jual Beli *Item* dapat dilakukan antar *Player-Player*, *Player-Store*, atau *Store-Store*

### Burger Store

- Sistem Penjualan *Hamburger*
- Terdapat Pesanan, setiap Pesanan dapat memilki lebih dari 1 item
- Terdapat beberapa jenis *Humburger*, setiap jenis memiliki harga *default*
- Terdapat *Addition* sperti *Drink*, *Ketchup*, *Potato*, *Tomato*, dll
- Setiap *Addition* memiliki harga
- Setiap Pesanan *Hamburger*, dapat memiliki lebih dari 1 *Addition*
- *Addition* dapat ditambahkan sekaligus atau satu persatu
- Harga akhir pesanan bergantung pada harga *Hamburger* yang dipesan beserta *Addition*nya
  
### Academic System

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
