import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class C {


   

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        for(int c = 0; c < cases; c++) {
            int size = fr.nextInt();
            int n = fr.nextInt();
            int m = fr.nextInt();
            int[] ns = new int[n];
            int[] ms = new int[m];
            for(int i = 0; i < n; i++) {
                ns[i] = fr.nextInt();
            }
            for(int i = 0; i < m; i++) {
                ms[i] = fr.nextInt();
            }

            int i = 0;
            int j = 0;
            int outmarker = 0;
            int[] outm = new int[n+m];
            boolean progress = true;
            while((i < n || j < m) && progress) {
                progress = false;
                if(i < n) {
                    if(ns[i] > 0 && ns[i] <= size) {
                        outm[outmarker] = ns[i];
                        outmarker++;
                        i++;
                        progress = true;
                    } else if(ns[i] == 0) {
                        outm[outmarker] = ns[i];
                        outmarker++;
                        i++;
                        progress = true;
                        size++;
                    }
                }
                if (j < m) {
                    if(ms[j] > 0 && ms[j] <= size) {
                        outm[outmarker] = ms[j];
                        outmarker++;
                        j++;
                        progress = true;
                        
                    } else if(ms[j] == 0) {
                        outm[outmarker] = ms[j];
                        outmarker++;
                        j++;
                        progress = true;
                        size++;
                    }
                }
            }
            if(i >= n && j >= m) {
                for(int x : outm) {
                    out.write(x + " ");
                }
                out.write("\n");
            } else {
                out.write(-1 + "\n");
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
