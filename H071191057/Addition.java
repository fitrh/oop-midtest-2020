public abstract class Addition {

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

class Cola extends Addition {

    private int piece;

    Cola(int piece) {
        super.name = "Cola";
        super.price = 6;
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

class Sprite extends Addition {

    private int piece;

    Sprite(int piece) {
        super.name = "Sprite";
        super.price = 6;
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

class Fanta extends Addition {

    private int piece;

    Fanta(int piece) {
        super.name = "Fanta";
        super.price = 6;
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

class Potato extends Addition {

    private int piece;

    Potato(int piece) {
        super.name = "Potato";
        super.price = 11;
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

class Tomato extends Addition {

    private int piece;

    Tomato(int piece) {
        super.name = "Tomato";
        super.price = 0;
        this.piece = piece;
        super.sum = 0;
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

class Ketchup extends Addition {

    private int piece;

    Ketchup(int piece) {
        super.name = "Ketchup";
        super.price = 0;
        this.piece = piece;
        super.sum = 0;
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

class AirMineral extends Addition {

    private int piece;

    AirMineral(int piece) {
        super.name = "Air Mineral";
        super.price = 7;
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

class IcedLemon extends Addition {

    private int piece;

    IcedLemon(int piece) {
        super.name = "Iced Lemon";
        super.price = 9;
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

class OrangeJuice extends Addition {

    private int piece;

    OrangeJuice(int piece) {
        super.name = "Orange Juice";
        super.price = 11;
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

class SundaeChocolate extends Addition {

    private int piece;

    SundaeChocolate(int piece) {
        super.name = "Sundae Chocolate";
        super.price = 6;
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

class SundaeStrawberry extends Addition {

    private int piece;

    SundaeStrawberry(int piece) {
        super.name = "Sundae Strawberry";
        super.price = 6;
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