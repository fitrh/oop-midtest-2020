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

### Dalam project ini terdapat 8 file dengan ekstensi .java dan 5 file dengan ekstensi .txt dengan penjelsan sebagai berikut

- *Mahasiswa.java*, di dalamnya terdapat kelas Mahasiswa yang memiliki data yang dapat dimiliki yang oleh mahasiswa seperti nama, alamat email, serta nama dosen pembimbingnya

- *Dosen.java*, di dalamnya terdapat *interface* Dosen yang punya method abstrak dengan fungsi untuk mendaftarkan mahasiswa bimbingannya serta menampilkan mahasiswa bimbingannya

- *DosenPa.java*, di dalamnya terdapat kelas DosenPa yang mewarisi *interface* Dosen serta memiliki data yang dapat dimiliki oleh dosen seperti nama, nomor telepon, alamat email, serta daftar mahasiswa bimbingannya

- *MataKuliah.java*, di dalamnya terdapat kelas MataKuliah yang memiliki data yang dapat dimiliki oleh sebuah mata kuliah seperti kode mata kuliah, nama mata kuliah, nama dosenPengajar, jumlah sks, jumlah kuota yang tersedia, serta daftar mahasiswa yang terdaftar dalam mata kuliah tersebut

- *User.java*, di dalamnya terdapat kelas User yang memiliki data yang dapat dimiliki oleh seorang user baik itu user mahasiswa maupun user dosen, dan masing - masing user dapat mengakses detail dari mahasiswa ataupun dosen tersebut

- *DataSource.java*, di dalamnya terdapat kelas DataSource yang berfungsi sebagai tempat baca-tulis data berdasarkan database yang tersedia, database ini berisikan data - data dari mahasiswa, dosen, dan user. Data dari user (mahasiswa / dosen) berupa username dengan password telah tersimpan dalam database yang tersedia

- *Login.java*, di dalamnya terdapat kelas Login yang berfungsi untuk melakukan segala hal yang dapat dilakukan oleh user ketika telah berhasil masuk ke dalam akunnya, terdapat behavior untuk melakukan verifikasi username dengan password untuk setiap user, menampilkan profil atau detail dari user, serta keluar dari akun

- *Main.java*, di dalamnya terdapat kelas Main yang berfungsi untuk menjalankan simulasi program ini

- *Mahasiswa.txt*, berperan sebagai database dari detail seorang mahasiswa dengan format penulisan data adalah id;nama_mahasiswa;alamat_email_mahasiswa

- *DosenPa.txt*, berperan sebagai database dari detail seorang dosen dengan format penulisan data adalah id;nama_dosen;alamat_email_dosen

- *User.txt*, berperan sebagai database dari detail seorang user mahasiswa dengan format penulisan data adalah id;username_mahasiswa;password_mahasiswa

- *DosenPaUser.txt*, berperan sebagai database dari detail seorang user dosen dengan format penulisan data adalah id;username_dosen;password_dosen

- *BimbinganDosen.txt*, berperan sebagai database dari daftar mahasiswa bimbingan dari seorang dosen dengan format penulisan data adalah id;username_mahasiswa;...dst

## Alur Kerja *Project*

- Untuk melakukan simulasi project ini, masuk ke folder bin dan jalankan class Main dengan cara mengetik *java app.Main* pada terminal

- Setelah dijalankan maka akan muncul menu utama dengan opsi *Login* untuk login atau opsi *Exit* untuk keluar dari program

- Jika opsi *Login* terpilih maka selanjutnya akan ada opsi login sebagai mahasiswa atau dosen

- Jika memilih opsi *Login Mahasiswa* maka user akan diminta untuk memasukkan username & password yang telah terdapat di dalam database(file-file .txt), hal yang sama juga akan terjadi pada pemilihan opsi *Login Dosen*

- Jika user login sebagai mahasiswa maka akan muncul menu utama user mahasiswa dan user akan diminta untuk memasukkan pilihan lagi

### *Login sebagai mahasiswa*

- Jika user memilih opsi *Lihat Profil* maka akan ditampilkan data dari user berupa nama, alamat email, nama dosen pembimbing, username user, password user, mata kuliah yang diprogramkan, serta jumlah total SKS yang telah diprogramkan user mahasiswa tersebut

