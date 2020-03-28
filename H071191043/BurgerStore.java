package app;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.StringTokenizer;

public class BurgerStore extends Cart{
    Cart c = new Cart();
	
	private float totalAmount1 = 0;
    private float totalAmount2 = 0;
    private float totalAmount3 = 0;
    private int OrderQuantity ;

    private float paymentAmount;
    private float changeMoney;

    Scanner sc = new Scanner(System.in);

    // instantiate ArrayList to hold burger objects
    ArrayList<Burger> burger = new ArrayList<Burger>();
    // instantiate ArrayList to hold addition objects
    ArrayList<Addition> addition = new ArrayList<Addition>();

    //method read file BurgerMenu
    public void readFileBurger(){
        try {
            Scanner file = new Scanner(new File("Burger.txt"));
            while (file.hasNext()){ //test for the end of the file
                //read a line
                String stringRead = file.nextLine();
                //process the line read
                StringTokenizer st = new StringTokenizer(stringRead,",");
                try {
                    int id = Integer.parseInt(st.nextToken());
                    String menu = st.nextToken();
                    int price = Integer.parseInt(st.nextToken());

                    Burger b = new Burger(id, menu, price);
                    //add Burger obj to burger
                    burger.add(b);
                }
                catch (NumberFormatException nfe){
                    System.out.println("Error in Burger : " + stringRead);
                }
            }
            //Release resources associated with Burger.txt
            file.close();
        }
        catch (FileNotFoundException fnfe){
            System.out.println("Unable to find Burger.txt");
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
    //method for return all Burger items
    public ArrayList<Burger> getItems(){
        return burger;
    }

    //method read file AdditionMenu
    public void readFileAddition(){
        try {
            Scanner file = new Scanner(new File("Addition.txt"));
            while (file.hasNext()){ //test for the end of the file
                //read a file
                String stringRead = file.nextLine();
                //procces the line read
                StringTokenizer st = new StringTokenizer(stringRead,",");
                try {
                    int id = Integer.parseInt(st.nextToken());
                    String menu = st.nextToken();
                    int price = Integer.parseInt(st.nextToken());
                    
                    Addition a = new Addition(id, menu, price);
                    //add Addition obj to addition
                    addition.add(a);
                }
                catch (NumberFormatException nfe){
                    System.out.println("Error in Addition : " + stringRead);
                }
            }
            //Release resources associated with Addition.txt
            file.close();
        }
        catch (FileNotFoundException fnfe){
            System.out.println("error");
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
    //method for return all Addition items
    public ArrayList<Addition> getAdditions(){
        return addition;
    }
    @Override //@Override from class Cart
    public void showMenuBurger() {
        System.out.println("=========================");
        System.out.println("Burger menu");
        System.out.println("=========================");
    }
    //method for print the Burger read
    public void showBurger(){
        for (Burger bm : getItems()){
            System.out.println(bm.getId() + ". " + bm.getMenu() + " : " + bm.getPrice());
        }
    }
    @Override //@Override from class Cart
    public void showMenuAddition() { 
        System.out.println("=========================");
        System.out.println("Addition menu");
        System.out.println("=========================");
    }
    //method for print the Addition read
    public void showAddition(){
        for (Addition addition : getAdditions()){
            System.out.println(addition.getId() + ". " + addition.getMenu() + " : " + addition.getPrice());
        }
    }
    //method for buy burger
	public void buyBurger(){
		System.out.println("\nORDER MENU");
		System.out.println("=========================");
        for (Burger menu : getItems()) {
            System.out.println("\nBURGER MENU");
            System.out.println("* What do you want to Order?");
            System.out.println("* For order menu input id menu");
            System.out.println("* For order Addition menu press button 0");
            System.out.println("Input : ");
            int pilih = sc.nextInt();
            if (pilih >=1 && pilih <= burger.size()){
                System.out.println(burger.get(pilih - 1).getMenu() + " : " + burger.get(pilih - 1).getPrice());
                System.out.println("Order quantity : ");
                OrderQuantity = sc.nextInt();
                float total1 = OrderQuantity * burger.get(pilih - 1).getPrice();
                System.out.println("Total : " + total1 + "\n");                          
                totalAmount1 += total1;
                System.out.println("**");
            }
            else if (pilih == 0){
                for (Addition menuAddition : getAdditions()){
                    System.out.println("\nADDITION MENU");
                    System.out.println("* What do you want to Order?");
                    System.out.println("* For order menu input id menu");
                    System.out.println("* Confirmation? please, press button 100");
                    System.out.println("Input : ");
                    int pilih1 = sc.nextInt();
                    if (pilih1 >= 1 && pilih1 <= addition.size()){
                        System.out.println();
                        System.out.println("Addition Order");
                        System.out.println(addition.get(pilih1 - 1).getMenu() + " : " + addition.get(pilih1 - 1).getPrice());
                        System.out.println("Order quantity : ");
                        OrderQuantity = sc.nextInt();
                        float total2 = OrderQuantity * addition.get(pilih1 - 1).getPrice();
                        System.out.println("Total : " + total2);
                        totalAmount2 += total2;
                        System.out.println("**");   
                    } 
                    else if (pilih1 == 100){
                        System.out.println();
                        System.out.println("ATTENTION");
                        System.out.println("=========================");
                        System.out.println("Total Harga Pesanan 1 \t : " + "Rp." + totalAmount1);
                        System.out.println("Total Harga Pesanan 2 \t : " + "Rp." + totalAmount2);
                        totalAmount3 = totalAmount1 + totalAmount2;
                        return;
                    }
                }
            }
        } 
    }  
    public void checkout(){
        transaction();
        handlePayment();
        if (paymentAmount >= totalAmount3){
            paymentSummary();
        }
        else {
            System.out.println("Sorry, please come back again");
        }
    }
    //method for transaction
    public void transaction(){
        System.out.println("Total yang harus dibayar : " + "Rp." + totalAmount3);
        System.out.println("Input your Money!");
        paymentAmount = sc.nextInt();
        changeMoney = paymentAmount - totalAmount3;
    }
    //method for handle the payment
    public void handlePayment(){
        if (paymentAmount >= totalAmount3){
            System.out.println("SUCCES : Your order is confirmed");
        }
        else if (paymentAmount < totalAmount3){
            System.out.println("FAILED : Your order is failed");
        }
    }
    //method for print payment summary
    public void paymentSummary(){
        System.out.println("\nPAYMENT SUMMARY");
        System.out.println("=========================");
        System.out.println("TOTAL AMOUNT\t:" + "Rp." + totalAmount3);
        System.out.println("PAYMENT AMOUNT\t:" + "Rp." + paymentAmount);
        System.out.println("CHANGE MONEY\t:" + "Rp." + changeMoney);
        //use getInstance() method to get object of java Calendar class
        Calendar cal = Calendar.getInstance();
        //use getTime() method of Calendar class to get date and time
        System.out.println("PAYMENT DATE\t:" + cal.getTime());
	}
}