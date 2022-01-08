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
            int size = fr.nextInt();
            String word = fr.next();
            int[][] holder = new int[size+1][2];
            for(int i = 0; i < holder.length; i++) {
                holder[i] = new int[2];
            }
            for(int i = 0; i < size; i++) {
                
                if(word.charAt(i) == 'a') {
                    holder[i+1][0]++;
                } else {
                    holder[i+1][1]++;
                }
                holder[i+1][0] += holder[i][0];
                holder[i+1][1] += holder[i][1];
            }

            boolean cando = false;

            int start = -1;
            int end = -1;
            for(int i = 1; i < holder.length; i++) {
                for(int j = i+1; j < holder.length; j++) {
                    if(holder[j][0] - holder[i-1][0] == holder[j][1] - holder[i-1][1]) {
                        start = i;
                        end = j;
                        cando = true;
                        break;
                    }
                }
                if(cando) {
                    break;
                }
            }

            out.write(start + " " + end + "\n");
            
            
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
