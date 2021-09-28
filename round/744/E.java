import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class E {


   

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
            Deque<Integer> ret = new LinkedList<>();
            for(int i = 0; i < size; i++) {
                if(ret.size() == 0) {
                    ret.addFirst(nums[i]);
                } else {
                    if(ret.peekFirst() < nums[i]) {
                        ret.addLast(nums[i]);
                    } else {
                        ret.addFirst(nums[i]);
                    }
                }
            }

            while(ret.size() > 0) {
                out.write(ret.pollFirst() + " ");
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
