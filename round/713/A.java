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
            HashMap<Integer, ArrayList<Integer>> nums = new HashMap<>();
            for(int i = 0; i < size; i++) {
                int cur = fr.nextInt();
                if(!nums.containsKey(cur)) {
                    nums.put(cur, new ArrayList<Integer>());
                }
                ArrayList<Integer> temp = nums.get(cur);
                temp.add(i+1);
                nums.put(cur, temp);
            }
            for(int x: nums.keySet()) {
                if(nums.get(x).size() > 1) {
                    continue;
                } else {
                    out.write(nums.get(x).get(0) + "\n");
                    break;
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
