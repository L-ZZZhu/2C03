package Q4;

class Longest_suffix_check {
    static int check(String x, String y){
        if (x.equals(y)) return x.length();
        int answer=0;
        for (int i=1;i<Math.min(x.length(),y.length())+1;i++){
            if (x.substring(0,i).equals(y.substring(y.length()-i,y.length()))) answer=i;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(check("basbcb","sdsadasdaaasbcbbasbcbbasbcb"));
    }
}
