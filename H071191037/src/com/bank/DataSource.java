package com.bank;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataSource {

    private Map<String, Nasabah> nasabahMap = new HashMap<>();
    private Map<String, RekeningDetail> rekeningMap = new HashMap<>();
    private Map <Integer, NasabahDetail> nasabahDetailMap = new HashMap<>();
    protected ArrayList<String> transactionslog;


    String read(String fileName) throws IOException {
        FileReader reader = null;
        BufferedReader read = null;
        String tempString = "";
        try
        {
            reader = new FileReader(fileName);
            read = new BufferedReader(reader);

            String lineRead = "";
            while((lineRead = read.readLine()) != null)
            {
                tempString += lineRead + "\n";
            }
        }
        catch (IOException e)
        {
            System.out.println("error" + e.getMessage());
        }
        finally
        {
            try
            {
                if(reader != null)
                {
                    reader.close();
                }
                if(read != null)
                {
                    read.close();
                }
            }
            catch(IOException io)
            {
                System.out.println("unclosed");
            }
        }
        return tempString;
    }

    protected void putRekening(String fileName) throws IOException {
        String dataSplit[] = read(fileName).split("\n");
        for (int i = 0; i < dataSplit.length ; i++) {
            String nasabahData[] = dataSplit[i].split(";");
            String rekening = nasabahData[3];
            rekeningMap.put(rekening, new RekeningDetail(nasabahData[2],nasabahData[3],nasabahData[1]));
        }
    }

    protected void putNasabahDetail(String fileName) throws IOException {
        String dataSplit[] = read(fileName).split("\n");
        for (int i = 0; i < dataSplit.length ; i++) {
            String nasabahData[] = dataSplit[i].split(";");
            Integer id = Integer.parseInt(nasabahData[0]);
            Integer money = Integer.parseInt(nasabahData[6]);
            nasabahDetailMap.put(id, new NasabahDetail(id, money, nasabahData[1],nasabahData[2],nasabahData[3],nasabahData[4],nasabahData[5]));
        }
    }

    protected void  putDataNasabah(String fileName) throws IOException {
        String dataSplit[] = read(fileName).split("\n");

        for(int i = 0; i < dataSplit.length; i++)
        {
            String nasabahData[] = dataSplit[i].split(";");
            Integer id = Integer.parseInt(nasabahData[0]);
            nasabahMap.put(nasabahData[4], new Nasabah(id, nasabahData[4], nasabahData[5]));
        }
    }

    public void setTransactionslog(String data){
        transactionslog.add(data);
    }

    public ArrayList<String> getTransactionslog() {
        return transactionslog;
    }

    public RekeningDetail getRekening(String filename, String key) throws IOException {
        putRekening(filename);
        return rekeningMap.get(key);
    }

    public Nasabah getNasabahData(String fileName, String key) throws IOException {
        putDataNasabah(fileName);
        return nasabahMap.get(key);
    }

    public NasabahDetail getNasabahDetail(String fileName,Integer key) throws IOException {
        putNasabahDetail(fileName);
        return nasabahDetailMap.get(key);
    }
}
