class ChickenNugget extends Addition {
    public ChickenNugget() {
        super(jenis, jumlah, harga);
        jenis = "Chicken Nugget";
        harga = 15;
    }
    @Override
    public void showStatus() {
        super.showStatus();
    }
    @Override
    public void setJenis(String jenis) {
    }

    @Override
    public String getJenis() {
        return null;
    }

    @Override
    public void setJumlah(int jumlah) {
    }

    @Override
    public int getJumlah() {
        return 0;
    }

    @Override
    public void setHarga(double harga) {
    }

    @Override
    public double getHarga() {
        return 0;
    }
}