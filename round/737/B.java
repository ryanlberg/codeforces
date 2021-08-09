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
            int n = fr.nextInt();
            int k = fr.nextInt();
            int[] nums = new int[n];
            for(int i = 0; i < n; i++) {
                nums[i] = fr.nextInt();
            }

            int inversions = 0;
            int sorted[] = sorted(nums);
            HashMap<Integer, Integer> numlocs = new HashMap<>();
            for(int i = 0; i < sorted.length; i++) {
                numlocs.put(sorted[i], i);
            }

            for(int i = 1; i < n; i++) {
                if(nums[i] < nums[i-1] || numlocs.get(nums[i]) != (numlocs.get(nums[i-1]) + 1)) {
                    inversions++;
                }
            }

            if(inversions + 1 > k) {
                out.write("NO\n");
            } else {
                out.write("YES\n");
            }

            
        }
        out.close();
    }

    static int[] sorted(int[] nums) {
        ArrayList<Integer> newnums = new ArrayList<>();
        for(int i = 0 ; i < nums.length; i++) {newnums.add(nums[i]);}
        Collections.sort(newnums);
        int ret[] = new int[nums.length];
        for(int i = 0 ;i < nums.length; i++) {ret[i] = newnums.get(i);}
        return ret;
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
