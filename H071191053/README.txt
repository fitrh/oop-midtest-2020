Item Store Console 

	Spesifikasi
		pertama-tama saya membuat class-class yang di perlukan dalam
		kasus ini yaitu User,Store,Item. saya menggunakan constructor
		untuk semua class tersebut. saya juga mengggunakan cara alternativ
		untuk menambah kan item menggunakan java.nio
	class user memiliki atribut name, money, dan Item list( array lsit )
	class Store memiliki atribut store owner dan item list( array list )
	class item memiliki atribut price, quantity, dan detail		

	jadi prosesnya saya akan membuat simulasi toko sederhana dimana
terdiri dari dua role yaitu player dan store owner. player adalah org yg 
berperan sebagai pelanggan namun ia juga bisa menjual barang-barang nya
store owner adalh org yg mempunyai toko namun ia juga mempunyai barang pribadi dan bisa menjual nya
store dari store owner memiliki juga item list yg berbeda dari item list owner, semua barang yang di beli di store uangnya akan masuk ke store owner nya
saya mengisi list Item dari ketiga class tersebut melalui file txt menggunakan package java.nio
saya telah membuat tiga file .txt untuk mengisi list item masing
dengan format
---------------------------------------------------
KETERANGAN:	HARGA ITEM;JUMLAH ITEM;DETAIL ITEM
TIPE DATA :	DOUBLE    ;INT        ;STRING
---------------------------------------------------

dan juga jika kalian ingin menggunakan programnya pastikan directory yg ada pada code sama dengan directory ketiga file tersebut
directorynya bisa diubah sesuai keperluan

apabila semua sudah siap jalankan programnya
- pertama-tama adalah pembuatan semua role
	jadi program akan membuat object diatas berdasarkan data yg dimasukkan
	ex: player name, store dan store ownernya, dan lain-lain
- selanjutnya saya membuat hash map untuk meyimpan item dari role masing-masing
	tujuannya supaya lebih gampang dipanggil untuk kedepannya
-setelah itu saya membuat perulangan dan pengkondisian untuk memainkan peran tersebut
	perulanga pertama berisi switch case yang menentukan siapa yang kita mainkan(store owner or player)
	setelah memilih itu lanjut ke perulangan ke-2 yakni untuk melakukan aksi-aksi yg di butuhkan
	ex: buy, sell, show item, dan lain-lain
- kalian bisa keluar dari pengulangan dengan menggunakan opsi dan memilih yg "0" atau degan cara menekan ctrl + c
