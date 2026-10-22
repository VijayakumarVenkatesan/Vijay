
import java.util.Scanner;

public class Swiggy {
    static Scanner in=new Scanner(System.in);
    static void bill()throws Exception{
        double bill;
        int genOTP,verifyOTP;
        System.out.print("Enter amount:");
        bill=in.nextInt();
        genOTP=(int)(Math.random()*90000)+10000;
        System.out.println("OTP:"+genOTP);
        System.out.print("Enter OTP:");
        verifyOTP=in.nextInt();
        System.out.println();
        System.out.println("------------------Processing-----------------");
        Thread.sleep(2000);
        while(verifyOTP!=genOTP){
            System.out.print("Enter a correct OTP:");
            verifyOTP=in.nextInt();
        }
        System.out.println("Bill paid Rs."+bill);
        System.out.println("Your order placed");
    }
    static void payment(double amount)throws Exception{
        int payment,process;
        double Amount;
        Amount=amount;
        System.out.println("-------------------------Processing the Bill---------------------------");
        Thread.sleep(2000);
        System.out.println("\t\tYour total amount:"+Amount);
        System.out.println("1.Continue\n2.Cancel");
        System.out.print("Choose:");
        process=in.nextInt();
        System.out.println("--------------------Redirecting to Payment--------------------------");
        Thread.sleep(2000);
        if(process==1){
            System.out.println("Payment gateways:\n1.Gpay\n2.Phone Pe\n3.Paytm");
            System.out.println("----------------Choose payment method-----------------------------");
            System.out.print("Choose:");
            payment=in.nextInt();
            while(payment>3||payment<1){
                System.out.print("Choose a valid option:");
                payment=in.nextInt();
            }
            switch(payment){
                case 1:{
                    System.out.println("\t\tGpay");
                    bill();
                    break;
                }
                case 2:{
                    System.out.println("\t\tPhone Pe");
                    bill();
                    break;
                }
                case 3:{
                    System.out.println("\t\tPaytm");
                    bill();
                    break;
                }
            }
        }
        else{
            System.out.println("Your order cancelled");
        }
        
    }
    public static void main(String [] args)throws Exception{
        int restaurant,quantity,food;
        double amount;
        System.out.println("\t\tWELCOME TO SWIGGY");
        System.out.println("Restaurants:\n1.SS Hyderabad Biriyani\n2.Buhari\n3.A2B\n4.Amma Unavagam");
        System.out.print("Choose a hotel:");
        restaurant=in.nextInt();
        System.out.println();
        while(restaurant>4||restaurant<1){
            System.out.print("Choose a valid option:");
            restaurant=in.nextInt();
        }
        System.out.println("----------------Processing------------------------");
        Thread.sleep(2000);
        switch(restaurant){
            case 1:{
                System.out.println("\t\tGreetings from SS Hyderabad Biriyani");
                System.out.println("\t\tSS Hyderabad Biriyani\nMenu\n1.Chicken Biriyani\n2.Mutton Biriyani\n3.Beef Biriani\n4.Prawn Biriyani");
                System.out.print("Choose your food:");
                food=in.nextInt();
                System.out.println();
                while(food>4||food<1){
                    System.out.print("Choose a valid option:");
                    food=in.nextInt();
                }
                System.out.println("----------------------------Processing-------------------------------");
                Thread.sleep(2000);
                switch (food){
                    case 1:{
                        System.out.println("\t\tYou choosed Chicken Biriyani");
                        System.out.print("Enter quantity:");
                        quantity=in.nextInt();
                        amount=quantity*250;
                        payment(amount);
                        break;
                    }
                    case 2:{
                        System.out.println("\t\tYou choosed Mutton Biriyani");
                        System.out.print("Enter quantity:");
                        quantity=in.nextInt();
                        amount=quantity*250;
                        payment(amount);
                        break;
                    }
                    case 3:{
                        System.out.println("\t\tYou choosed Beef Biriyani");
                        System.out.print("Enter quantity:");
                        quantity=in.nextInt();
                        amount=quantity*250;
                        payment(amount);
                        break;
                    }
                    case 4:{
                        System.out.println("\t\tYou choosed Prawn Biriyani");
                        System.out.print("Enter quantity:");
                        quantity=in.nextInt();
                        amount=quantity*250;
                        payment(amount);
                        break;
                    }
                }
                break;
            }
            case 2:{
                System.out.println("\t\tGreeting from Buhari");
                System.out.println("\t\tBuhari\nMenu\n1.Chicken Biriyani\n2.Dragon Chicken\n3.Chicken Tandoori\n4.Grill Chicken");
                System.out.print("Choose your food:");
                food=in.nextInt();
                System.out.println();
                while(food>4||food<1){
                    System.out.print("Choose a valid option:");
                    food=in.nextInt();
                }
                switch (food){
                    case 1:{
                        System.out.println("\t\tYou choosed Chicken Biriyani");
                        System.out.print("Enter quantity:");
                        quantity=in.nextInt();
                        amount=quantity*250;
                        payment(amount);
                        break;
                    }
                    case 2:{
                        System.out.println("\t\tYou choosed Dragon Chicken");
                        System.out.print("Enter quantity:");
                        quantity=in.nextInt();
                        amount=quantity*200;
                        payment(amount);
                        break;
                    }
                    case 3:{
                        System.out.println("\t\tYou choosed Chicken Tandoori");
                        System.out.print("Enter quantity:");
                        quantity=in.nextInt();
                        amount=quantity*350;
                        payment(amount);
                        break;
                    }
                    case 4:{
                        System.out.println("\t\tYou choosed Grill Chicken");
                        System.out.print("Enter quantity:");
                        quantity=in.nextInt();
                        amount=quantity*350;
                        payment(amount);
                        break;
                    }
                }
                break;
            }
            case 3:{
                System.out.println("Greeting from A2B");
                System.out.println("\t\tA2B\nMenu\n1.Parotta\n2.Gobi Fried Noodles\n3.Paneer Butter Masala\n4.Mushroom Pepper Fry");
                System.out.print("Choose your food:");
                food=in.nextInt();
                System.out.println();
                while(food>4||food<1){
                    System.out.print("Choose a valid option:");
                    food=in.nextInt();
                }
                switch (food){
                    case 1:{
                        System.out.println("\t\tYou choosed Parotta");
                        System.out.print("Enter quantity:");
                        quantity=in.nextInt();
                        amount=quantity*60;
                        payment(amount);
                        break;
                    }
                    case 2:{
                        System.out.println("\t\tYou choosed Gobi Fried Noodles");
                        System.out.print("Enter quantity:");
                        quantity=in.nextInt();
                        amount=quantity*220;
                        payment(amount);
                        break;
                    }
                    case 3:{
                        System.out.println("\t\tYou choosed Paneer Butter Masala");
                        System.out.print("Enter quantity:");
                        quantity=in.nextInt();
                        amount=quantity*200;
                        payment(amount);
                        break;
                    }
                    case 4:{
                        System.out.println("\t\tYou choosed Mushroom Pepper Fry");
                        System.out.print("Enter quantity:");
                        quantity=in.nextInt();
                        amount=quantity*220;
                        payment(amount);
                        break;
                    }
                }
                break;
            }
            case 4:{
                System.out.println("Greetings from Amma Unavagam");
                System.out.println("\t\tAmma Unavagam\nMenu\n1.Idly\n2.Chappati\n3.Dosa\n4.Sambar Satham");
                System.out.print("Choose your food:");
                food=in.nextInt();
                System.out.println();
                while(food>4||food<1){
                    System.out.print("Choose a valid option:");
                    food=in.nextInt();
                }
                switch (food){
                    case 1:{
                        System.out.println("\t\tYou choosed Idly");
                        System.out.print("Enter quantity:");
                        quantity=in.nextInt();
                        amount=quantity;
                        payment(amount);
                        break;
                    }
                    case 2:{
                        System.out.println("\t\tYou choosed Chappati");
                        System.out.print("Enter quantity:");
                        quantity=in.nextInt();
                        amount=quantity*1.5;
                        payment(amount);
                        break;
                    }
                    case 3:{
                        System.out.println("\t\tYou choosed Dosa");
                        System.out.print("Enter quantity:");
                        quantity=in.nextInt();
                        amount=quantity*5;
                        payment(amount);
                        break;
                    }
                    case 4:{
                        System.out.println("\t\ttYou choosed Sambar Satham");
                        System.out.print("Enter quantity:");
                        quantity=in.nextInt();
                        amount=quantity*5;
                        payment(amount);
                        break;
                    }
                }
                break;
            }
        }
    }
}
