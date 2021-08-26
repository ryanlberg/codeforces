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
        for(int c = 0; c < cases; c++) {
            int size = fr.nextInt();
            int queries = fr.nextInt();
            String charges = fr.next();
            SegmentTree tree = new SegmentTree(size);
            for(int i = 0; i < size; i++) {
                if(charges.charAt(i) == '+') {
                    tree.increment(i, i, 1);
                } else {
                    tree.increment(i, i, -1);
                }
            }

            for(int i = 0; i < queries; i++) {
                int left = fr.nextInt();
                int right = fr.nextInt();
                out.write(Math.abs(tree.sum(left-1, right)) + "\n");
            }
            
        }
        out.close();
    }


    static class SegmentTree {
        int n;
        int[] lo, hi, sum, delta;
    
        public SegmentTree (int n) {
            this.n = n;
            lo = new int[4*n+1];
            hi = new int[4*n+1];
            sum = new int[4*n+1];
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
            sum[i] = sum[2*i] + delta[2*i] + sum[2*i+1] + delta[2*i+1];
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
                return sum[i] + delta[i];
            }
    
            prop(i);
            int sumLeft = sum(2*i, a, b);
            int sumRight = sum(2*i+1, a, b);
            update(i);
    
            return sumLeft + sumRight;
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
