public class Q1 {
    public static void main(String[] args) {
        System.out.println(substitiuteAI("flabbergasted"));
        System.out.println(substitiuteAI("Astronaut"));
        System.out.println(reverse("String"));
        System.out.println(sum(5));
        System.out.println(printDigit(8221));
        
    }
    
    public static String substitiuteAI(String line){
        if(line.length() == 0) return "";

        char first = line.charAt(0);
        if(first == 'a') return "i" + substitiuteAI(line.substring(1));
        return first + substitiuteAI(line.substring(1));
    }

    //Tutorial Question 3
    public static String reverse(String line){
        if(line.length() == 0) return "";

        char last = line.charAt(line.length()-1);
        return last + reverse(line.substring(0, line.length()-1));
    }

    //Tutorial Question 4
    public static int sum(int num){
        if(num == 1) return 1;
        return num + sum(num-1);
    }

    //Tutorial Question 5
    public static String printDigit(int num){
        if(num == 0) return "";

        int digit = (int) (num/(Math.pow(10,(int)(Math.log10(num)))));
        return String.valueOf(digit) + " " + printDigit((int) (num%(Math.pow(10,(int)(Math.log10(num))))));
    }
}