- Jika user memilih opsi *Tambah Mata Kuliah* maka akan ditampilkan mata kuliah yang tersedia dan user akan diminta untuk memilih satu mata kuliah yang diinginkan, jika telah memilih maka akan ditambahkan ke dalam informasi yang terdapat dalam opsi *Lihat Profil* selama kuota dari mata kuliah tersebut mencukupi dan jumlah SKS user mahasiswa tidak melebihi 10 SKS (Max SKS dalam contoh program ini)

- Jika user memilih opsi *Hapus Mata Kuliah* maka akan ditampilkan mata kuliah yang telah diprogramkan sebelumnya oleh user (jika ada), untuk melakukan penghapusan mata kuliah maka user akan diminta untuk memasukkan kode mata kuliah tersebut agar mata kuliah dapat dihapus dari daftar mata kuliahnya, yang otomatis akan mengurangi SKS dari user dan menambah kuota yang tersedia untuk mata kuliah tersebut

- Jika user memilih opsi *Informasi IPS* maka akan ditampilkan informasi mengenai mata kuliah yang telah diprogramkan oleh user pada semester lalu beserta IPK dari user mahasiswa tersebut

- Jika user memilih opsi *Logout* maka user akan kembali ke menu utama

### *Login sebagai dosen*

- Jika user memilih opsi *Lihat Profil* maka akan ditampilkan data dari user berupa nama dosen, nomor telepon dosen, serta alamat email dosen

- Jika user memilih opsi *Lihat Mahasiswa Bimbingan* maka akan ditampilkan detail dari mahasiswa bimbingan dosen tersebut (jika ada)

- Jika user memilih opsi *Logout* maka user akan kembali ke menu utama

## Input & Output

### Contoh input output menambah mata kuliah untuk user mahasiswa dan lihat profil

```
--MENU--
1. Login
2. Exit
Masukkan pilihan => 1

--MENU--
1. Login Mahasiswa
2. Login Dosen
Masukkan pilihan => 1

--Input your username & password below--
Username => akmal
Password => meoww
--WELCOME MAHASISWA--
1. Lihat Profil
2. Tambah Mata Kuliah
3. Hapus Mata Kuliah
4. Informasi IPS
5. Logout
Masukkan pilihan => 2

--DAFTAR MATA KULIAH--
1. Matematika Dasar
2. Bahasa Indonesia
3. Bahasa Inggris
4. Pendidikan Agama
5. Wawasan IPTEKS
6. Kewarganegaraan
Masukkan pilihan  => 4

Mata kuliah Pendidikan Agama berhasil ditambahkan
Kuota tersisa untuk mata kuliah Pendidikan Agama sebanyak 0
-------------------------
--WELCOME MAHASISWA--
1. Lihat Profil
2. Tambah Mata Kuliah
3. Hapus Mata Kuliah
4. Informasi IPS
5. Logout
Masukkan pilihan => 1

-------------------------
Berikut adalah profil dari akmal
Nama            : Akmal Zuhdy Prasetya
Email           : trueazp19h@student.unhas.ac.id
Dosen Pembimbing: Lord Lucifer
Username        : akmal
Password        : meoww
Berikut adalah daftar mata kuliah yang diprogramkan oleh akmal
Nama mata kuliah        : Pendidikan Agama
Kode mata kuliah        : 666
Dosen pengajar          : Dosen Agama
Jumlah satuan kredit    : 3
-------------------------
JUMLAH TOTAL SKS : 3
-------------------------
```

## Konsep Object Oriented Programming

### Class & Object

 Diterapkan hampir pada semua kelas

### Attribute, Behavior, & Constructor

Diterapkan hampir pada semua kelas

### Encapsulation

Diterapkan juga hampir pada semua kelas, utamanya adalah pembuatan *getter* pada suatu kelas

### Inheritance

Diterapkan pada *interface* *Dosen* ke kelas *DosenPa* yaitu mewariskan method *abstract* didalamnya

### Abstract & Interface

Diterapkan pada *interface Dosen* yang memiliki method *abstract* di dalamnya yang kemudian di*implements* ke kelas *DosenPa* dan pada kelas *DosenPa* melakukan *Override* pada setiap method dalam *interface Dosen* sebagai bentuk keharusan

### Polymorphism

Tidak diterapkan karena masih kebingungan ingin diaplikasikan pada bagian apa di program

## Hal yang ingin diperbaiki kedepannya tentang program ini

- Lebih baik dalam hal "mempersingkat kode" untuk menjadikan program lebih efisien
- Lebih banyak lagi menerapkan konep *Object Oriented Programming* dalam program ini