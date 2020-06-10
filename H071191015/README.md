### Spesifikasi Project
- Sistem untuk mencatat jadwal kegiatan yang akan dilakukan
- Daftar kegiatan dimiliki oleh satu User
- Setiap kegiatan memiliki deskripsi
- Setiap kegiatan memiliki jadwal mulai dan jadwal selesai
- Setiap kegiatan memiliki status selesai, sedang dikerjakan, dan belum dikerjakan
- Setiap kegiatan memiliki prioritas
- User hanya dapat melihat daftar kegiatan yang dibuatnya
- User dapat menampilkan daftar kegiatan berdasarkan jadwal, prioritas, atau status
- User dapat menghapus dan menambah kegiatan 

### Alur Kerja
- Menjalankan program dengan run file Main class
- Setelah berhasil dijalankan maka akan muncul tampilan menu untuk login atau close program. 
- Ketika memilih untuk login maka akan diminta untuk menginput usernama dan password. Untuk username dan password sudah diatur terlebih dahulu dalam program.
- Ketika memilih untuk close maka program akan berhenti.
- Saat berhasil login maka akan muncul tampilan menu untuk melihat jadwal kegiatan, menambah jadwal kegiatan, menghapus jadwal kegiatan, atau keluar akun.
- Jika memilih lihat to do list maka akan menampilkan isi dari kegiatan. Jadi akan menampilkan kegiatan-kegiatan yang sudah ditambahkan.
- Jika memilih untuk tambah to do list maka akan diminta untuk menginput nama kegiatan, deskripsi, jadwal mulai, jadwal selesai, status, dan skala prioritas. Hasil inputan akan disimpan dalam sebuah file .txt.
- Jika memilih untuk hapus to do list maka akan tampil isi dari to do list kemudian memilih index keberapa yang akan dihapus. Kemudian akan memastikan apakah yakin untuk menghapus list tersebut jika yakin maka pilih y jika tidak maka pilih t. Jika pilih y maka list tersebut akan dihapus dari daftar dan file. Jika pilih t maka akan kembali pada menu sebelumnya.
- Jika memilih untk keluar akun maka program akan keluar.
- Setiap user memiliki jadwal kegiatan berbeda yang disimpan dalam file berbeda.

### Contoh input-output, jika ada
- Untuk contoh input-output nya tergantung dari usernya masing-masing mau menginput apa maka outputnya juga akan keluar seperti itu.

### Bagian yang menerapkan konsep object oriented
- Menerapkan object dan class seperti object user, user2, user3, object Todolist sedangkan classnya yang berbentuk file.java
- Menerapkan attribut, behaviour, dan constructor. Jadi class User, class Todolist memiliki attribut yang bersifat private. Untuk behaviour dari class User dan class Todolist menerapkan method Setter dan Getter. Dan class User dan class Todolist memiliki constructor yang memiliki parameter.
- Menerapkan encapsulation dengan memberikan access modifier seperti private untuk attribut dan public untuk method setter,getter, dan method void.
- Menerapkan inheritance jadi user2 mewarisi user dan user3 mewarisi user.
- Menerapkan Polymorphism jadi subclass akan override sebuah method dari superclassnya kemudian 
- Tidak menerapkan abstract class dan interface


### Hal-hal yang ingin diimprove kedepannya
- Memperbaiki struktur program dan mempersingkat kode
- Memperbarui programnya.