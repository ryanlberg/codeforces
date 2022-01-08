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
        int len = fr.nextInt();
        int queries = fr.nextInt();
        char[] next = fr.next().toCharArray();
        int abcs = 0;
        for(int i = 0; i < len-2; i++) {
            if(next[i] == 'a' && next[i+1] == 'b' && next[i+2] == 'c') {
                abcs++;
                i += 2;
            }
        }
        
        for(int i = 0; i < queries; i++) {
            int loc = fr.nextInt()-1;
            char replace = fr.next().charAt(0);
            if(next[loc] != replace) {
                if(next[loc] == 'a') {
                    if(loc < len-2) {
                        if(next[loc+1] == 'b' && next[loc+2] == 'c') {
                            abcs--;
                        }
                    }

                } else if(next[loc] == 'b') {
                    if(loc >= 1 && loc <  len-1) {
                        if(next[loc-1] == 'a' && next[loc+1] == 'c') {
                            abcs--;
                        }
                    }
                } else if(next[loc] == 'c') {
                    if(loc >= 2) {
                        if(next[loc-1] == 'b' && next[loc-2] == 'a') {
                            abcs--;
                        }
                    }
                }
                if(replace == 'a') {
                    next[loc] = 'a' ;
                    if(loc < len-2) {
                        if(next[loc+1] == 'b' && next[loc+2] == 'c') {
                            abcs++;
                        }
                    }

                } else if(replace == 'b') {
                    next[loc] = 'b';
                    if(loc >= 1 && loc < len-1) {
                        if(next[loc-1] == 'a' && next[loc+1] == 'c') {
                            abcs++;
                        }
                    }
                } else if(replace == 'c') {
                    next[loc] = 'c';
                    if(loc >= 2) {
                        if(next[loc-1] == 'b' && next[loc-2] == 'a') {
                            abcs++;
                        }
                    }
                }
            }
            System.out.println(abcs);
        }
        
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
