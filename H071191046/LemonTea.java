class LemonTea extends Addition {
    public LemonTea() {
        super(jenis, jumlah, harga);
        jenis = "Lemon Tea";
        harga = 10;
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