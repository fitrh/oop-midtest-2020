# :convenience_store:  ITEM STORE PROJECT  :department_store:

## A. SPESIFIKASI PROJECT 

1. Project ini dibuat dengan Intellij IDEA
2. Project ini dibuat dengan java versi 11.0.5
3. Project ini terdiri dari beberapa file java dan txt

## B. ALUR KERJA

1. File txt yang akan dijadikan database untuk player, owner, store, dan item diinput menggunakan java.nio
2. Terdapat berberapa User yang berupa Player atau StoreOwner
3. *ITEM*
   - Item memiliki nama, kuantitas, price, dan detail
   - Data Item default berasal dari Item.txt yang diinput di class DataSource
   - Jenis Item yang dijual adalah
  <br>:straight_ruler: Penggaris
  <br>:pencil2:Pulpen
  <br>:pound: Penghapus
  <br>:closed_book: Buku 
  <br>:black_nib: Jangkar
  <br>:scissors: Gunting
  <br>:purse: Krayon
  <br>:notebook: Kamus
  <br>:vibration_mode: Kalkulator
3. *Player*
   - Player Memiliki Nama, Uang, dan Item
   - Player Bisa Memiliki Lebih dari Satu Item
   - Player Bisa Menjual Item dengan menambahkannya ke daftar Penawaran
   - Item yang ditambahkan ke daftar penawaran Pindah dari Item milik Player
   - Player Bisa Menentukan harga Item untuk ditawarkan
   - Player Bisa Berubah Jadi StoreOwner dengan Membangun Toko
4. *Store*
   - Tiap Store Memiliki Owner
   - Item Miliki Store adalah Item Milik Owner
   - Nama Owner dan Store boleh berbeda
   - Tiap Store Bisa Memiliki Motto Penjualan
   - Tiap Store Memiliki Star yang bergantung pada jumlah penjualan
5. *Jual Beli Item*
   - Pembelian Item bisa dari Store atau Penawaran yang dilakukan Oleh player
   - Store bisa membeli beberapa item sekaligus
   - User yang menjual Item uangnya akan bertambah sedangkan User yang menjual uangnya akan berkurang sesua dengan item price ataupun harga penawaran
   - Item akan berpindah dari Penjual ke Pembeli
   - Jika Item yang dibeli telah ada maka kuantitas Item yang akan Bertambah
6. *Save Data*
   - Jika Project disimpan maka semua kondisi akhir dari user akan tersimpan ke database
7. *Delete*
   - Jika suatu user dihapus maka semua unsur milik user akan hilang


## C. CONTOH INPUT OUTPUT


1. Beli Item Dari Store
<img src="https://user-images.githubusercontent.com/54715920/77844030-54a08480-71d5-11ea-8fb3-c813bf40923e.gif" width="240">





2. Beli Item Dari Player
<img src="https://user-images.githubusercontent.com/54715920/77844191-eb217580-71d6-11ea-93dc-de672d3207a6.gif" width="240">

## D. PENGGUNAAN OBJECT ORIENTED
1. Class and Object, Class dan Object digunakan hampir diseluruh bagian Project ini
2. Encapsulasi, Encapsulasi juga digunakan pada beberapa bagian seperti attribute private dll.
3. Inheritance, Inheritance digunakan pada pewarisan class User oleh class Player dan StoreOwner
4. Abstrak dan Interface, Abstrak tidak saya gunakan karena tidak terlalu tau penggunaannya dan projek saya masih sederhana jadi mungkin tidak perlu pake Abstrak, sedangkan Interface saya gunakan untuk mengimplementasikan Penawaran pada Class Player (Meskipun tidak ada tetap bisa)
5. Polymerpisme, Polymerpisme terdapat pada method yang dioverriding dari class User ke class Player dan StoreOwner

## E. HAL YANG INGIN DI IMPROVE
1. Membuat Menu Untuk Membuat User
2. Menggunakan User Login untuk mengakses suatu User
3. Membuat Project dengan JavaFX
