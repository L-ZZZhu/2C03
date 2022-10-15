package Q4;

import java.util.ArrayList;
import java.util.HashMap;

public class Q4 {
        static HashMap<Integer,String> Search(String A, String B){
            HashMap<Integer,String> answer=new HashMap<>();
            for (int i=1;i<Math.min(A.length(),B.length());i++){
                KMPSearch(A.substring(0,i),B,answer);
            }
            return answer;
        }
        static void KMPSearch(String A, String B,HashMap<Integer,String> answer) {
            int[] buffer_int_list = new int[A.length()];
            LPSintlist(A, A.length(), buffer_int_list);
            int i=0,j = 0;
            while (i < B.length()) {
                if (A.charAt(j) == B.charAt(i)) {
                    j++;
                    i++;
                }
                if (j == A.length()){
                    if ((i-j)+A.length()==B.length()){// check is that is suffix of String B
                    answer.put((i-j),B.substring((i-j),(i-j)+A.length()));
                    //Integer show the located of String B and String show the same part of String B
                    }
                    j = buffer_int_list[j - 1];
                }
                else if (i < B.length() && A.charAt(j) != B.charAt(i)) {
                    if (j != 0) j = buffer_int_list[j - 1];
                    else i ++;
                }
            }
        }

        static void LPSintlist(String buffer_string, int length, int[] buffer_int_list) {
            int buffer_number = 0,i=1;
            buffer_int_list[0] = 0;
            while (i< length) {
                if (buffer_string.charAt(i) == buffer_string.charAt(buffer_number)) {
                    buffer_number++;
                    buffer_int_list[i] = buffer_number;
                    i++;
                }
                else{
                    if (buffer_number != 0) buffer_number = buffer_int_list[buffer_number - 1];
                    else {
                        buffer_int_list[i] = buffer_number;
                        i++;
                    }
                }
            }
        }
        public static void main(String[] args)
        {
            String txt = "dasdasdasdasd123456721";
            String pat = "123456781dasdasdasdasdasdasdas";
            System.out.println(Search(pat, txt));
        }
    }


