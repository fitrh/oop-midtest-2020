Program ini merupakan program Burger Store sederhana

>>>Spesifikasi Project<<<
* setiap menu memiliki nilai defaultnya masing-masing
* pada program ini pelanggan dapat melihat menu burger beserta additionnya
* setiap burger dan addition dapat dipesan lebih dari satu piece
* setiap burger dan addition dipesan lebih dari satu kali
* khusus untuk addition tomato dan ketchup bisa di dapatkan dengan gratis
* addiction yang bisa didapatkan secara gratis dapat dilihat pada menu addiction dengan keterangan "(FREE)"
* jika menginput nomor menu yang salah, maka akan muncul pemberitahuan bahwa nomor menu tersebut tidak tersedia. Kemudian pelanggan dapat mengganti inputan yang salah tersebut
* jika uang untuk pembayaran tidak cukup, maka akan diminta menginput ulang uang
* setelah pembayaran selesai, program akan menapilkan struk belanja yang isinya seluruh nama pesanan, banyak piece setiap pesanan, banyak item yang dipesan, jumlah harga per pesanan dikali piecenya

>>>Alur Kerja<<<
* untuk menjalankan program, buka dan run file Main.class
* setelah dijalankan maka akan muncul tampilan awal yang menampilkan daftar menu yang di ambil dari file Menu.txt kemudian akan diminta menginput nama Pelanggan untuk membuat file NamaPelanggan.txt
* setelah itu akan diminta menginput banyaknya pesanan yang akan dipesan
* nomor menu dan banyak piece per menu akan diminta sebanyak inputan pesanan sebelumnya
* setiap pesanan yang diinput akan langsung di print ke file NamaPelanggan.txt tadi
* saat selesai memesan, akan diminta menginput uang tunai dari pelanggan, uang tunai harus lebih dari grand total pesanan
* jika uang tunai kurang, maka akan diminta menginputnya ulang
* kemudian akan ditampilkan struk pesanan yang berisi seluruh nama pesanan beserta piece, harga dan total harga per pesanan yang di panggil dari NamaPelanggan.txt

>>>Contoh input-output<<<
RUN
==========================================================
                        BURGER STORE
==========================================================
                            MENU
==========================================================
           -BURGER-         |           -ADDITION-
    1. Chicken Muffin       |       7.  Cola
    2. Beef Burger          |       8.  Sprite
    3. Triple Burger        |       9.  Fanta
    4. Big Mac              |       10. Potato
    5. Cheese Burger        |       11. Tomato(FREE)
    6. Chicken Burger       |       12. Ketchup(FREE)
                            |       13. Air Mineral
                            |       14. Iced Lemon
                            |       15. Orange Juice
                            |       16. Sundae Chocolate
                            |       17. Sundae Strawberry
==========================================================
Input Nama Anda:Alika
Input Banyak Pesanan: 17
Input Nomor Pesanan Anda(spasi)piece :
1 1
2 1
3 1
4 1
5 1
6 1
7 1
8 1
9 1
10 1
11 1
12 1
13 1
18 1
Pilihan anda tidak tersedia pada menu //ini ditampilkan karena menu hanya ada 17 jenis
14 1
15 1
16 1
17 1
Uang tunai: 100
Uang anda tidak cukup // ini ditmapilkan karena uang yang diinput kurang dari grand total pesanan
Uang tunai: 400
____________________________________________________________
 Pesanan                        Harga           Total
____________________________________________________________
Chicken Muffin  x1              Rp 25.000       Rp 25.000
Beef Burger     x1              Rp 28.000       Rp 28.000
Triple Burger   x1              Rp 40.000       Rp 40.000
Big Mac         x1              Rp 38.000       Rp 38.000
Cheese Burger   x1              Rp 31.000       Rp 31.000
Chicken Burger  x1              Rp 28.000       Rp 28.000
Cola            x1              Rp 6.000        Rp 6.000
Sprite          x1              Rp 6.000        Rp 6.000
Fanta           x1              Rp 6.000        Rp 6.000
Potato          x1              Rp 11.000       Rp 11.000
Tomato          x1              Rp 0.           Rp 0.
Ketchup         x1              Rp 0.           Rp 0.
Air Mineral     x1              Rp 7.000        Rp 7.000
Iced Lemon      x1              Rp 9.000        Rp 9.000
Orange Juice    x1              Rp 11.000       Rp 11.000
Sundae Chocolate x1             Rp 6.000        Rp 6.000
Sundae Strawberry x1            Rp 6.000        Rp 6.000
____________________________________________________________
 17 items
PAJAK                                           Rp 0.
GRAND TOTAL                                     Rp 258.000
TUNAI                                           Rp 400.000
____________________________________________________________
KEMBALI                                         Rp 142.000
        >>>>> Terima kasih atas kunjungan anda <<<<<
                >>>>> Selamat Menikmati <<<<<


>>>Bagian dari Project yang Menerapkan Object Oriented<<<
* untuk menyatakan sesuatu yang memiliki sifat dan tingkah laku, menerapkan materi Object
* untuk membungkus kumpulan statements atau perintah serta kumpulan method ke dalam satu file.java, menerapkan materi Class
* untuk meng-instance stiap variable yang dibutuhkan serta menyatakan setiap sifat dan tingkah laku yang dapat dilakukan setiap class/subclass, menerapkan materi Attribute dan Behaviour 
* untuk penginputan piece setiap subclass yang berbeda serta untuk memberi harga default dalam subclass dari setiap menu, menerapkan materi Constructor
* untuk membatasi akses dari luar terhadap attribute, method, atau constructor, menerapkan materi Access Modifier (Encapsulation)
* untuk mewariskan setiap tingkah laku dari superclass ke subclassnya, menerapkan materi Inharitance
* untuk mengubah dan mengambil nilai dari suatu attribute private dan protected dalam sebuah class, menerapkan materi Setter dan Getter (Encapsulation)
* untuk membuat jenis-jenis menu burger dan addition menerapkan materi Abstract Class sehingga saya tidak menerapkan interface
* untuk mempresentasikan bentuk burger ke bayak jenis, menerapkan materi Polymorphism

>>>Hal-hal yang ingin diimprove kedepannya<<<
* mempersingkat kode dan lebih irit memori serta menerapkan JAVAFX
* membuat program yang memiliki lebih banyak spesifikasi 