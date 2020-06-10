Burger Store

    Spesifikasi
            awalnya saya membuat class super Burger yang berisi atribut rasa dan
        jumlah, dan 1 constructor yang memiliki isi rasa dan jumlah
            selanjutnya saya membuat dua class anakan yang mewarisi super classnya
        didalam class burgerSapi dan burgerNugget, saya menetapkan harga nya masing-masing
            setelah itu class Addition yang berisi menu tambahan saat memesan burger
        yang di tiap menunya saya sudah tetapkan harganya dan menerapkan materi pengkapsulan
            dan dalam class main berisi model dari menunya

    Disini saya membuat simulasi burger store sederhana
yang hanya memiliki 2 jenis burger, yaitu burger sapi dan burger nugget
dimana jika kita memilih burger sapi, maka kita akan diminta untuk memilih
ingin tambahan atau tidak, jika ya maka akan muncul menu tambahannya
yang terdiri dari drink(dimana drinkk hanya 1 jenis), saus, potato, tomato
di saat pilih salah satunya, kita dapat menambah sesuai keinginan kita
setelah itu kita masih dapat menambah tambahan lagi
    Jika proses pemesanan telah selesai, maka akan tercetak burger apa yang 
dipesan, harga burger, dan total dari harga tambahan dan harga burger


    Saya hanya menerapkan sampai inheritance dikarenakan saya berpikir
dalam program kali ini program ini tetap dapat jadi walaupun tidak menggunakan
materi abstrak - polymorphism, dan sebenarnya saya masih bingung dengan materi
abstrak - polymorphism

    Contoh input Outputnya :
    rasa sapi? nugget?
    sapi        //inputan
    jumlah pesanan?
    2       //inputan
    mau tambahan? y/n
    y       //inputan

    mau tambahan apa?
    1. drink
    2. saus
    3. potato
    4. tomato
    1       //inputan
    jumlah minuman ?
    2       //inputan
    masih ingin nambah minuman? y/n
    n       //inputan
    mau tambahan? y/n
    y       //inputan

    mau tambahan apa?
    1. drink
    2. saus
    3. potato
    4. tomato
    3       //inputan
    jumlah potato ?
    1       //inputan
    masih ingin nambah potato? y/n
    n       //inputan
    mau tambahan? y/n
    n       //inputan

    //output akhir
    anda memesan burger sapi
    total burger    : 2
    harga burger    : 36000
    total harga     : 48000