import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class A {


   

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        for(int c = 0; c < cases; c++) {
            String S = fr.nextLine();
            String T = fr.nextLine();
            int[] counts = new int[26];
            for(int i = 0; i < S.length(); i++) {
                counts[S.charAt(i) - 'a']++;
            }
            if(!T.equals("abc") || counts['a' - 'a'] == 0 || counts['b' - 'a'] == 0 || counts['c' - 'a'] == 0) {
                char[] output = S.toCharArray();
                Arrays.sort(output);
                out.write(new String(output)+ "\n");
                
            } else {
               String ret = "";
               while(counts[0] > 0) {
                   ret += "a";
                   counts[0]--;
               } 
               while(counts[2]  > 0) {
                   ret += "c";
                   counts[2]--;
            
               } while(counts[1] > 0) {
                   ret += "b";
                   counts[1]--;
               }
               for(int i = 3; i < counts.length; i++) {
                    while(counts[i] > 0) {
                        ret += (char)('a' + i);
                        counts[i]--;
                    }
               }
               out.write(ret + "\n");
               
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
