public class Q2 {
    public static void main(String[] args) {
        permuteString("ABC");
    }

    public static void permuteString(String line){
        permuteStringHelper("", line);
    }

    private static void permuteStringHelper(String first, String remaining){
        if(remaining.length() == 0){
            System.out.println(first);
            return;
        }

        for(int i = 0 ; i < remaining.length() ; i ++){
            char curr = remaining.charAt(i);
            String before = remaining.substring(0, i);
            String after = remaining.substring(i+1);
            permuteStringHelper(first + curr, before + after );
        }
    }
}
