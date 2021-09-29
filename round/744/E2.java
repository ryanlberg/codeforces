import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class E2 {


   

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        
        for(int c = 0; c < cases; c++) {
            int size = fr.nextInt();
            SegmentTree seg = new SegmentTree(size+1);
            int[] nums = new int[size];
            ArrayList<Integer> tosort = new ArrayList<>();
            HashMap<Integer, Integer> map = new HashMap<>();
            long total = 0;
            for(int i = 0; i < size; i++) {
                int cur = fr.nextInt();
                nums[i] = cur;
                tosort.add(cur);
            }

            Collections.sort(tosort);
            int start = 1;
            for(int x : tosort) {
                if(!map.containsKey(x)) {
                    map.put(x, start);
                    start++;
                }
            }

            for(int i = 0; i < size; i++) {
                int num = map.get(nums[i]);
                int left = seg.sum(1, num-1);
                int right = seg.sum(num+1, size+1);
                total += Math.min(left, right);
                seg.increment(num, num, 1);
            }

            out.write(total + "\n");

        }
        out.close();
    }

    static class SegmentTree {
        int n;
        int[] lo, hi, min, delta;
    
        public SegmentTree (int n) {
            this.n = n;
            lo = new int[4*n+1];
            hi = new int[4*n+1];
            min = new int[4*n+1];
            delta = new int[4*n+1];
    
            init(1, 0, n-1);
        }
    
        public void increment(int a, int b, int val) {
            increment(1, a, b, val);
        }
    
        public int sum(int a, int b) {
            return sum(1, a, b);
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
            min[i] = min[2*i] + delta[2*i] +  min[2*i+1] + delta[2*i+1];
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
    
        int sum(int i, int a, int b) {
            if (b < lo[i] || hi[i] < a) {
                return 0;
            }
    
            if (a <= lo[i] && hi[i] <= b) {
                return min[i] + delta[i];
            }
    
            prop(i);
            int minLeft = sum(2*i, a, b);
            int minRight = sum(2*i+1, a, b);
            update(i);
    
            return minLeft + minRight;
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
