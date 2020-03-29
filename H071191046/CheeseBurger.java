class CheeseBurger extends Burger {
    public CheeseBurger() {
        super(jenis, jumlah, harga);
        jenis = "Cheese Burger";
        harga = 20;
    }
    @Override
    public void showStatus() {
        super.showStatus();
    }
}