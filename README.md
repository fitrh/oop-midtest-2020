## Tema *Project* yang saya pilih
  
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

## Spesifikasi *Project*

### Dalam project ini terdapat 8 file dengan ekstensi .java dan 4 file dengan ekstensi .txt dengan    penjelsan sebagai berikut

- Mahasiswa.java, di dalamnya terdapat kelas Mahasiswa yang memiliki data yang dapat dimiliki yang oleh mahasiswa seperti nama, alamat email, serta nama dosen pembimbingnya

- Dosen.java, di dalamnya terdapat *interface* Dosen yang punya method abstrak dengan fungsi untuk mendaftarkan mahasiswa bimbingannya serta menampilkan mahasiswa bimbingannya

- DosenPa.java, di dalamnya terdapat kelas DosenPa yang mewarisi *interface* Dosen serta memiliki data yang dapat dimiliki oleh dosen seperti nama, nomor telepon, alamat email, serta daftar mahasiswa bimbingannya

- MataKuliah.java, di dalamnya terdapat kelas MataKuliah yang memiliki data yang dapat dimiliki oleh sebuah mata kuliah seperti kode mata kuliah, nama mata kuliah, nama dosenPengajar, jumlah sks, jumlah kuota yang tersedia, serta daftar mahasiswa yang terdaftar dalam mata kuliah tersebut

- User.java, di dalamnya terdapat kelas User yang memiliki data yang dapat dimiliki oleh seorang user baik itu user mahasiswa maupun user dosen, dan masing - masing user dapat mengakses detail dari mahasiswa ataupun dosen tersebut

- DataSource.java, di dalamnya terdapat kelas DataSource yang berfungsi sebagai tempat baca-tulis data berdasarkan database yang tersedia, database ini berisikan data - data dari mahasiswa, dosen, dan user. Data dari user (mahasiswa / dosen) berupa username dengan password telah tersimpan dalam database yang tersedia

- Login.java, di dalamnya terdapat kelas Login yang berfungsi untuk melakukan segala hal yang dapat dilakukan oleh user ketika telah berhasil masuk ke dalam akunnya, terdapat behavior untuk melakukan verifikasi username dengan password untuk setiap user, menampilkan profil atau detail dari user, serta keluar dari akun

- Main.java, di dalamnya terdapat kelas Main yang berfungsi untuk menjalankan simulasi program ini

- Mahasiswa.txt, berperan sebagai database dari detail seorang mahasiswa dengan format penulisan data adalah id;nama_mahasiswa;alamat_email_mahasiswa

- DosenPa.txt, berperan sebagai database dari detail seorang dosen dengan format penulisan data adalah id;nama_dosen;alamat_email_dosen

- User.txt, berperan sebagai database dari detail seorang user mahasiswa dengan format penulisan data adalah id;username_mahasiswa;password_mahasiswa

- DosenPaUser.txt, berperan sebagai database dari detail seorang user dosen dengan format penulisan data adalah id;username_dosen;password_dosen