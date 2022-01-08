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
            ArrayList<Integer> nums = new ArrayList<>();
            HashSet<Integer> curnums = new HashSet<>();
            for(int i = 0; i < size; i++) {
                int cur = fr.nextInt();
                curnums.add(cur);
                nums.add(cur);
            }

            Collections.sort(nums);

            int[][] ret = new int[size/2][2];
            int len = 0;
            for(int i = 0; i < size; i++) {
                for(int k = i+1; k < size; k++) {
                    ret[len][0] = nums.get(k);
                    ret[len][1] = nums.get(i);
                    len++;
                    if(len >= ret.length) {
                        break;
                    }
                }
                if(len >= ret.length) {
                    break;
                }
            }

            for(int[] x : ret) {
                out.write(x[0] + " " + x[1] + "\n");
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
