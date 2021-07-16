/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodcatering_package;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
/**
 * this is the menu that contain list of item and customer choose name of item from it  
 */
 class menu 
{
    /**
     * menu list contain item of food
     */
public static ArrayList<Item> menueList=new ArrayList<Item>() ;
/**
 * function used to search for item in menu
 * @param name name of item that customer needed it
 * @return -1 if not founded and return index of item if founded 
 */
public int searchInMenue(String name) {
      int s =-1;
        
         for (int i=0;i<menueList.size();i++){
             if (menueList.get(i).getName()==name)
             {
                   s = i;              
             }    
     }
        return s;
}
/**
 * function used to search for item by name of this item and return item if founded
 * @param name name of item that customer needed it
 * @return return item of this name 
 */
public Item findItem(String name)
{
    Item x=null;
    int index=searchInMenue(name);
    try{
    if(index==-1)
    {
        throw new myexception(name+" this item name not founded in menue");
    }
    else
    {
       x= menueList.get(index);
    }
    }
    catch(myexception o)
    {
        System.out.println(o.getMessage());
    }
     return x;
}
/**
 * function that create items with attributes of it and add items to menu list 
 */
public static void getmenue()
{
         Item a=new Item("tea", "drinks", 4f, 5f, 1);
         Item b=new Item("coffe", "drinks", 5f, 10f, 1);
         Item c=new Item("milk", "drinks", 6f, 10f, 1);
         Item g=new Item("juice", "drinks", 7f, 15f, 1);
         Item e=new Item("crackers", "appetizers", 20f, 20f, 1);
         Item f=new Item("salad", "appetizers", 10, 20f, 4);
         Item j=new Item("olives", "appetizers", 2f, 21f, 3);
         Item h=new Item("cheese", "appetizers", 2f, 22f, 2);
         Item k=new Item("ice cream", "deserts", 2, 23f, 3);
         Item l=new Item("chocolate", "deserts", 3, 11f, 3);
         Item q=new Item("cakes", "deserts", 4, 12f, 3);
         Item w=new Item("cookies", "deserts", 5, 13f, 3);
         Item r=new Item("chicken", "main dishees", 20f, 40f, 3);
         Item x=new Item("fish", "main dishees", 22f, 42f, 2);
         Item t=new Item("meat", "main dishees", 24f, 43f, 4);
         Item y=new Item("rice", "main dishees", 10f, 10f, 2);
         menu.menueList.add(a);
         menu.menueList.add(b);
         menu.menueList.add(c);
         menu.menueList.add(g);
         menu.menueList.add(e);
         menu.menueList.add(f);
         menu.menueList.add(j);
         menu.menueList.add(h);
         menu.menueList.add(k);
         menu.menueList.add(l);
         menu.menueList.add(q);
         menu.menueList.add(w);
         menu.menueList.add(r);
         menu.menueList.add(x);
         menu.menueList.add(t);
         menu.menueList.add(y);
}


}
/**
 * contain of common function of loyal customer and guest customer
 */
interface custtomer{
    /**
     * function that canceled order on condition before the delivery date by at least 24 hours
     * @param code code for order that you want to canceled
     */
public void CancelOrder(int code);
/**
 * function that update orders with other item required by customer
 * @param obj name of item that user wanted to added to his order
 * @param code code for order that user want to update it
 */
public void UpdateOrder(String obj,int code);
/**
 * function overloading that update delivery date of order
 * @param extra number of days that customer wanted to extend his order by it
 * @param code code for order that user want to update it
 */
public void UpdateOrder(int extra,int code);
/**
 * function that search in order with order code because customer can has many orders
 * @param code code for this order
 */
public int searchOrder(int code);
/**
 * function to add favorite item name in wishlist array for this customer
 * @param fav name of favorite item 
 */
public void favouritItem(String fav);
/**
 * function to display favorite items from wishlist for this customer
 */
public void displayWishlist();
/**
 * function to display information for customer orders and information of items that founded in this orders
 */
public void displayCustomerOrders();
}
/**
 *parent class contain of customer function and attribute 
 */
 abstract class customer implements custtomer
{
    /**
     * contain customer feedback for order
     */
    private String customerReview;
    /**
     * including customer name
     */
    private String customerName;
    /**
     * including customer phone
     */
    private String customerPhone;
    /**
     * static variable to calculate number of customer
     */
    private static int customerCount;
    
