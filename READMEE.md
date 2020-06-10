Ketika kita membangun proyek aplikasi Java yang memiliki kelas utama, IDE
secara otomatis menyalin semua JAR
file pada classpath proyek ke folder dist / lib proyek Anda. IDE
juga menambahkan masing-masing file JAR ke elemen Class-Path dalam aplikasi
File JAR file manifes (MANIFEST.MF).

Untuk menjalankan proyek dari baris perintah, buka folder dist dan
ketik berikut ini:

java -jar "AtmGUI.jar"

Untuk mendistribusikan proyek ini, zip folder dist (termasuk folder lib)
dan mendistribusikan file ZIP.

Catatan:

* Jika dua file JAR pada classpath proyek memiliki nama yang sama, hanya yang pertama
File JAR disalin ke folder lib.
* Hanya file JAR yang disalin ke folder lib.
Jika classpath berisi jenis file atau folder lain, file-file ini (folder)
tidak disalin.
* Jika perpustakaan pada proyek classpath juga memiliki elemen Class-Path
ditentukan dalam manifes, konten elemen Class-Path harus di
jalur runtime proyek.
* Untuk mengatur kelas utama dalam proyek Java standar, klik kanan node proyek
di jendela Projects dan pilih Properties. Kemudian klik Jalankan dan masukkan
nama kelas di bidang Kelas Utama. Atau, Anda dapat mengetik secara manual
nama kelas dalam elemen Utama-Kelas manifes.
