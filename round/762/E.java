import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class E {


   

    static int cando(int i, int sum, int[] counts) {
        int[] tempcounts = new int[counts.length];
        for(int j= 0; j < counts.length; j++) {
            tempcounts[j] = counts[j];
        }
        int needed = counts[i];
        if(i == 0) {
            return counts[i];
        } else {
            if(sum < i) {
                return -1;
            }
            boolean cand = true;
            for(int j = i-1; j >= 0; j--) {
                if(tempcounts[j] == 0) {
                    for(int k = j-1; k >= 0; k--) {
                        if(tempcounts[k] > 1) {
                            needed += j - k;
                            tempcounts[j]++;
                            tempcounts[k]--;
                            break;
                        }
                    }
                }
                if(tempcounts[j] == 0) {
                    cand = false;
                    break;
                }
            }
            if(!cand) {
                return -1;
            }
            return needed;
        }
       
    }
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        for(int c = 0; c < cases; c++) {
            int size = fr.nextInt();
            int[] nums = new int[size];
            int[] counts = new int[size+1];
            int[] ret = new int[size+1];
            Arrays.fill(ret, -1);
            for(int i = 0; i < size; i++) {
                int cur = fr.nextInt();
                counts[cur]++;
                nums[i] = cur;
            }
            int sum = 0;
            for(int i = 0; i <= size; i++) {
               
                if(i > 0 && ret[i-1] == -1) {
                    break;
                }

                ret[i] = cando(i, sum, counts);
                sum += counts[i];
               
            }
            for(int i = 0; i < ret.length; i++) {  
                out.write(ret[i] + " ");
            
            }
            out.write("\n");
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
