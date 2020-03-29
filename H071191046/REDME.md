"TEMA DARI PROGRAM INI ADALAH BURGER STORE"
$$ SPESIFIKASI PROJECT $$
Burger Store ini memiliki dua pilihan menu, yaitu menu burger dan menu addition. Pembeli dapat memilih menu burger saja tanpa addition, begitupun sebaliknya memilih addition tanpa memesan burger. Burger terdapat tiga jenis yaitu Chicken Burger, Beef Burger, dan Chicken Burger. Sedangkan menu addition terdapat Lemon Tea, French Fries, Chicken Nugget, King Fushion, Ketchup, dan Air Mineral. Burger dan Addition dapat dipesan lebih dari satu. Subtotal didapat dari jumlah pesanan dikalikan dengan harga burger dan addition itu sendiri. 
$$ ALUR KERJA $$
Setelah program ini dicompile, maka tampilan pertama adalah memilih apakah pembeli ingin memilih burger atau addition, jika memilih burger maka akan ditampilkan 3 jenis burger, dan pembeli akan memilih salah satu jenis burger dan memasukkan jumlah pesanannya. Begitupula jika memilih addition maka ditampilkan 6 jenis addition dan memasukkan jumlah pesanan. setelah memasukkan jumlah, maka akan ditampilkan jenis pesanan dan harga pesanan/pc, dan juga total harga pesanan. Kemudian, pembeli akan ditanya "Apakah ingin memesan lagi?" jika ya, maka kembali ditampilkan apakah ingin menu burger atau addition. jika pembeli tidak ingin memesan lagi, maka akan ditampilan total harga pesanan dan akan diminta untuk menginput jumlah uang. jika uang kurang, maka tidak bisa membayar. jika uang pas maka pembayaran sukses. jika uang lebih, maka uang akan dikembalikan sesuai perhitungan.
$$ Contoh Input Output $$
CONTOH 1:
==SELAMAT DATANG DI BURGER KING
1. MENU BURGER
2. MENU ADDITION

choose :1
Pilih Menu Burger
1. Cheese Burger
2. Beef Burger
3. Chicken Burger
Pilih Menu Burger : 1
Jumlah : 2
Your Burger     : Cheese Burger
Harga/pc        : Rp. 20.000
Total           : Rp. 40.000
Apa ingin memesan lagi? Y/N
y
1. MENU BURGER
2. MENU ADDITION

choose :2
1. Lemon Tea
2. French Fries
3. Chicken Nugget
4. King Fushion
5. Ketchup
6. Air Mineral
PILIH MENU ADDITION
Choose : 3
Jumlah : 1
Your Addition   : Chicken Nugget
Harga/pc        : Rp. 15.000
Total           : Rp. 15.000
Apa ingin memesan lagi? Y/N
n
Total pembelian : Rp. 55.000
Uang Anda : 100.000
Kembalian : Rp 45.000
Payment Success!
Thanks for coming

CONTOH 2 :
==SELAMAT DATANG DI BURGER KING
1. MENU BURGER
2. MENU ADDITION

choose :2
1. Lemon Tea
2. French Fries
3. Chicken Nugget
4. King Fushion
5. Ketchup
6. Air Mineral
PILIH MENU ADDITION
Choose : 6
Jumlah : 1
Your Addition   : Air Mineral
Harga/pc        : Rp. 3.000
Total           : Rp. 3.000
Apa ingin memesan lagi? Y/N
y
1. MENU BURGER
2. MENU ADDITION

choose :1
Pilih Menu Burger
1. Cheese Burger
2. Beef Burger
3. Chicken Burger
Pilih Menu Burger : 3
Jumlah : 2
Your Burger     : Chicken Burger
Harga/pc        : Rp. 25.000
Total           : Rp. 50.000
Apa ingin memesan lagi? Y/N
n
Total pembelian : Rp. 53.000
Uang Anda : 50.000
Tidak Cukup Uangta Bos

Uang Anda : 53.000
Payment Success!
Thanks for coming

$$ Bagian dari project anda yang menerapkan konsep object oriented $$
1. Penerapan Object dan Class (Class seperti Burger.java, Addition.java, dll. Sedangkan Objek yang memiliki attribute dan behaviour seperti jenis, jumlah, harga)
2. Penerapan Access Modifier seperti private dan Constructor pada class Burger dan Addition
3. Penerapan Inheritance pada superclass (Burger dan Addition) dan subclass (Chicken Burger, Beef Burger, Ceese Burger, dll.)
4. Penerapan Super dan Overriding pada subclass
5. Penerapan Polymorphism dan Abstract Class
