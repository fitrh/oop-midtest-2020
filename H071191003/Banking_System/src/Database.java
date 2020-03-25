import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class Database {
    private static Database database = null;
    private ArrayList<Bank> banks = new ArrayList<>();
    private Database() {

    }
    public static Database getInstance() {
        if (database == null) {
            database = new Database();
        }
        return database;
    }

    public void putBanks() throws IOException {
        String[] bankNames = {"MANDIRI","BNI","BTN","BRI"};
        for (String name : bankNames) {
            BufferedReader br;
            int bankCode = 0;
            HashSet<Integer> registeredKTP = new HashSet<>();
            String bankName = null;
            br = new BufferedReader(new FileReader(String.format("/Banks/%s/info.txt", name)));
            String[] data = null;

            while (br.ready()) {
                data = br.readLine().split(";");
                bankName = data[0];
                bankCode = Integer.parseInt(data[1]);
            }

            ArrayList<Customer> customers = new ArrayList<>();
            File folder = new File(String.format("/Banks/%s/Customers", name));
            File[] listOfFiles = folder.listFiles();

            assert listOfFiles != null;
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    br = new BufferedReader(new FileReader(file));
                    while (br.ready()) {
                        data = br.readLine().split(";");
                    }
                    assert data != null;
                    customers.add(new Customer(data[0], data[1].toCharArray(), Integer.parseInt(data[2]), Integer.parseInt(data[3])));
                    registeredKTP.add(Integer.parseInt(data[3]));
                    data = null;
                    br.close();
                }
            }
            banks.add(new Bank(bankName, bankCode, customers, registeredKTP));
        }

    }

}
