import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;

public class D {


    static int ret[];

    public static void main(String[] args) {
        
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        for(int c = 0; c < cases; c++) {
            int size = fr.nextInt();
            int[] nums = new int[size];
            for(int i = 0; i < size; i++) {
                nums[i] = fr.nextInt();
            }

            ret = new int[size];
            solve(0, size, nums, 0);
            for(int i = 0; i < size; i++) {
                out.write(ret[i] + " ");
            }
            out.write("\n");

        }
        out.close();
    }

    static void solve(int i, int j, int[] nums, int depth) {
        //System.out.println(Arrays.toString(ret));
        if(i != j) {   
            //System.out.println(i + " " + j);
            int maxspot = -1;
            int maxnum = -1;
            for(int s = i; s < j; s++) {
                if (nums[s] > maxnum) {
                    maxnum = nums[s];
                    maxspot = s;
                }
            }
            //System.out.println(maxnum + " " + maxspot);
            ret[maxspot] = depth;
            solve(i, maxspot, nums, depth+1);
            solve(maxspot+1, j, nums, depth+1); 
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
