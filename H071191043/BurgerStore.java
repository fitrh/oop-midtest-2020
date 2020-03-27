package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Calendar;

public class BurgerStore extends Cart{
    Cart c = new Cart();
	
	private float totalAmount1 = 0;
    private float totalAmount2 = 0;
    private float totalAmount3 = 0;
    private int OrderQuantity ;

    private float paymentAmount;
    private float changeMoney;

    Scanner sc = new Scanner(System.in);

    @Override
    public void showMenuBurger() {
        System.out.println("=========================");
        System.out.println("Burger menu");
        System.out.println("=========================");
    }
    public void showBurger(){
        for (Burger bm : getItems()){
            System.out.println(bm.getId() + ". " + bm.getMenu() + " : " + bm.getPrice());
        }
    }
    @Override
    public void showMenuAddition() {
        System.out.println("=========================");
        System.out.println("Addition menu");
        System.out.println("=========================");
    }
    public void showAddition(){
        for (Addition addition : getAdditions()){
            System.out.println(addition.getId() + ". " + addition.getMenu() + " : " + addition.getPrice());
        }
    }
	public void buyBurger(){
		System.out.println("\nORDER MENU");
		System.out.println("=========================");
        for (Burger bm : getItems()) {
            System.out.println("\nBURGER MENU");
            System.out.println("* What do you want to Order?");
            System.out.println("* For order menu input id menu");
            System.out.println("* For order Addition menu press button 0");
            System.out.println("Input : ");
            int pilih = sc.nextInt();
            if (pilih >=1 && pilih <= items.size()){
                System.out.println(items.get(pilih - 1).getMenu() + " : " + items.get(pilih - 1).getPrice());
                System.out.println("Order quantity : ");
                OrderQuantity = sc.nextInt();
                float total1 = OrderQuantity * items.get(pilih - 1).getPrice();
                System.out.println("Total : " + total1 + "\n");                          
                totalAmount1 += total1;
                System.out.println("**");
            }
            else if (pilih == 0){
                for (Addition addition : getAdditions()){
                    System.out.println("\nADDITION MENU");
                    System.out.println("* What do you want to Order?");
                    System.out.println("* For order menu input id menu");
                    System.out.println("* Confirmation? please, press button 100");
                    System.out.println("Input : ");
                    int pilih1 = sc.nextInt();
                    if (pilih1 >= 1 && pilih1 <= itemAdditions.size()){
                        System.out.println();
                        System.out.println("Addition Order");
                        System.out.println(itemAdditions.get(pilih1 - 1).getMenu() + " : " + itemAdditions.get(pilih1 - 1).getPrice());
                        System.out.println("Order quantity : ");
                        OrderQuantity = sc.nextInt();
                        float total2 = OrderQuantity * itemAdditions.get(pilih1 - 1).getPrice();
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
    public void transaction(){
        System.out.println("Total yang harus dibayar : " + "Rp." + totalAmount3);
        System.out.println("Input your Money!");
        paymentAmount = sc.nextInt();
        changeMoney = paymentAmount - totalAmount3;
    }
    public void handlePayment(){
        if (paymentAmount >= totalAmount3){
            System.out.println("SUCCES : Your order is confirmed");
        }
        else if (paymentAmount < totalAmount3){
            System.out.println("FAILED : Your order is failed");
        }
    }
    
    public void paymentSummary(){
        System.out.println("\nPAYMENT SUMMARY");
        System.out.println("=========================");
        System.out.println("TOTAL AMOUNT\t:" + "Rp." + totalAmount3);
        System.out.println("PAYMENT AMOUNT\t:" + "Rp." + paymentAmount);
        System.out.println("CHANGE MONEY\t:" + "Rp." + changeMoney);
        Calendar cal = Calendar.getInstance();
        System.out.println("PAYMENT DATE\t:" + cal.getTime());
	}
}