package com.bankingsystem.database;

import com.bankingsystem.transactionlog.*;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Database {
    private static Database database = null;
    private ArrayList<Bank> banks = new ArrayList<>();
    private ArrayList<String> errorLog = new ArrayList<>();
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

    private void updateUserData() {

    }

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
                data = br.readLine().split(";");
                bankName = data[0];
                bankCode = Integer.parseInt(data[1]);
            } catch (Exception e) {
                errorLog.add(String.format("%s is corrupted", bank));
            }

            HashMap<Integer , Customer> customers = new HashMap<>();
            File folder = new File(String.format("Banks/%s/Customers", bank));
            File[] listOfFiles = folder.listFiles();

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
                            String[] temp = br.readLine().split(";");
                            if (Integer.parseInt(temp[0]) == 0) {
                                transactionLog.add(new Deposit(formatter.parse(temp[1]), Integer.parseInt(temp[2])));
                                money += Integer.parseInt(temp[2]);
                            } else if (Integer.parseInt(temp[0]) == 1) {
                                transactionLog.add(new Withdrawal(formatter.parse(temp[1]), Integer.parseInt(temp[2])));
                                money -= Integer.parseInt(temp[2]);
                            } else if (Integer.parseInt(temp[0]) == 2) {
                                transactionLog.add(new OutboundTransfer(formatter.parse(temp[1]), Integer.parseInt(temp[2]), Integer.parseInt(temp[3])));
                                money -= Integer.parseInt(temp[2]);
                            } else if (Integer.parseInt(temp[0]) == 3) {
                                transactionLog.add(new InboundTransfer(formatter.parse(temp[1]), Integer.parseInt(temp[2]), Integer.parseInt(temp[3])));
                                money += Integer.parseInt(temp[2]);
                            }
                            temp = null;
                        }
                        assert data != null;
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

    protected void appendData(String data, String destination) {
        try (FileWriter fw = new FileWriter(destination, true); BufferedWriter bw = new BufferedWriter(fw)) {
            bw.append("\n"+data);
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
