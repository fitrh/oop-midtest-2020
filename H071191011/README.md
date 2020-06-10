Itemstore
=====

Tugas mid. Source code mungkin memiliki komentar bahasa Indonesia campur Inggris (¬_¬ )

Intinya, itemstore adalah sebagai berikut

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

Spesifikasi
-----

* Setidaknya Java 8 diperlukan untuk menjalankan project ini.

* Yang sedikit berbeda adalah hanya ada 1 kelas _Player_ & _Store Owner_ yaitu _User_.

* Contoh input output tidak diberikan karena output nantinya dibuat secara acak.

Bagian-bagian yang menerapkan konsep OOP hampir semuanya, dengan beberapa informasi sebagai berikut:

* _Item_ menggunakan teknik abstract

* Class yang mewarisi _Item_ mengimplementasikan interface _Consumable_ atau _Usable_

* _Item_ dan turunannya menggunakan konsep polimorfisme.

Dokumentasi
-----

Untuk membuat dokumentasi fungsi-fungsi yang ada, jalankan

```
mvn javadoc:javadoc
```

Maka dokumentasi dapat ditemukan di `target/site/apidocs`

Input & Output
-----

Untuk lebih jelasnya, karena input & outputnya dibuat secara acak, maka lebih baik
jika langsung dijalankan. Pertama buat file JARnya

```
mvn package
```

Lalu jalankan

```
java -jar target/itemstore-0.1.jar
```

Untuk versi 100% acak, atau

```
java -cp target/itemstore-0.1.jar id.co.npad93.itemstore.interact.InteractMain
```

Untuk versi interaktif dari interaksi Player-Store