    public customer(String customerName, String customerPhone) {
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        customerCount++;
    }
    /**
     * list that contain favorite item name for this customer
     */
 ArrayList<String> wishList =new ArrayList<String>();
 /**
  * list that contain orders for this customer because customer can has many orders
  */
 ArrayList<order> orders =new ArrayList<order>();
 /**
  * abstract function that create order for this customer 
  * @param x items name that customer wanted it
  * @param code code for order
  * @param orderDate date of order
  * @param deliveryAddress address of order 
  * @param deliveryDate  order delivery date
  * @param deliveryTime  order delivery time
  */
public abstract void CreateOrder(ArrayList<String> x ,int code, String orderDate, String deliveryAddress, String deliveryDate, String deliveryTime);
/**
 * override function in interface that search in order with order code because customer can has many orders
 * @param code code for this order
 */
@Override
public int searchOrder(int code) {
      int s =-1;
        
         for (int i=0;i<orders.size();i++){
             if (orders.get(i).getCode()==code)
             {
                   s = i;              
             }    
     }
        return s;
    }
/**
 * override function in interface that add favorite item name in wishlist array for this customer
 * @param fav name of favorite item 
 */
@Override
public void favouritItem(String fav)
{
 wishList.add(fav);
}
/**
 * override function in interface that display favorite items from wishlist for this customer
 */
@Override
public void displayWishlist()
{
 System.out.println("***** Customer favourit items name is *****");
 for(String name:wishList)
 {
    System.out.println(name);
 }
}
/**
 * override function in interface that display information for customer orders and information of items that founded in this orders
 */
@Override
public final void displayCustomerOrders()
{
 
 for(order name:orders)
 {
     System.out.println("***** information of custmer orders is *****");
     System.out.println("order code: "+name.getCode()+"\n"+"delivery address is"+
         name.getDeliveryAddress()+"\n"+"delivery data: "+
         name.getDeliveryDate()+"\n"+"delivery Time: "+
         name.getDeliveryTime()+"\n"+"orfer date: "+name.getOrderDate());
      for(int i =0;i<orders.size();i++)
     {
       System.out.println("***** Information of items for this order *****");
        
       name.display_meal();

     }
    
 }
 
}

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public static int getCustomerCount() {
        return customerCount;
    }

