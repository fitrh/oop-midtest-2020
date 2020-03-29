# Object Oriented Programming Mid Test Project

## TO DO List

#### Fitur _Project_

-   Sistem untuk Mencatat Jadwal Kegiatan yang akan dilakukan
-   Daftar kegiatan dimiliki oleh satu _User_
-   Setiap kegiatan memiliki deskripsi
-   Setiap kegiatan memiliki jadwal mulai dan jadwal selesai
-   Setiap Kegiatan memiliki status selesai, sedang dikerjakan, dan selesi
-   Setiap Kegiatan memiliki prioritas
-   _User_ hanya dapat melihat daftar kegiatan yang dibuatnya
-   _User_ dapat menampilkan daftar kegitan berdasarkan jadwal, prioritas, atau status
-   _User_ dapat menghapus dan menambah kegiatan.

Fitur yang di tambahkan :

-   _User_ harus mendaftar terlebih dahulu agar bisa mengakses _To-Do-List_ hariannya
-   _User_ dapat mengedit kegiatan
-   _User_ dapat melihat biodatanya

#### Spesifikasi _Project_

-   _project_ memiliki 10 buah _class_, antara lain :

        1. *`TodoList.java`* yang merupakan *super class*;

        2. *`ShowList.java`*, *`AddList.java`*, *`EditList.java`*, *`DeleteList.java`*, *`DescriptionList.java`*, dan *`Biodata.java`*      yang merupakan *subclass* dari *super class* di atas;

        3. serta *class* lain yaitu *`Registration.java`* untuk menangani proses registrasi pada program, *`InitialDisplay.java`* untuk menampilkan tampilan awal program dan mengambil pilihan user, dan *`Main.java`* untuk *run* program.

-   _project_ memiliki sebuah _data base_ yaitu _kegiatan.txt_ untuk menampung kegiatan dari _User_ dengan format perbaris berupa _`nama kegiatan(tanpa spasi);nama kegiatan;jadwal;prioritas;status;deskripsi`_

#### Alur Kerja _Project_

-   untuk menjalankan simulasi _project_, buka dan jalankan _class_ _`Main.java`_
-   setelah dijalankan maka akan muncul tampilan awal dan _User_ akan diminta untuk menekan angka 1 untuk melakukan registrasi
-   _User_ harus menginput **nama lengkap**, **nama panggilan**, **tanggal lahir** dengan format **dd-MM-yyyy**, serta **NIM** (lihat _`Registration.java`_).
-   setelah pendaftaran berhasil akan muncul tampilan _Menu To-Do-List_ di mana _User_ menginput angka sesuai pilihan pada _menu_
-   pilihan pada menu antara lain **melihat kegiatan**, **menambahkan kegiatan**, **hapus kegiatan**, **edit kegiatan**, **lihat deskripsi**, dan **lihat biodata**.

#### _Input & Output_

    contoh input saat registrasi --> nama           : muhammad fajri rasid
                                     nama panggilan : fajri
                                     Tanggal lahir  : 26-02-2001
                                     NIM            : H071191051
    contoh input saat menambah kegiatan --> nama kegiatan : bermain tic tac toe
                                            jadwal        : 10.00 - 00.00
                                            prioritas     : 1 (terdapat pilihan)
                                            status        : 1 (terdapat pilihan)
                                            deskripsi     : jangan lupa mengajak teman-teman lain
    *untuk inputan lainnya lebih jelas silahkan langsung jalankan program

#### Konsep _OOP_

hampir semua bagian dari project menggunakan konsep _OOP (class and object - polymorphism)_ kecuali konsep _abstract class_ dan _interface_ dikarenakan masih kurangnya pemahaman mengenai konsep tersebut serta pengaplikasian pada tema project yang agak sulit (menurut saya):(

#### Hal yang ingin di _Improve_ kedepannya

lebih memperbarui lagi project atau kalau bisa dibuatkan aplikasinya menggunakan _JavaFX_ :v
