import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class A {

    public static void main(String[] args) {
        
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        for(int c = 0; c < cases; c++) {
            int size = fr.nextInt();
            ArrayList<Integer> nums = new ArrayList<Integer>();
            HashSet<Integer> seen = new HashSet<Integer>();
            
            for(int i = 0; i < size; i++) {
                int num = fr.nextInt();
                nums.add(num);
                seen.add(num);
            }

            Queue<Integer> toadd = new LinkedList<Integer>();
            for(int i = 0; i < size; i++) {
                for(int j = i+1; j < size; j++) {
                    int needed = Math.abs(nums.get(i) - nums.get(j));
                    if (!seen.contains(needed)) {
                        seen.add(needed);
                        toadd.add(needed);
                    }
                }
            }

            while(toadd.size() > 0 && nums.size() < 301) {
                int adding = toadd.poll();
                for(int i = 0; i < nums.size(); i++) {
                    int needed = Math.abs(nums.get(i) - adding); 
                    if(!seen.contains(needed)) {
                        seen.add(needed);
                        toadd.add(needed);
                    }
                }
                nums.add(adding);
            }

            if (nums.size() > 300) {
                out.write("NO\n");
            } else {
                out.write("YES\n");
                out.write(nums.size() + "\n");
                for(Integer x : nums) {
                    out.write(x + " ");
                }
                out.write("\n");
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