    public static void setCustomerCount(int customerCount) {
        customer.customerCount = customerCount;
    }
    /**
     * override function in interface that canceled order on condition before the delivery date by at least 24 hours
     * @param code code for order that you want to canceled
     */
      @Override
    public void CancelOrder(int code) {
        try{
         if(searchOrder(code)==-1)
         {
             throw new myexception(" exception This order not founded ");
         }
         else
         {
             DateFormat dat=new SimpleDateFormat("yyyy MM dd hh:mm");
             int idex=searchOrder(code);
             try
             {
             Date olddate=dat.parse(orders.get(idex).getDeliveryDate().trim());
             Date datenow =new Date();
             long Datebetween= ChronoUnit.DAYS.between(datenow.toInstant(),olddate.toInstant());
             if(Datebetween>=1)
             {
             orders.remove(idex);
             System.out.println(" order cancel sucessfully for this order ");
              return;
             }
             else
             {
                  throw new myexception(" exception This order cant deleted now because order delivery date less 24 hours(1 day) ");
                 
             }
            }
             catch(ParseException e)
             {
                 System.out.println("parse date Exception !!!! , please write the date formate correctly ");
            }
         }  
         }catch(myexception o)
         {
             System.out.println(o.getMessage());
         }
    }
    /**
     * override function in interface that update orders with other item required by customer
     * @param obj name of item that user wanted to added to his order
     * @param code code for order that user want to update it
     */
    @Override
    public void UpdateOrder(String obj,int code) {
        try{
        if(searchOrder(code)==-1)
        {
            throw new myexception(" exception This order not founded ");
            
        }
        else
        {
            menu object=new menu();
            Item x=object.findItem(obj);
            if(x!=null)
            {
            int idex=searchOrder(code);
            orders.get(idex).meal.add(x);
            System.out.println(" order updated !! item added sucessfully in items of the order ");
            }
        }
        }
        catch(myexception o)
        {
            System.out.println(o.getMessage());
        }
        
    }
/**
 * function overloading that update delivery date of order and it override from interface
 * @param extra number of days that customer wanted to extend his order by it
 * @param code code for order that user want to update it
 */
    @Override
    public void UpdateOrder(int extra,int code) {
        try{
        if(searchOrder(code)==-1)
        {
            throw new myexception(" exception This order not founded ");
        }
        else
        {
            if(extra>0)
            {
                 int idex=searchOrder(code);
            String olddate=orders.get(idex).getDeliveryDate();
            String [] arr=olddate.split(" ");
            int newdate=Integer.valueOf(arr[2])+extra;
            orders.get(idex).setDeliveryDate(arr[0]+" "+arr[1]+" "+String.valueOf(newdate)+" "+arr[3]);
            System.out.println(" updated Done !! order date extend sucessfully for this order ");
            }
           else
            {
                throw new myexception(" exception you cant add extra days in negitive ");
            }
            
        }
        }
        catch(myexception o)
        {
            System.out.println(o.getMessage());
        }
    }


    public String getCustomerReview() {
        return customerReview;
    }

    public void setCustomerReview(String customerReview) {
        this.customerReview = customerReview;
    }


}

/**
 * one of sub classes for parent class customer
 */
class LoyaltyCustomer extends customer
{
    /**
     * unique number for loyal customer only 
     */
private static int specialnum;

    public LoyaltyCustomer(String customerName, String customerPhone) {
        super(customerName, customerPhone);
        specialnum++;
    }   

    public int getSpecialnum() {
        return specialnum;
    }

    public void setSpecialnum(int specialnum) {
        this.specialnum = specialnum;
    }
   
/**
  * function that create order for loyal customer 
  * @param x array of string that contain items name that customer wanted it
  * @param code code for order
  * @param orderDate date of order
  * @param deliveryAddress address of order 
  * @param deliveryDate  order delivery date
  * @param deliveryTime  order delivery time
  */
 
    @Override
    public void CreateOrder(ArrayList<String> x ,int code, String orderDate, String deliveryAddress, String deliveryDate, String deliveryTime)
    {
        ArrayList<Item> requirditems=new ArrayList<>();
        for(int i=0;i<x.size();i++)
        {
            menu obj=new menu();
            Item y=obj.findItem(x.get(i).toLowerCase());
            requirditems.add(y);
                  
        }
        System.out.println(" Welcome you are loyal custmer, you are given drink and two aptizers for free added in your order ");
           String drink="tea";
           String aptizer1="salad";
           String aptizer2="cheese";
           menu o =new menu();
           Item k1= o.findItem(drink);
           Item k2= o.findItem(aptizer1);
           Item k3= o.findItem(aptizer2);
           requirditems.add(k1);
           requirditems.add(k2);
           requirditems.add(k3);
        order r=new order(requirditems, code, orderDate, deliveryAddress, deliveryDate, deliveryTime);
        orders.add(r);
        System.out.println(" order created sucessfully thanks for you ");
    }
    
}
/**
 * one of sub classes for parent class customer
 */
