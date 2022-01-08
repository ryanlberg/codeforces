import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class C {

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        final int MOD = 998244353;
        for(int c = 0; c < cases; c++) {
            int size = fr.nextInt();
            ArrayList<Integer> nums = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                nums.add(fr.nextInt());
            }
            Collections.sort(nums);
            if(nums.get(size-1) - nums.get(size-2) >= 2) {
                out.write(0 + "\n");
            } else if(nums.get(size-1) == nums.get(size-2)) {
                out.write(npr(size, size, MOD) + "\n");
            } else {
                int secondmin = nums.get(size-2);
                int seen = 1;
                int curloc = size-3;
                while(curloc > 0 && nums.get(curloc) == secondmin) {
                    curloc--;
                    seen++;
                }
                int needed = npr(size, size, MOD);
                int canthave = (npr(seen, seen, MOD) * npr(size - seen, size-seen, MOD) * (size-1)) % MOD;
                int answer = needed - canthave;
                out.write(answer + "\n") ;

            }
        }
        out.close();
    }

    static int fact(int n, int mod) {
        int i = 1;
        
        for(int j = n; j > 1; j--) {
            i *= (j);
            i %= mod;
        }
        return i % mod;
    }

    static int npr(int n, int r, int mod) {
        return (fact(n, mod)/ fact(n-r, mod));
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
