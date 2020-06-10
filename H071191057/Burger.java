public abstract class Burger {

	protected String name;
    protected double price;
    protected double sum;

    public abstract void setName(String name);
    public abstract void setPrice(double price);
    public abstract void setSum(double sum);

    public abstract String getName();
    public abstract double getPrice();
    public abstract double getSum();
}

class ChickenMuffin extends Burger {

    private int piece;

    ChickenMuffin(int piece) {
        super.name = "Chicken Muffin";
        super.price = 25;
        this.piece = piece;
        super.sum = price * piece;
    }
    public void setPiece(int piece){
        this.piece = piece;
    }
    public int getPiece(){
        return piece;
    }
    @Override
    public void setName(String name) {
        super.name = name;
    }
    @Override
    public void setPrice(double price) {
        super.price = price;
    }
    @Override
    public void setSum(double sum) {
        super.sum = sum;
    }
    @Override
    public String getName() {
        return super.name;
    }
    @Override
    public double getPrice() {
        return super.price;
    }
    @Override
    public double getSum() {
        return super.sum;
    }
}

class BeefBurger extends Burger {

    private int piece;

    BeefBurger(int piece) {
        super.name = "Beef Burger";
        super.price = 28;
        this.piece = piece;
        super.sum = price * piece;
    }

    public void setPiece(int piece){
        this.piece = piece;
    }
    public int getPiece(){
        return piece;
    }

    @Override
    public void setName(String name) {
        super.name = name;
    }
    @Override
    public void setPrice(double price) {
        super.price = price;
    }
    @Override
    public void setSum(double sum) {
        super.sum = sum;
    }
    @Override
    public String getName() {
        return super.name;
    }
    @Override
    public double getPrice() {
        return super.price;
    }
    @Override
    public double getSum() {
        return super.sum;
    }
}

class TripleBurger extends Burger {

    private int piece;

    TripleBurger(int piece) {
        super.name = "Triple Burger";
        super.price = 40;
        this.piece = piece;
        super.sum = price * piece;
    }

    public void setPiece(int piece){
        this.piece = piece;
    }
    public int getPiece(){
        return piece;
    }

    @Override
    public void setName(String name) {
        super.name = name;
    }
    @Override
    public void setPrice(double price) {
        super.price = price;
    }
    @Override
    public void setSum(double sum) {
        super.sum = sum;
    }
    @Override
    public String getName() {
        return super.name;
    }
    @Override
    public double getPrice() {
        return super.price;
    }
    @Override
    public double getSum() {
        return super.sum;
    }
}

class BigMac extends Burger {

    private int piece;

    BigMac(int piece) {
        super.name = "Big Mac";
        super.price = 38;
        this.piece = piece;
        super.sum = price * piece;
    }

    public void setPiece(int piece){
        this.piece = piece;
    }
    public int getPiece(){
        return piece;
    }

    @Override
    public void setName(String name) {
        super.name = name;
    }
    @Override
    public void setPrice(double price) {
        super.price = price;
    }
    @Override
    public void setSum(double sum) {
        super.sum = sum;
    }
    @Override
    public String getName() {
        return super.name;
    }
    @Override
    public double getPrice() {
        return super.price;
    }
    @Override
    public double getSum() {
        return super.sum;
    }
}

class CheeseBurger extends Burger {

    private int piece;

    CheeseBurger(int piece) {
        super.name = "Cheese Burger";
        super.price = 31;
        this.piece = piece;
        super.sum = price * piece;
    }

    public void setPiece(int piece){
        this.piece = piece;
    }
    public int getPiece(){
        return piece;
    }

    @Override
    public void setName(String name) {
        super.name = name;
    }
    @Override
    public void setPrice(double price) {
        super.price = price;
    }
    @Override
    public void setSum(double sum) {
        super.sum = sum;
    }
    @Override
    public String getName() {
        return super.name;
    }
    @Override
    public double getPrice() {
        return super.price;
    }
    @Override
    public double getSum() {
        return super.sum;
    }
}

class ChickenBurger extends Burger {

    private int piece;

    ChickenBurger(int piece) {
        super.name = "Chicken Burger";
        super.price = 28;
        this.piece = piece;
        super.sum = price * piece;
    }

    public void setPiece(int piece){
        this.piece = piece;
    }
    public int getPiece(){
        return piece;
    }

    @Override
    public void setName(String name) {
        super.name = name;
    }
    @Override
    public void setPrice(double price) {
        super.price = price;
    }
    @Override
    public void setSum(double sum) {
        super.sum = sum;
    }
    @Override
    public String getName() {
        return super.name;
    }
    @Override
    public double getPrice() {
        return super.price;
    }
    @Override
    public double getSum() {
        return super.sum;
    }
}