class ChickenBurger extends Burger {
    public ChickenBurger() {
        super(jenis, jumlah, harga);
        jenis = "Chicken Burger";
        harga = 25;
    }
    @Override
    public void showStatus() {
        super.showStatus();
    }
    
}