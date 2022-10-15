package Q4;

// Following program is a Java implementation
// of Rabin Karp Algorithm given in the CLRS book

public class main
{
    // d is the number of characters in the input alphabet
    public final static int d = 256;

    /* pat -> pattern
        txt -> text
        q -> A prime number
    */
    static int search(String pat, String txt, int q) {
        int M = pat.length();
        int N = txt.length();
        int i, j;
        int p = 0;
        int t = 0;
        int h = 1;
        for (i = 0; i < M-1; i++) h = (h*d)%q;
        for (i = 0; i < M; i++){
            p = (d*p + pat.charAt(i))%q;
            t = (d*t + txt.charAt(i))%q;
        }
        for (i = 0; i <= N - M; i++) {
            if ( p == t ) {
                for (j = 0; j < M; j++) {
                    if (txt.charAt(i+j) != pat.charAt(j)) break;
                }
                if (j == M) {
                    System.out.println(i+" "+txt.length()+" "+pat.length());
                    if (txt.length()!=pat.length()-i) return 0;
                    else {
                        System.out.println("sdasd");
                        return pat.length()-txt.length();
                    }
                }
            }
            if ( i < N-M ) {
                t = (d*(t - txt.charAt(i)*h) + txt.charAt(i+M))%q;
                if (t < 0)
                    t = (t + q);
            }
        }
        return -1;
    }

    public static void main(String[] args)
    {
        String txt = "GEEKS FOR GEEKS";
        String pat = "GEEKS";
        int q = 3;
        System.out.println(search(pat, txt, q));
    }
}
