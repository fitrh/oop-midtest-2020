public class Addition{
    
    public String name;
    public double price;
    public int piece;

    double sum() {
        return price * piece;
    }

    void showStatus() {
        System.out.print(name+"\t");
        System.out.printf("Rp %.3f\tx%d\t", price, piece);
        System.out.printf("Rp %.3f\n", sum());
    }
}

class Cola extends Burger {

    Cola(int piece) {
        this.name = "Cola";
        this.price = 6;
        this.piece = piece;
    }

    @Override
    double sum() {
        return super.sum();
    }

    @Override
    void showStatus() {
        super.showStatus();
    }
}

class Sprite extends Burger {

    Sprite(int piece) {
        this.name = "Sprite";
        this.price = 6;
        this.piece = piece;
    }

    @Override
    double sum() {
        return super.sum();
    }

    @Override
    void showStatus() {
        super.showStatus();
    }
}

class Fanta extends Burger {

    Fanta(int piece) {
        this.name = "Fanta";
        this.price = 6;
        this.piece = piece;
    }

    @Override
    double sum() {
        return super.sum();
    }

    @Override
    void showStatus() {
        super.showStatus();
    }
}

class Potato extends Burger {

    Potato(int piece) {
        this.name = "Potato";
        this.price = 11;
        this.piece = piece;
    }

    @Override
    double sum() {
        return super.sum();
    }

    @Override
    void showStatus() {
        super.showStatus();
    }
}

class Tomato extends Burger {

    Tomato(int piece) {
        this.name = "Tomato";
        this.price = 0;
        this.piece = piece;
    }

    @Override
    void showStatus() {
        System.out.print(name+"\t");
        System.out.printf("Rp 0.\tx%d\t" , piece);
        System.out.println("Rp 0.");
    }
}

class Ketchup extends Burger {

    Ketchup(int piece) {
        this.name = "Ketchup";
        this.price = 0;
        this.piece = piece;
    }

    @Override
    void showStatus() {
        System.out.print(name+"\t");
        System.out.printf("Rp 0.\tx%d\t" , piece);
        System.out.println("Rp 0.");
    } 
}

class AirMineral extends Burger {

    AirMineral(int piece) {
        this.name = "Air Mineral";
        this.price = 7;
        this.piece = piece;
    }

    @Override
    double sum() {
        return super.sum();
    }

    @Override
    void showStatus() {
        super.showStatus();
    }
}

class IcedLemon extends Burger {

    IcedLemon(int piece) {
        this.name = "Iced Lemon";
        this.price = 9;
        this.piece = piece;
    }

    @Override
    double sum() {
        return super.sum();
    }

    @Override
    void showStatus() {
        super.showStatus();
    }
}

class OrangeJuice extends Burger {

    OrangeJuice(int piece) {
        this.name = "Orange Juice";
        this.price = 11;
        this.piece = piece;
    }

    @Override
    double sum() {
        return super.sum();
    }

    @Override
    void showStatus() {
        super.showStatus();
    }
}

class SundaeChocolate extends Burger {

    SundaeChocolate(int piece) {
        this.name = "Sundae Chocolate";
        this.price = 6;
        this.piece = piece;
    }

    @Override
    double sum() {
        return super.sum();
    }

    @Override
    void showStatus() {
        super.showStatus();
    }
}

class SundaeStrawberry extends Burger {

    SundaeStrawberry(int piece) {
        this.name = "Sundae Strawberry";
        this.price = 6;
        this.piece = piece;
    }

    @Override
    double sum() {
        return super.sum();
    }

    @Override
    void showStatus() {
        super.showStatus();
    }
}