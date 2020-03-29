# ITEM STORE PROJECT

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
3. *Player*
   - Player Memiliki Nama, Uang, dan Item
   - Player Bisa Memiliki Lebih dari Satu Item
   - Player Bisa Menjual Item dengan menambahkannya ke daftar Penawaran
   - Item yang ditambahkan ke daftar penawaran Pindah dari Item milik Player
   - Player Bisa Menentukan harga Item untuk ditawarkan
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


##C. CONTOH INPUT OUTPUT

##D. PENGGUNAAN OBJECT ORIENTED

##E. HAL YANG INGIN DI IMPROVE
1. Membuat Menu Untuk Membuat User
2. Menggunakan User Login untuk mengakses suatu User
3. Membuat Project dengan JavaFX
