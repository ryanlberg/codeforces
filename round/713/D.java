import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class D {


   

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        for(int c = 0; c < cases; c++) {
            int size = fr.nextInt();
            long [] nums = new long[size+2];
            long sum = 0;
            HashMap<Long, ArrayList<Integer>> seen = new HashMap<>();
            for(int i = 0; i < size+2; i++) {
                long cur = fr.nextLong();
                nums[i] = cur;
                if(!seen.containsKey(cur)) {
                    seen.put(cur, new ArrayList<Integer>());
                }
                seen.get(cur).add(i);
                sum += cur;
            }
            boolean found = false;
            HashSet<Integer> notneeded = new HashSet<>();
            for(int i = 0; i < nums.length; i++) {
                long val = sum - nums[i];
                long total = val/2;
                //System.out.println(sum + ", " + " " + val + " " + total + " " + seen.containsKey(total));
                if(val % 2 == 0 && seen.containsKey(total)) {
                    ArrayList<Integer> test = seen.get(total);
                    if(total == nums[i]) {
                        if(test.size() >= 2) {
                            found = true;
                            notneeded.add(test.get(0));
                            notneeded.add(test.get(1));
                            break;
                        }
                    } else {
                        found = true;
                        notneeded.add(i);
                        notneeded.add(test.get(0));
                        break;
                    }
                }
            }
           

            if(found) {
                for(int i = 0; i < nums.length; i++) {
                    if(!notneeded.contains(i)) {
                        out.write(nums[i] + " ");
                    }
                }
                out.write("\n");
            } else {
                out.write("-1" + "\n");
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
