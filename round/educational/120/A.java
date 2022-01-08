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
            int one = fr.nextInt();
            int two = fr.nextInt();
            int three = fr.nextInt();
            if(one == two && two == three) {
                if(three % 2 != 0) {
                    out.write("NO\n");
                } else {
                    out.write("YES\n");
                }
            } else if(two == three) {
                if(one % 2 != 0) {
                    out.write("NO\n");
                } else {
                    out.write("YES\n");
                }
            } else if(one == two) {
                if(three % 2 != 0) {
                    out.write("NO\n");
                } else {
                    out.write("YES\n");
                }
            }
            else if(one == three) {
                if(two % 2 != 0) {
                    out.write("NO\n");
                } else {
                    out.write("YES\n");
                }
            } else {
                int[] nums = new int[]{one, two, three};
                Arrays.sort(nums);
                if(nums[0] + nums[1] != nums[2]) {
                    out.write("NO\n");
                } else {
                    out.write("YES\n");
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
