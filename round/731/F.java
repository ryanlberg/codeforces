import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class F {


   

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        for(int c = 0; c < cases; c++) {
            int size = fr.nextInt();
            int[] tree = new int[size*2];
            for(int i = 0; i < size; i++) {
                int cur = fr.nextInt();
                tree[i] = cur;
                tree[i+size] = cur;
            }

            segtree l = new segtree(tree);
            out.write(search(l, 0, size-1, size) + "\n");
        }
        out.close();
    }

    static int search(segtree l, int start, int end, int size) {
        if (start == end && end == size-1) {
            return end;
        }
        int mid = (end + start) / 2;
        int[] test = new int[size];
        for(int i = 0; i < size; i++) {
            test[i] = l.getgcd(i, i+mid);
        }
        if(cand(test)) {
            if(start == end) {
                return start;
            }
            return search(l, start, mid, size);
        } 
        return search(l, mid+1, end, size);
    }

    static boolean cand(int[] test) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int i = 0 ; i < test.length; i++) {
            min = Math.min(min, test[i]);
            max = Math.max(max, test[i]);
        }
        return min == max;
    }

    static class segtree {
        int n;
        int[] lo, hi, gcds, needed;

        public segtree(int[] needed) {
            this.n = needed.length;
            lo = new int[4*n+1]; // low end of range for node i
            hi = new int[4*n+1]; // high end of range for node i
            gcds = new int[4*n+1];
            this.needed = needed;
            init(1, 0, n-1);
            // for(int x: gcds) {
            //     System.out.print(x + " ");
            // }
            // System.out.println("");
        }

        public int getgcd(int a, int b) {
            return getgcd(1, a, b);
        }

        int getgcd(int i, int a, int b) {
            if(b < lo[i] || hi[i] < a) {
                return -1;
            }
            if(a <= lo[i] && hi[i] <= b) {
                return gcds[i];
            }

            int left = getgcd(2*i, a, b);
            int right = getgcd(2*i+1, a, b);
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

    static int gcd(int a, int b) {
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
