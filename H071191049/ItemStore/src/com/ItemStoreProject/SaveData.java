package com.ItemStoreProject;

public class SaveData extends Thread {
    public void run()
    {
        try
        {
            System.out.println("Proses ");
            for(int x = 0; x <= 15; x++)
            {
                System.out.print("-");
                Thread.sleep(100);
            }
            System.out.print("100%\n");
            System.out.println("SAVING DATA");
        }catch(Exception exc) {
        }
    }
}
