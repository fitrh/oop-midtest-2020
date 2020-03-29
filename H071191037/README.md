بِسْــــــــــــــمِ اللهِ الرَّحْمَنِ الرَّحِيْـــــمِ .
# Bank System

## Spesifikasi Project :
- Project ini dibuat dengan Bahasa Pemrograman Java
- Project ini dibuat menggunakan Intellij IDEA
- Project ini Terdiri dari file.txt dan file.java

## Alur Kerja :
1. File.txt merupakan Database dari Nasabah Bank dan Diread menggunaka java.io ,
Format file yang digunakan dalam file.txt yaitu *Id* ; *Nama Bank* ; *Nama Nasabah* ; *Nomor Rekening* ; *UserName* ; *Pin* ; *Jumlah Uang*.
2. Dari file.txt tersebut diambil Detail dari nasabah dari masing-masing Bank.
3. Pertama tahap Login untuk nasabah ,jika Input **UserName** dan **pin** yang dimasukkan benar, Maka Proses akan dilanjutkan.
4. Setelah itu nasabah dapat melakukan aktifitas:
- **Menabung**, disini nasabah dapat menabung uang dan program akan menambahkan saldo default nasabah dengan jumlah uang akan diTabung/deposit.
- **Menarik Uang**, disini nasabah dapat mengambil uang. Dengan syarat Uang yang didalam rekening > dari uang yang diambil.
- **Transfer**, disini nasabah dapat mentransferkan uangnya ke nasabah lain. Dengan Syarat Memasukkan Rekening nasabah lain dengan Benar.
- **Log Aktivitas**, disini nasabah dapat melihat aktifitas yang dilakukan selama login. mulai dari menabung,menarik uang , hingga transfer uang ke rekeing nasabah lain dengan detail.
- **Detail Rekening**, disini nasabah dapat melihat detail rekening mereka. Mulai dari Nama Bank, Nama Nasabah, Nomor Rekening, Jumlah Uang, hingga username dan pin mereka.
5. Setelah melakukan Aktifitas diatas Nasabah dapat keluar dengan mengikuti petunjuk yang ada pada menu.

## Contoh Input dan Output :
- Input :
![Capture](https://user-images.githubusercontent.com/42440108/77846990-f16a1e80-71e3-11ea-8379-13b7d60c7b33.JPG)
- Output :
![as](https://user-images.githubusercontent.com/42440108/77846968-d0093280-71e3-11ea-98a6-f48196851a3b.JPG)

## Penggunaan Object Oriented :
1. Object dan class
2. Attribute, Behaviour, dan Contructor
3. Encapsulation , sudah diterapkan di setiap class
4. Inheritance , saya terapkan di class Bank. *dimana Bank menjadi super class dan MandaraBank, BACA Bank, dan BRO Bank menjadi sub class*
5. Abstract , saya juga menerapkan di class Bank. *dimana saya membuat class Bank menjadi Abstract class, kemudian subclass mengOverride Method yang ada di dalam Abstract class*
6. Polymorphism , Saya menerapkannya pada class Menu. 

## Hal yang ingin di Improve :
1. Menyimpan aktifitas nasabah yang telah dilakukan.
2. Membuat Tampilan Menu yang lebih menarik.
3. MengEfisienkan kode.
4. lebih merapikan kode.

## NB :
![jh](https://user-images.githubusercontent.com/42440108/77847554-22e4e900-71e8-11ea-8cf3-4c17388be674.JPG)

*jika terjadi kesalahan, bisa anda liat di file.txt dengan format yang sudah dijelaskan di Alur Program.*
