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
            int[] nums = new int[size];
            int[] tosort = new int[size];
            ArrayList<int[]> sequens = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                int cur = fr.nextInt();
                nums[i] = cur;
                tosort[i] = cur;
            }

            Arrays.sort(tosort);

            for(int i = 0; i < tosort.length; i++) {

                if(nums[i] != tosort[i]) {
                    int j = i;
                    while(nums[j] != tosort[i]) {
                        j++;
                    }

                    sequens.add(new int[]{i+1, j+1, j-i});
                    shift(nums, i, j);
                }
            }

            out.write(sequens.size() + "\n");
            for(int[] x : sequens) {
                out.write(x[0] + " " + x[1] + " " + x[2] + "\n");
            }
        }
        out.close();
    }

    static void shift(int[] nums, int start, int end) {
        int temp = nums[end];
        for(int i = start; i <= end; i++) {
            int x = nums[i];
            nums[i] = temp;
            temp = x;
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
