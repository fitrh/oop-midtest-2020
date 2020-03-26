public class Burger {

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

class ChickenMuffin extends Burger {

    ChickenMuffin(int piece) {
        this.name = "Chicken Muffin";
        this.price = 25;
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

class BeefBurger extends Burger {

    BeefBurger(int piece) {
        name = "Beef Burger";
        price = 28;
        this.piece = piece;
        ;
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

class TripleBurger extends Burger {

    TripleBurger(int piece) {
        name = "Triple Burger";
        price = 40;
        this.piece = piece;
        ;
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

class BigMac extends Burger {

    BigMac(int piece) {
        name = "Big Mac";
        price = 38;
        this.piece = piece;
        ;
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

class CheeseBurger extends Burger {

    CheeseBurger(int piece) {
        name = "Cheese Burger";
        price = 31;
        this.piece = piece;
        ;
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

class ChickenBurger extends Burger {

    ChickenBurger(int piece) {
        name = "Chicken Burger";
        price = 28;
        this.piece = piece;
        ;
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