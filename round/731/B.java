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
            String s = fr.next();
            int a = -1;
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == 'a') {
                    a = i;
                    break;
                }
            }
            if(a == -1) {
                out.write("No\n");
                continue;
            } else {
                int l = a-1;
                int r = a+1;
                char letter = 'b';
                while(l >= 0 || r < s.length()) {
                    if(l >= 0 && s.charAt(l) == letter) {
                        l -= 1;
                        letter = (char)((int)letter+ 1);
                    } else if(r < s.length() && s.charAt(r) == letter) {
                        r += 1;
                        letter = (char)((int)letter+1);
                    } else {
                        break;
                    }
                }
                if(l < 0 && r >= s.length()) {
                    out.write("YES\n");
                } else {
                    out.write("NO\n");
                }
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
