# :bank: Banking System :bank:

---

**Created By	:** Arsyi Syarief Aziz
**Student Id	:** H071191003
**Project Type	:** Banking System

## Quick Guide :innocent:

---

1. [English](#english)
   1. [How to run](#how-to-run)
   2. [Concepts used](#concepts-used)
   3. [Login Details](#login-details-en)
   4. [FAQ](#faq-en)
   
2. [Bahasa Indonesia](#bahasa-indonesia)
   1. [Cara menjalankan](#cara-menjalankan)
   2. [Konsep yang digunakan](#konsep-yang-digunakan)
   3. [Login Details](#login-details-id)
   4. [FAQ](#faq-id)


---

## English

### How to run 

1. **Clone** this repository

2. **Open** terminal

3. In terminal, move to the following folder ***out/production/Banking_System***

4. **Run** the following command

   ```
   java com.bankingsystem.Main
   ```

5. This will appear

   <p align="center"><img src="assets/Screen Shot 2020-03-28 at 9.28.11 pm.png" alt="Class Diagram" title="Class Diagram"></p>

### Concepts used

1. **Class & Object**

2. **Inheritance**

   All classes in the package **com.bankingsystem.transactionlog** implements encapsulation

   | Type            | Class Name                                                   |
   | --------------- | ------------------------------------------------------------ |
   | **Super Class** | Transaction                                                  |
   | **Subclass**    | Deposit<br />InboundTransfer<br />OutboundTransfer<br />Withdrawal |

3. **Encapsulation**

   All classes in the packages **com.bankingsystem.database** and **com.bankingsystem.transactionlog** implements encapsulation

4. **Abstraction**

   This consept can be seen in the **com.bankingsystem.transactionlog** package, where the **Transaction.java** is an abstract class

5. **Polymorphism**

   This consept can be seen in the **printTransactionLog()** method of the **Portal** class (line 141-187)

### Login details-en

These are the login details to the pre-made accounts

|  No  |  Bank   |        Name        | Account Number |  Password  |
| :--: | :-----: | :----------------: | :------------: | :--------: |
|  1   |   BNI   | Arsyi Syarief Aziz |    1000001     | H071191003 |
|  2   |   BNI   |    Lorem Ipsum     |    1000002     |   123456   |
|  3   |   BRI   | Arsyi Syarief Aziz |    2000001     | H071191003 |
|  4   |   BTN   | Arsyi Syarief Aziz |    3000001     | H071191003 |
|  5   | MANDIRI | Arsyi Syarief Aziz |    4000001     | H071191003 |

 ### FAQ-en

1. <u>**Why did you use java.io not java.nio?**</u>

   Because I couldn't figure out how to read the data of all the files in a given folder. The solution I used can be seen in the Database class *(line 53-94)*

2. <u>**Did you use an IDE?**</u>

   ​	Yes I did, I use IntelliJ IDEA 

3. <u>**What is the format for a customer.txt and a info.txt file?**</u>

   **customer.txt**

   ​	**First line :** name;password;account number;ktpnumber

   ​	**Lines proceeding first line (Transaction Log):** 

   ​		type of transaction;date; amount;destination/origin of transaction

   **info.txt**

   ​	bank name;bank code

4. <u>**How will the user navigate the program?**</u>

   First, the portal will display the list of banks that the user can choose form. After the user has input their choice, the user will then have the choice of logging in to an existing account or registering a new account. 

   1. If the user chooses to login to their account, they will be prompted to input their account number and password. If the login details of the user is correct, the user will have the choice of picking from 7 user actions, namely: deposit, withdraw, transfer, balance, transaction history, change password and logout.

      1. <u>Deposit</u>

         The user will be asked to input the amount of money they want deposit into their account 

      2. <u>Withdraw</u>

         The user will be asked to input the amount of money they want withdraw from their account 

      3. <u>Transfer</u>

         The user will first be asked to input the bank code the bank code of the target account, and it's account code. When this has successfully been inputted, the user will be asked to input the amount of money to transfered

      4. <u>Balance</u>

         The user will see the amount of money left in their account

      5. <u>Transaction history</u>

         The user will see their transaction history divided into pages consisting of 2 transactions per page

      6. <u>Change password</u>

         The user will be asked to re-input their password, then input their new password

      7. <u>Logout</u>

         De-authenticates user

   2. If the user chooses to register, the user will first be prompted to input their KTP number. This is used to make sure there is only one account per user per bank. After the user has inputted a valid KTP, they will then be asked to input their name and password. When all of this has successfully been inputed, then the user will recieve an overview of their newly registered account with the users details.

5. <u>**What did you use to take input from the user and why?**</u>

   I used the **java.io.Console** because i needed a way to read the user's password without revealing what the person has just typed in

6. <u>**What would you like to improve in the future**</u>

   What I would like to improve in the future is to improve the IO and the overall cleanliness of my code

   

---

## Bahasa Indonesia

### Cara menjalankan

1. **Clone** repository ini

2. **Buka** terminal

3. Dalam terminal, pindah ke folder berikut ***out/production/Banking_System***

4. **Jalankan** command sebagai berikut

   ```
   java com.bankingsystem.Main
   ```

5. Berikut akan muncul

      <p align="center"><img src="assets/Screen Shot 2020-03-28 at 9.28.11 pm.png" alt="Class Diagram" title="Class Diagram"></p>

### Konsep yang digunakan

1. **Class & Object**

2. **Inheritance**

   Semua class dalam package **com.bankingsystem.transactionlog** mengimplementasikan inheritance

   | Tipe        | Nama Class                                                   |
   | ----------- | ------------------------------------------------------------ |
   | Super Class | Transaction                                                  |
   | Sub Class   | Deposit<br />InboundTransfer<br />OutboundTransfer<br />Withdrawal |

3. **Encapsulation**

   Semua class dalam package **com.bankingsystem.database** dan **com.bankingsystem.transactionlog** mengimplementasikan encapsulation

4. **Abstraction**

   Konsep ini dapat dilihat pada package **com.bankingsystem.transactionlog**, dimana **Transaction.java** adalah abstract class

5. **Polymorphism**

   Konsep ini dapat dilihat di method **printTransactionLog()** dari class **Portal** (baris 141-187)

### Login details-id

Berikut adalah *login details* dari akun yang telah dibuat

|  No  |  Bank   |        Nama        | Nomor Akun |  Password  |
| :--: | :-----: | :----------------: | :--------: | :--------: |
|  1   |   BNI   | Arsyi Syarief Aziz |  1000001   | H071191003 |
|  2   |   BNI   |    Lorem Ipsum     |  1000002   |   123456   |
|  3   |   BRI   | Arsyi Syarief Aziz |  2000001   | H071191003 |
|  4   |   BTN   | Arsyi Syarief Aziz |  3000001   | H071191003 |
|  5   | MANDIRI | Arsyi Syarief Aziz |  4000001   | H071191003 |

 ### FAQ-id

1. <u>**Kenapa Anda menggunakan java.io, bukan java.nio**</u>

   Karena saya tidak temukan cara untuk membaca data dari semua file yang berada dalam suatu *folder*. Solusi yang saya gunakan dapat dilihat di Kelas Database *(baris 53-94)*

2. <u>**Apakah Anda menggunakan IDE**</u>

   ​	Iya, saya menggunakan IntelliJ IDEA 

3. <u>**Apa format yang digunakan untuk file customer.txt dan info.txt**</u>

   **customer.txt**

   ​	**Baris pertama :** nama;kata sandi;nomor akun;nomor ktp

   ​	**Barisan setelah baris pertama (Transaction Log):** 

   ​		jenis transaksi;tanggal;jumlah;destinasi/sumber of transaksi

   **info.txt**

   ​	nama bank;kode bank

4. <u>**Bagaimana user menggunakan program ini?**</u>

   1. Pertama, portal akan memunculkan semua bank yang dapat dipilih oleh user. Setelah user telah menginput pilihannya, user dapat memilih untuk login ke akun yang sudah ada atau register akun baru. 

      1. Jika user memilih untuk login ke akun mereka, maka user akan disuruh untuk input nomor akun dan passwordnya. Jika *login details* dari user sudah benar, maka user akan diberi 7 hal yang dapat dilakukan oleh user, yaitu: deposit, withdraw, transfer, balance, transaction history, change passoword, dan logout.

         1. <u>Deposit</u>

            User akan diminta untuk input jumlah uang yang ingin ditabung kedalam akun mereka 

         2. <u>Withdraw</u>

            User akan diminta untuk input jumlah uang yang ingin ditarik dari akun mereka

         3. <u>Transfer</u>

            Pertama, user akan diminta untuk input kode bank dari akun yang ingin ditransfer dan nomor akunnya. Jika hal ini telah diiput dengan benar, user akan diminta untuk input jumlah uang yang ingin ditransfer

         4. <u>Balance</u>

            User akan melihat jumlah uang yang tersisa dalam akunnya

         5. <u>Transaction history</u>

            User akan melihat riwayat transaksi yang dibagi kedalam 2 transaksi per halaman

         6. <u>Change password</u>

            User akan diminta untuk input ulang passwordnya, dan berikutnya password baru yang diinginkan|

         7. <u>Logout</u>

            De-autentikasi user

      2. Jika user memilih untuk register, pertama, user akan diminta untuk input nomor KTPnya. Hal ini digunakan untuk memastikan bahwa hanya terdapat satu akun per orang per bank. Setelah user telah menginput nomor KTP yang benar, user akan diminta untuk input nama dan password yang diinginkan. Setelah semua ini telah di input dengan benar, maka user akan mendapatkan rincian dari akun yang telah dibuat.

5. <u>**Apa yang Anda gunakan untuk mengambil input dari user dan mengapa?***</u>

   Saya menggunakan **java.io.Console** karena saya membutuhkan cara untuk membaca password dari user tanpa menunjukkan apa yang telah diketik oleh user

6. **<u>Apa yang ingin Anda perbaiki kedepannya</u>**

   Yang ingin saya perbaiki adalah IO dan kebersihan dari kode saya

   

   

   

   









