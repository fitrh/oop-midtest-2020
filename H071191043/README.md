** Spesifikasi project
1. Menampilkan list menu yang ada di Burger Store.
2. Pemesan burger dan addition.
3. Transaksi.
4. Print Payment Summary.


** Alur Kerja
1. Penerapan konsep oop disetiap class.
2. Untuk pemberian nilai pada attribute menuBurger dan menuAddition menggunakan file I/O, dan membaca isi file 
   dengan bantuan class Scanner.
3. MenuBurger dan menuAddition disimpan dalam ArrayList.
4. Untuk menampilkan menu digunakan polymorphism, yang dimana pada class BurgerStore terdapat method yang di override 
   dari class Cart, kemudian dipanggil di dalam main.
5. Untuk pemesanan burger dan addition di jalankan dalam method buyBurger() pada class BurgerStore.
6. Untuk Transaksi pembelian burger dan addition dijalankan didalam method checkout() pada class BurgerStore.
7. Untuk lebih jelasnya telah terdapat komentar di setiap class.
8. Finish.

** Contoh Input dan Output
   Sudah terdapat menu menu yang akan menuntun anda dalam program ini.

** Konsep object oriented yang diterapkan :
1. Class dan object, dimana terdapat attribute yang behaviour yang saling berinteraksi di dalam class.
2. Abstract dan Inheritance, dimana terdapat kelas Abstrak yang diextends oleh kelas Burger dan Addition
3. Encaptulation di setiap attribute dan method yang terdapat di setiap kelas.
4. Polymorphism yang terdapat pada class Cart dan Burger Store, dimana kelas Cart diextends oleh kelas Burger Store.

** Hal - hal yang ingin di improve kedepannya
1. Menerapkan javaFX.