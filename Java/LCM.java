import java.util.Scanner;
public class LCM {
    public static void main(String[] args) {
        int lcm,x,y;
        Scanner in=new Scanner(System.in);
        System.out.print("Enter first number:");
        x=in.nextInt();
        System.out.print("Enter second number:");
        y=in.nextInt();
        lcm=x>y?x:y;
        for(int i=1;i<lcm;i++){
            if((lcm*i)%x==0&&(lcm*i)%y==0){
                lcm=lcm*i;
                break;
            }
        }
        System.out.println(lcm);
    }
}
