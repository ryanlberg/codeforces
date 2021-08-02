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
            long[] nums = new long[size];
            for(int i = 0; i < size; i++) {
                nums[i] = fr.nextLong();
            }

            long[] subs = new long[size-1];
            for(int i = 0 ;i < size-1; i++) {
                subs[i] = Math.abs(nums[i] - nums[i+1]);
            }
            

            int max = 1;

            
            int i = 0;
            int j = 0;
            if(nums.length > 1) {
                segtree tree = new segtree(subs);
                while(j < size-1) {
                    if(i == j) {
                        j++;
                    }
                    else if(i != j && tree.getgcd(i, j-1) > 1) {
                        max = Math.max(max, j-i+1);
                        j++;
                    } else {
                        i++;
                    }
                }
                

                if(tree.getgcd(i, j-1) > 1) {
                    max = Math.max(max, j-i+1);
                }
            }   
            out.write(max + "\n");
            
        }
        out.close();
    }

    static class segtree {
        int n;
        int[] lo, hi;
        long[] gcds;
        long[] needed;

        public segtree(long[] needed) {
            this.n = needed.length;
            lo = new int[4*n+1]; // low end of range for node i
            hi = new int[4*n+1]; // high end of range for node i
            gcds = new long[4*n+1];
            this.needed = needed;
            init(1, 0, n-1);
            // for(int x: gcds) {
            //     System.out.print(x + " ");
            // }
            // System.out.println("");
        }

        public long getgcd(int a, int b) {
            return getgcd(1, a, b);
        }

        long getgcd(int i, int a, int b) {
            if(b < lo[i] || hi[i] < a) {
                return -1;
            }
            if(a <= lo[i] && hi[i] <= b) {
                return gcds[i];
            }

            long left = getgcd(2*i, a, b);
            long right = getgcd(2*i+1, a, b);
            if(left != -1 && right != -1) {
                return gcd(left, right);
            }
            if(left == -1) {
                return right;
            }
            return left;
        }
        
        void init(int i, int l, int r) {
            lo[i] = l;
            hi[i] = r;

            if(l == r) {
                gcds[i] = needed[l];
                return;
            }

            int m = (l+r)/2;
            init(2*i, l, m);
            init(2*i+1, m+1, r);
            update(i);
        }

        void update(int i) {
            gcds[i] = gcd(gcds[2*i], gcds[2*i+1]);
        }

    }

    static long gcd(long a, long b) {
        if(b == 0) {
            return a;
        }
        return gcd(b, a % b);
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
