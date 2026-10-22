public class RomanToInteger {
    public static void main(String[] args) {
        String roman="IV";
        int num=0;
        for(int i=0;i<roman.length();i++){
            int current=value(roman.charAt(i));
            if(i<roman.length()-1&&current<value(roman.charAt(i+1))){
                num-=current;
            }
            else{
                num+=current;
            }
        }
        System.out.println(num);
    }
    public static int value(char ch){
        switch (ch){
            case 'V':
                return 5;
            case 'I':
                return 1;
            default:
                return 0;
        }
    }
}
