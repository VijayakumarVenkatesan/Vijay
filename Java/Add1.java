public class Add1 {
    public static void plusOne(int[] digits) {
        int len=digits.length;
        int[] result=new int[len+1];
        System.out.println("Last digit "+digits[len-1]);
        int sum=digits[len-1]+1;
        digits[len-1]=sum%10;
        int carry=sum/10;
        System.out.println("Last digit "+digits[len-1]);
        System.out.println("Check "+carry);
        for(int i=len-2;i>=0;i--){
            sum=carry+digits[i];
            System.out.println("Loop sum"+sum);
            digits[i]=sum%10;
            carry=sum/10;
            System.out.println("Loop carry"+carry);
        }
        System.out.println("Test carry"+carry);
        if(carry>0){
            result[0]=carry;
            for(int i=0;i<len;i++){
                result[i+1]=digits[i];
            }
            System.out.println("!");
            for(int num:result) System.out.println(num);
        }
        else{
            for(int num:digits) System.out.println(num);
        }
    }
    public static void main(String[] args) {
        int[] arr={9};
        plusOne(arr);
    }
}