class Guest extends customer
{
    /**
     * boolean attribute used to know if customer give tips or not
     */
    private boolean givetips;

    public Guest(boolean givetips, String customerName, String customerPhone) {
        super(customerName, customerPhone);
        this.givetips = givetips;
    }

    public boolean isGivetips() {
        return givetips;
    }

    public void setGivetips(boolean givetips) {
        this.givetips = givetips;
    }
/**
 * final function used to know if customer give tips or not 
 */
    final void displaytip()
    {
        if(isGivetips()==true)
            System.out.println("tips: this custmer give tips ");
        else
            System.out.println("tips: this customer did not give tips");
    }
/**
  * function that create order for Guest customer 
  * @param x items name that customer wanted it
  * @param code code for order
  * @param orderDate date of order
  * @param deliveryAddress address of order 
  * @param deliveryDate  order delivery date
  * @param deliveryTime  order delivery time
  */
 
    @Override
    public void CreateOrder(ArrayList<String> x ,int code, String orderDate, String deliveryAddress, String deliveryDate, String deliveryTime)
    {
      ArrayList<Item> requirditems=new ArrayList<>();
        for(int i=0;i<x.size();i++)
        {
             menu object=new menu();
            Item y=object.findItem(x.get(i).toLowerCase());
            requirditems.add(y);
            //int idex=searchOrder(code);
        
        }
        order r=new order(requirditems, code, orderDate, deliveryAddress, deliveryDate, deliveryTime);
        orders.add(r);
        System.out.println(" order created sucessfully thanks for you");
    }  
}
/**
 * contain all information about items of food
 */
class Item
{
/**
 * including item name
 */   
private String name; 
/**
 * including item name
 */
private String categorey;
/**
 * including number of calories for item
 */
private float numOfCalories;
/**
 * including item price
 */
private float price;
/**
 * including number of person for this item
 */
private int portion;


