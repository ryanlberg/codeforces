import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class B {
 
 
   
 
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        for(int c = 0; c < cases; c++) {
            int size = fr.nextInt();
            char[] cur = fr.next().toCharArray();
            StringBuilder ret = new StringBuilder();
            ret.append(cur[0]);
            int i = 1;
            int stopped = 0;
            for(; i < cur.length; i++) {
                if(cur[i] < cur[i-1]) { 
                   
                    ret.append(cur[i]);
                } 
                if(cur[i] == cur[i-1]) {

                }
                else {
                    break;
                }
            }
            
            
            int count = 0;
            while(i < cur.length && count+1 < stopped) {
                if(cur[i] == cur[i-1]) {
                    ret.append(cur[i]);
                    count++;
                }
                i++;
            }
           
 
            out.write(ret.toString() + ret.reverse().toString() + "\n"); 
 
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