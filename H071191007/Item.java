class Item {
    private int price;
    private int quantity;
    private String detail;
    private String name;

public Item(int price, int quantity, String detail, String name) {
    this.price = price;
    this.quantity = quantity;
    this.detail = detail;
    this.name = name;
}
    public void descItem() {
        System.out.println(getPrice());
        System.out.println(getQuantity());
        System.out.println(getDetail());
        System.out.println(getName());
    }

    public void setHarga(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return this.price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public String getDetail() {
        return this.detail;
    }
    public String getName() {
        return this.name;
    }
}