    public Item(String name, String categorey, float numOfCalories, float price, int portion) {
        this.name = name;
        this.categorey = categorey;
        this.numOfCalories = numOfCalories;
        this.price = price;
        this.portion = portion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategorey() {
        return categorey;
    }

    public void setCategorey(String categorey) {
        this.categorey = categorey;
    }

    public float getNumOfCalories() {
        return numOfCalories;
    }

    public void setNumOfCalories(float numOfCalories) {
        this.numOfCalories = numOfCalories;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getPortion() {
        return portion;
    }

    public void setPortion(int portion) {
        this.portion = portion;
    }
}
/**
 * contain all information about orders that contain from some items of food
 */
class order
{
    /**
     * list contain meals of this order (many items)
     */
public  ArrayList<Item> meal =new ArrayList<Item>();
/** including code for this order
 */
private final int code;
/**
 * including order date
 */
private String orderDate;
/**
 * including order addresses 
 */
private String deliveryAddress;
/**
 * including delivery date
 */
private String deliveryDate;
/**
 * including delivery time
 */
private String deliveryTime;
/**
 * static attribute that calculate number of orders 
 */
private static int ordercount;

    public order(ArrayList<Item> meal,int code, String orderDate, String deliveryAddress, String deliveryDate, String deliveryTime) {
        this.meal=meal;
        this.code = code;
        this.orderDate = orderDate;
        this.deliveryAddress = deliveryAddress;
        this.deliveryDate = deliveryDate;
        this.deliveryTime = deliveryTime;
        ordercount++;
    }
    /**
     * function to display all information about meals (all items that customer wanted it)
     */
    void display_meal()
    {
        int i=1;
    for(Item o:meal)
    {
        
        System.out.println("\t"+"Item "+i+"\n"+"item name: "+o.getName()+"\n"+"item Categorey: "+
                o.getCategorey()+"\n"+"item calories: "+o.getNumOfCalories()+"\n"+
               "number of person for this item: "+ o.getPortion()+"\n"+
                "item price: "+o.getPrice()+"\n"+"-------***-------");
        i++;
    }
    }

    public  ArrayList<Item> getMeal() {
        return meal;
    }

    public  void setMeal(ArrayList<Item> meal) {
        this.meal = meal;
    }
    
    public int getCode() {
        return code;
    }

    public static int getOrdercount() {
        return ordercount;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

}
/**
 * my exception class that used to handle exception in my project
 */
 class myexception extends Exception
{

    public myexception(String message) {
        super(message);
    }

}
/**
 * main class
 */
public class FoodCatering {
    public static void main(String[] args)  {
                 //drinks appetizers, deserts, main dishees
        Scanner s=new Scanner(System.in);
        menu e=new menu();
         e.getmenue();
         customer customerarr[]=new customer[4];
         customerarr[0]=new LoyaltyCustomer("Mohamed","01144");
         customerarr[1]=new LoyaltyCustomer("ahmed","01555");
         customerarr[2]=new Guest(true,"Ayman","01254");
         customerarr[3]=new Guest(false,"Eman","01545");
        
         ArrayList<Item>arr1=new ArrayList<>();
         ArrayList<Item>arr2=new ArrayList<>();
         ArrayList<Item>arr3=new ArrayList<>();
         
         arr1.add(new Item("tea", "drinks", 4f, 5f, 1));
         arr1.add(new Item("crackers", "appetizers", 20f, 20f, 1));
         arr1.add(new Item("ice cream", "deserts", 2, 23f, 3));
         arr1.add(new Item("chicken", "main dishees", 20f, 40f, 3));
         arr2.add(new Item("cofee", "drinks", 5f, 10f, 1));
         arr2.add(new Item("Salad", "appetizers", 10, 20f, 4));
         arr2.add(new Item("chocolate", "deserts", 3, 11f, 3));
         arr2.add(new Item("fish", "main dishees", 22f, 42f, 2));
         arr3.add(new Item("juice", "drinks", 7f, 15f, 1));
         arr3.add(new Item("cheese", "appetizers", 2f, 22f, 2));
         arr3.add(new Item("cakes", "deserts", 4, 12f, 3));
         arr3.add(new Item("meat", "main dishees", 24f, 43f, 4));
         
         Date date = Calendar.getInstance().getTime();  
         DateFormat dateFormat = new SimpleDateFormat("yyyy mm dd hh:mm");  
         String startDate = dateFormat.format(date);
         
         order o1=new order(arr1,1 ,startDate,"Egypt streat house num 2","2020 05 29 08:44", "08:44");
         order o2=new order(arr2,1 ,startDate,"alex streat house num 2","2020 05 28 08:44", "09:22");
         order o3=new order(arr3,1 ,startDate,"giza streat house num 2","2020 05 29 08:44", "10:33");
         
            System.out.println("\t\t function of first customer:- ");
         ArrayList<String>cust0order=new ArrayList<>();      
         cust0order.add("rice");
         cust0order.add("meat");
         cust0order.add("coffe");
         customerarr[0].CreateOrder(cust0order, 1, startDate ," alex elmamora streat" , "2020 06 03 08:44", "2020 05 28 08:44");
         customerarr[0].CancelOrder(1);
         customerarr[0].UpdateOrder("chicken", 1);
         customerarr[0].UpdateOrder(2, 1);
         System.out.print(" Enter your feedback on order : \n ");
         String x=s.nextLine();
         customerarr[0].setCustomerReview(x);
         String name="";
         System.out.println(" Enter your favourit items name and enter end when you done: ");
        while (true)
                {
                    name=s.nextLine();
                if(!name.equals("end"))
                {
                customerarr[0].favouritItem(name);
                }
                else
                    break;
                }
       
         System.out.println("***************************************************");
         System.out.println("\t\t function of second customer:- ");
         ArrayList<String>cust1order=new ArrayList<>();
         cust1order.add("rice");
         cust1order.add("chicken");
         cust1order.add("tea");
         customerarr[1].CreateOrder(cust1order, 1, startDate ," Giza street " , "2020 06 03 08:44", "2020 05 28 08:44");
         customerarr[1].CancelOrder(1);
         customerarr[1].UpdateOrder("meat", 1);
         customerarr[1].UpdateOrder(2, 1);
         System.out.print(" Enter your feedback on order : \n ");
         String y=s.nextLine();
         customerarr[1].setCustomerReview(y);
         
          System.out.println(" Enter your favourit items name and enter end when you done: ");
          while (true)
                {
                    name=s.nextLine();
                if(!name.equals("end"))
                {
                customerarr[1].favouritItem(name);
                }
                else
                    break;
                }
         System.out.println("***************************************************");
          System.out.println("\t\t function of third customer:- ");
         ArrayList<String>cust2order=new ArrayList<>();
         cust2order.add("rice");
         cust2order.add("meat");
         cust2order.add("coffe");
         customerarr[2].CreateOrder(cust2order, 1, startDate ," zewail streat" , "2020 06 03 08:44", "2020 05 28 08:44");
         customerarr[2].CancelOrder(1);
         customerarr[2].UpdateOrder("tea", 1);
         customerarr[2].UpdateOrder(2, 1);
         System.out.print(" Enter your feedback on order : \n ");
         String z=s.nextLine();
         customerarr[2].setCustomerReview(z);
         
         System.out.println("Enter your favourit items name and enter end when you done: ");
         while (true)
                {
                    name=s.nextLine();
                if(!name.equals("end"))
                {
                customerarr[2].favouritItem(name);
                }
                else
                    break;
                }
         System.out.println("***************************************************");
         System.out.println("\t\t function of fourth customer:- ");
         ArrayList<String>cust3order=new ArrayList<>();
         
         cust3order.add("ice cream");
         cust3order.add("chocolate");
         cust3order.add("cakes");
         
         customerarr[3].CreateOrder(cust3order, 1, startDate ," Qalyoup streat" , "2020 06 30 08:44", "2020 05 28 08:44");
         customerarr[3].UpdateOrder("cookies", 1);
         customerarr[3].UpdateOrder(2, 1);
         System.out.print(" Enter your feedback on order : \n ");
         String n =s.nextLine();
         customerarr[3].setCustomerReview(n);
         customerarr[3].CancelOrder(1);
         
         System.out.println(" Enter your favourit items name and enter end when you done: ");
        while (true)
                {
                    name=s.nextLine();
                if(!name.equals("end"))
                {
                customerarr[3].favouritItem(name);
                }
                else
                    break;
                }
         System.out.println("*************************--**************************");
         System.out.println("         display information of all customers ");
         System.out.println("*************************--**************************");
         
        for(int i=0;i<customerarr.length;i++)
         {
         System.out.println("customer number "+(i+1));
         System.out.println("customer name: "+customerarr[i].getCustomerName());
         System.out.println("customer phone: "+customerarr[i].getCustomerPhone());
         System.out.println("customer review for order: "+customerarr[i].getCustomerReview());
         customerarr[i].displayWishlist();
         if(customerarr[i].orders.isEmpty())
             System.out.println("customer did not have any order"); 
         else
             
         customerarr[i].displayCustomerOrders();
         
         if(customerarr[i] instanceof LoyaltyCustomer)
         {
             LoyaltyCustomer obj;
             obj=(LoyaltyCustomer)customerarr[i];
             System.out.println("loyal customer id : "+obj.getSpecialnum());
         }
         else if(customerarr[i] instanceof Guest)
         {
             Guest obj;
             obj=(Guest)customerarr[i];
             obj.displaytip();
         }
             System.out.println("------------------------------------------------------");
         }
        

    
    }
}
