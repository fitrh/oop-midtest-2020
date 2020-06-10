# TO DO List #

Mid OOP 2020 : Program sederhana untuk mencatat jadwal kegiatan

## Spesifikasi ##
- *project* ini memiliki 1 *superclass* yaitu *`ListTDL.java`* yang memiliki 1 *subclass* yaitu *`TDL.java`*. Selain itu, *project* ini juga memiliki *mainclass* yaitu *`Login.java`* yang akan memanggil class *`Menu.java`* untuk menampilan menu *TO DO List*.
- memiliki *database* yaitu *Akun.txt* untuk menyimpan *username* dan *password* serta *JadwalQ.txt* untuk menyimpan jadwal kegiatan setelah diinput oleh *user*.

## Alur kerja ##
1. Buka file *`Login.java`* dan run.
2. Setelah dijalankan, muncul perintah untuk melakukan registrasi dengan menginput *username* dan *password* yang akan disimpan dalam file *Akun.txt*.
3. Setelah itu, login kembali menggunakan *username* dan *password* yang sudah diinput.
4. Jika berhasil login, muncul tampilan menu untuk To Do List yang di ambil dari file *`Menu.java`* kemudian akan diminta inputan berupa integer untuk memilih opsi menu yang diinginkan.
5. Pilihan pada menu yaitu **melihat kegiatan**, **menambah kegiatan**, **edit kegiatan**, **melihat detail setiap kegiatan**, dan **menghapus kegiatan** serta keluar dari *program*.

## Contoh *input & output* ##
    contoh input registrasi 
        Username = Anugrah
        Password = alfa59
                                            
    contoh input menambah kegiatan 
        Nama kegiatan  : Makan
        Deskripsi      : Makan siang sambil nonton drakor
        Jadwal         : 11 siang - 1 siang
        Status         : belum dikerjakan
        Skala prioritas: 5
                                             
    *untuk input dan output yang lain, silahkan jalankan program.
    
## Bagian yang menerapkan konsep *OOP*
1. **Class & Object**
2. **Inheritance**
    digunakan pada class *`ListTDL.java`* yang menjadi *superclass* dan *`TDL.java`* yang menjadi *subclass*nya.
3. **Encapsulation**
    digunakan pada semua class di *project* ini.
4. **Abstraction**
    digunakan pada class *`ListTDL.java`*.
5. **Polymorphism**
    dapat dilihat pada class *`Menu.java`* baris ke **19**.