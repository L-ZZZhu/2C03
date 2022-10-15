package Q4;

class QQ4 {
    static String suffix(String A, String B){
        int[] buffer_list=intptostring(A);
        int i= A.length()<B.length() ? B.length()-A.length() : 0;
        System.out.println(buffer_list[0]);
        int j=-1;
          do {
              System.out.println(j+" "+i);
              if (A.charAt(j + 1) == B.charAt(i)) {
                  j++;
                  i++;
              } else {
                  if (j == -1) i++;
                  else if (buffer_list[j] == 0) j--;
                  else j -= buffer_list[j];
              }
          } while (i > B.length());
        return B.substring(B.length()-j-1);
    }
     static int[] intptostring(String A){
        int[] answer=new int[A.length()];
        answer[0]=0;
        for(int i=1;i<A.length();i++){
            int buffer =answer[i-1];
            if (A.charAt(i) ==A.charAt(buffer)){
                answer[i]= buffer +1;
            }
            else answer[i]=0;
            i++;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(suffix("123456789","dasdasdasdasd123456789"));
    }

}
