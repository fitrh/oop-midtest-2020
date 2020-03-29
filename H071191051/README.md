# Object Oriented Programming Mid Test Project

## TO DO List

#### Fitur *Project*
- Sistem untuk Mencatat Jadwal Kegiatan yang akan dilakukan
- Daftar kegiatan dimiliki oleh satu *User*
- Setiap kegiatan memiliki deskripsi
- Setiap kegiatan memiliki jadwal mulai dan jadwal selesai
- Setiap Kegiatan memiliki status selesai, sedang dikerjakan, dan selesi
- Setiap Kegiatan memiliki prioritas
- *User* hanya dapat melihat daftar kegiatan yang dibuatnya
- *User* dapat menampilkan daftar kegitan berdasarkan jadwal, prioritas, atau status
- *User* dapat menghapus dan menambah kegiatan.

Fitur yang di tambahkan :
- *User* harus mendaftar terlebih dahulu agar bisa mengakses *To-Do-List* hariannya 
- *User* dapat mengedit kegiatan
- *User* dapat melihat biodatanya

#### Spesifikasi *Project*
- *project* memiliki 10 buah *class*, antara lain :

      1. *`TodoList.java`* yang merupakan *super class*;
      
      2. *`ShowList.java`*, *`AddList.java`*, *`EditList.java`*, *`DeleteList.java`*, *`DescriptionList.java`*, dan *`Biodata.java`* yang merupakan *subclass* dari *super class* di atas;
      
      3. serta *class* lain yaitu *`Registration.java`* untuk menangani proses registrasi pada program, *`InitialDisplay.java`* untuk menampilkan tampilan awal program dan mengambil pilihan user, dan *`Main.java`* untuk *run* program.
      
- *project* memiliki sebuah *data base* yaitu *kegiatan.txt* untuk menampung kegiatan dari *User* dengan format perbaris berupa *`nama kegiatan(tanpa spasi);nama kegiatan;jadwal;prioritas;status;deskripsi`*
  
#### Alur Kerja *Project*
- untuk menjalankan simulasi *project*, buka dan jalankan *class* *`Main.java`*
- setelah dijalankan maka akan muncul tampilan awal dan *User* akan diminta untuk menekan angka 1 untuk melakukan registrasi 
- *User* harus menginput **nama lengkap**, **nama panggilan**, **tanggal lahir** dengan format **dd-MM-yyyy**, serta **NIM** (lihat *`Registration.java`*).
- setelah pendaftaran berhasil akan muncul tampilan *Menu To-Do-List* di mana *User* menginput angka sesuai pilihan pada *menu*
- pilihan pada menu antara lain **melihat kegiatan**, **menambahkan kegiatan**, **hapus kegiatan**, **edit kegiatan**, **lihat deskripsi**, dan **lihat biodata**.
  
#### *Input & Output*
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
    
#### Konsep *OOP*
hampir semua bagian dari project menggunakan konsep *OOP (class and object - polymorphism)* kecuali konsep *abstract class* dan *interface* dikarenakan masih kurangnya pemahaman mengenai konsep tersebut serta pengaplikasian pada tema project yang agak sulit (menurut saya):(

#### Hal yang ingin di *Improve* kedepannya
lebih memperbarui lagi project atau kalau bisa dibuatkan aplikasinya menggunakan *JavaFX* :v 
