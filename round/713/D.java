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
            ArrayList<Long> nums = new ArrayList<Long>();
            long sum = 0;
            for(int i = 0; i < size+2; i++) {
                long cur = fr.nextLong();
                nums.add(cur);
                sum += cur;
            }
            Collections.sort(nums);
            HashSet<Integer> notneeded = new HashSet<>();
            boolean found = false;
            for(int i = 0; i < nums.size()-1; i++) {
                for(int j = i+1; j < nums.size(); j++) {
                    long newsum = sum - nums.get(i) - nums.get(j);
                    if(newsum == nums.get(i) || newsum == nums.get(j)){
                        notneeded.add(i);
                        notneeded.add(j);
                        found = true;
                        break;
                    }
                    
                }
                if(found) {
                    break;
                }
            }
            if(found) {
                for(int i = 0; i < nums.size(); i++) {
                    if(!notneeded.contains(i)) {
                        out.write(nums.get(i) + " ");
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
