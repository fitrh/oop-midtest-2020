package app;

public class Animal{
    public void sound(){
        System.out.println("Anmal making sound");
    }
}
class Horse extends Animal{
    @Override
    public void sound(){
        System.out.println("Neigh");
    }
}
class Run{
    public static void main(String[] args) {
        Animal a = new Horse();
        a.sound();
    }
}