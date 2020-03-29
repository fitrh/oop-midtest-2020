package app;
class Item{
    private String name;
    private int price;
    private int kuantitas;
    private String info;
    private int id;

    //Konstruktor Item
    Item(int id, String name, int price, int kuantitas ,String info){
        this.name = name;
        this.price = price;
        this.kuantitas = kuantitas;
        this.info = info;
        this.id = id;
    }

    //getter
    public String getName(){
        return name;
    }
    public String getInfo(){
        return info;
    }
    public int getPrice(){
        return price;
    }
    public int getKuantitas(){
        return kuantitas;
    }
    public int getId(){
        return id;
    }

    //setter
    public void setKuantitas(int kuantitas){
        this.kuantitas = kuantitas;
    }
}