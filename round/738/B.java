import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class B {


   
    static String seen;
    static int min;
    static HashMap<Integer, String> seens;
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        for(int c = 0; c < cases; c++) {
            int size = fr.nextInt();
            String cur = fr.next();
            String one = "";
            String two = "";
            int sone = 0;
            int stwo = 0;
            int length = 0;
            for (int i = 0; i < size; i++) {
                if (i == 0) {
                    if(cur.charAt(i) == '?') {
                        one += "R";
                        two += "B";
                    } else {
                        one += cur.charAt(i);
                        two += cur.charAt(i);
                    }
                } else {
                    if(cur.charAt(i) == '?') {
                        if (one.charAt(length-1) == 'B') {
                            one += "R";
                        } else {
                            one += "B";
                        }
                        if(two.charAt(length-1) == 'B') {
                            two += "R";
                        } else {
                            two += "B";
                        }
                    } else {
                        if(cur.charAt(i) == 'B') {
                            if(one.charAt(length-1) == 'B') {
                                sone++;
                            }
                            if(two.charAt(length-1) == 'B') {
                                stwo++;
                            }
                            one += "B";
                            two += "B";
                        } else {
                            if(one.charAt(length-1) == 'R') {
                                sone++;
                            }
                            if(two.charAt(length-1) == 'R') {
                                stwo++;
                            }
                            one += "R";
                            two += "R";
                        }
                    }
                }
                length++;
            }  
            if(sone <= stwo) {
                out.write(one + "\n");
            } else {
                out.write(two + "\n");
            }
        }
        out.close();
    }

    

    static class FastReader {

        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            this.br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() { 
            while (st == null || !st.hasMoreElements()) {
                try{
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }

        long nextLong() { return Long.parseLong(next()); }

        double nextDouble() { return Double.parseDouble(next()); }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
