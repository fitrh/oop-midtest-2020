package com.bankingsystem.database;

import com.bankingsystem.transactionlog.*;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Database {
    private static Database database = null;
    private final ArrayList<Bank> banks = new ArrayList<>();
    private final ArrayList<String> errorLog = new ArrayList<>();
    private Database() throws IOException {
        putBanks();
    }

    protected static Database getInstance() {
        try {
            if (database == null) {
                database = new Database();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return database;
    }

    //This takes local data of banks, and its respective customers and saves to memory
    private void putBanks() throws IOException {
        String[] bankNames = {"BNI","BRI","BTN","MANDIRI"};
        for (String bank : bankNames) {
            BufferedReader br;
            int bankCode = 0;
            HashSet<Integer> registeredKTP = new HashSet<>();
            String bankName = null;
            br = new BufferedReader(new FileReader(String.format("Banks/%s/info.txt", bank)));
            String[] data = null;

            try {
                //Bank data
                data = br.readLine().split(";");
                bankName = data[0];
                bankCode = Integer.parseInt(data[1]);
            } catch (Exception e) {
                errorLog.add(String.format("%s is corrupted", bank));
            }

            HashMap<Integer , Customer> customers = new HashMap<>();
            File folder = new File(String.format("Banks/%s/Customers", bank));
            File[] listOfFiles = folder.listFiles();

            //find customer data in customers folder
            assert listOfFiles != null;
            for (File file : listOfFiles) {
                try {
                    if (file.isFile() && !file.getName().equals(".DS_Store")) {
                        br = new BufferedReader(new FileReader(file));
                        if (br.ready()) {
                            data = br.readLine().split(";");
                        }
                        int money = 0;
                        ArrayList<Transaction> transactionLog = new ArrayList<>();
                        SimpleDateFormat formatter = new SimpleDateFormat("EEE d MMM yyyy HH:mm:ss z");
                        while (br.ready()) {
                            //add transaction log
                            String[] temp = br.readLine().split(";");
                            if (Integer.parseInt(temp[0]) == 0) {
                                //Deposit
                                transactionLog.add(new Deposit(formatter.parse(temp[1]), Integer.parseInt(temp[2])));
                                money += Integer.parseInt(temp[2]);
                            } else if (Integer.parseInt(temp[0]) == 1) {
                                //Withdrawal
                                transactionLog.add(new Withdrawal(formatter.parse(temp[1]), Integer.parseInt(temp[2])));
                                money -= Integer.parseInt(temp[2]);
                            } else if (Integer.parseInt(temp[0]) == 2) {
                                //Outbound transfer
                                transactionLog.add(new OutboundTransfer(formatter.parse(temp[1]), Integer.parseInt(temp[2]), Integer.parseInt(temp[3])));
                                money -= Integer.parseInt(temp[2]);
                            } else if (Integer.parseInt(temp[0]) == 3) {
                                //Inbound transfer
                                transactionLog.add(new InboundTransfer(formatter.parse(temp[1]), Integer.parseInt(temp[2]), Integer.parseInt(temp[3])));
                                money += Integer.parseInt(temp[2]);
                            }
                        }
                        assert data != null;
                        //create customer with the format (user name, password, accountNumber, KTP number)
                        Customer customer = new Customer(data[0], data[1].toCharArray(), Integer.parseInt(data[2]), Integer.parseInt(data[3]), transactionLog, money, bankName);
                        customers.put(Integer.parseInt(data[2]),customer);
                        registeredKTP.add(Integer.parseInt(data[3]));
                        data = null;
                        br.close();
                    }
                } catch (Exception e) {
                    errorLog.add(String.format("%s is corrupted\n", file.getName()));
                }
            }
            banks.add(new Bank(bankName, bankCode, customers, registeredKTP));

        }

    }

    protected void updateUserPassword(String password, String destination) {
        BufferedReader br = null;
        BufferedWriter bw = null;
        String[] data = null;
        String updatedData;
        try {
            br = new BufferedReader(new FileReader(destination));
            if (br.ready()) {
                data = br.readLine().split(";");
            }
            assert data != null;
            //Change password data
            data[1] = password;
            updatedData = String.join(";", data);
            bw = new BufferedWriter(new FileWriter(destination));
            bw.append(updatedData);

            //rewrite transaction log to file
            while (br.ready()) {
                bw.append("\n").append(br.readLine());
            }
        } catch (IOException e) {
            System.out.println("Error in updating file!");
        } finally {
            try {
                assert bw != null;
                bw.close();
                br.close();
            } catch (IOException ignore) {

            }
        }
    }

    protected void updateData(String data, String destination, Boolean append) {
        try (FileWriter fw = new FileWriter(destination, append); BufferedWriter bw = new BufferedWriter(fw)) {
            if (append) {
                //appends data with a new line
                bw.append("\n").append(data);
            } else {
                //rewrites data
                bw.write(data);
            }
        } catch (IOException e) {
            System.out.println("Data not saved!");
            e.printStackTrace();
        }

    }

    protected Bank getBank(int index) {
        return banks.get(index);
    }
    protected ArrayList<Bank> getBanks() {
        return banks;
    }
    protected void printErrorLog() {
        //Prints error log to console
        if (errorLog.size() > 0) {
            System.out.print("\u001b[31m");
            System.out.println("Errors : ");
            for (String error:
                 errorLog) {
                System.out.println(error);
            }
            System.out.print("\u001b[0m");

        }

    }

}
