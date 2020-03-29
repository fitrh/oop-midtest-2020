class BeefBurger extends Burger {
    public BeefBurger() {
        super(jenis, jumlah, harga);
        jenis = "Beef Burger";
        harga = 30;
    }
    @Override
    public void showStatus() {
        super.showStatus();
    }
}