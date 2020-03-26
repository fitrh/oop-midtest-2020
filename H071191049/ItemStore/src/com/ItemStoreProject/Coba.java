package com.ItemStoreProject;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Coba {
    private String baca(String namaFile) throws Exception {
        Path path = Paths.get("src/com/ItemStoreProject/Akun.txt");
        String fileContent = new String(Files.readAllBytes(path.toAbsolutePath()));
        return fileContent;
    }
    public void CobaAja() throws Exception {
        System.out.print(baca("Akun.txt"));
    }
}
class Mainly{
    public static void main(String[] args) throws Exception {
            Coba coba = new Coba();
            coba.CobaAja();
    }
}