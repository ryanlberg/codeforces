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
        int nums = fr.nextInt();
        int queries = fr.nextInt();
        SegmentTree st = new SegmentTree(nums);
        for(int i = 0; i < nums; i++) {
            st.increment(i, i, fr.nextInt());
        }

        for(int i = 0; i < queries; i++) {
            int a = fr.nextInt();
            int b = fr.nextInt();
            int c = fr.nextInt();
        }
        out.close();
    }

    static class SegmentTree {
        int n;
        int[] lo, hi,  delta, inRange;
    
        public SegmentTree (int n) {
            this.n = n;
            lo = new int[4*n+1];
            hi = new int[4*n+1];
            inRange = new int[4*n+1];
            inRange = new int[4*n+1];
            delta = new int[4*n+1];
    
            init(1, 0, n-1);
        }
    
        public void increment(int a, int b, int val) {
            increment(1, a, b, val);
        }
    
        public int totalInRange(int a, int b) {
            return totalInRange(1, a, b);
        }
    
        void init(int i, int a, int b) {
            lo[i] = a;
            hi[i] = b;
            
            if (a == b) return;
    
            int mid = (a+b)/2;
    
            init(2*i, a, mid);
            init(2*i+1, mid+1, b);
        }
        
        void prop(int i) {
            delta[2*i] += delta[i];
            delta[2*i + 1] += delta[i];
            delta[i] = 0;
        }
    
        void update(int i) {
            inRange[i] = inRange[2*i] + delta[2*i] + inRange[2*i+1] + delta[2*i+1];
           
        }
    
        void increment(int i, int a, int b, int val) {
            //no cover
            if (b < lo[i] || a > hi[i]) return;
    
            //full cover
            if (a <= lo[i] && b >= hi[i]) {
                delta[i] += val;
                return;
            }
            //partial cover
            prop(i);
            increment(2*i, a, b, val);
            increment(2*i+1, a, b, val);
            update(i);
        }
    
        int[]  (int i, int a, int b) {
            if (b < lo[i] || hi[i] < a) {
                return Integer.MAX_VALUE;
            }
    
            if (a <= lo[i] && hi[i] <= b) {
                return min[i] + delta[i];
            }
    
            prop(i);
            int minLeft = minimum(2*i, a, b);
            int minRight = minimum(2*i+1, a, b);
            update(i);
    
            return Math.min(minLeft, minRight);
        }

        int maximum(int i, int a, int b) {
            if (b < lo[i] || hi[i] < a) {
                return Integer.MAX_VALUE;
            }
    
            if (a <= lo[i] && hi[i] <= b) {
                return min[i] + delta[i];
            }
    
            prop(i);
            int maxLeft = maximum(2*i, a, b);
            int maxRight = maximum(2*i+1, a, b);
            update(i);
    
            return Math.max(maxLeft, maxRight);
        }

        int[] totalInRange(int i, int a, int b) {
            if (b < lo[i]){
                return new int[]{0, 0, 0};
            }
            if (hi[i] < a) {
                return new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, 0};
            }
    
            if (a <= lo[i] && hi[i] <= b) {
                return new int[]{}
            }
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
