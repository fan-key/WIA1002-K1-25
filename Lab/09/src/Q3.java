public class Q3 {
    public static void main(String[] args) {
        int x = 2;
        int y = -1;
        System.out.println(exponent(x, y));
    }
    
    public static long exponent(int x, int m){
        if(m < 0) throw new IllegalArgumentException();
        if(m == 0) return 1;
        if(m == 1) return x;

        return x*exponent(x, m-1);
    }
}
