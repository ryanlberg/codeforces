import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class A {


   

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        for(int c = 0; c < cases; c++) {
            int size = fr.nextInt();
            int[] a = new int[size];
            int[] b = new int[size];
            int sum = 0;
            for(int i = 0; i < size; i++) {
                int cur = fr.nextInt();
                a[i] = cur;
                sum += cur;
            }
            for(int i = 0;  i < size; i++) {
                int cur = fr.nextInt();
                b[i] = cur;
                sum -= cur;
            }
            boolean can = true;
            if(sum != 0) {
                can = false;
            }
            if(!can) {
                out.write(-1 + "\n");
            } else {
                ArrayList<ArrayList<Integer>> outnums = new ArrayList<>();
                for(int i = 0; i < size; i++) {
                    if(a[i] != b[i]) {
                        while(a[i] < b[i]) {
                            ArrayList<Integer> cur = new ArrayList<>();
                            for(int j = i+1; j < size; j++) {
                                if(a[j] > b[j]) {
                                    a[i]++;
                                    a[j]--;
                                    cur.add(j+1);
                                    cur.add(i+1);
                                    break;
                                }
                            }
                            outnums.add(cur);
                        }
                        while(a[i] > b[i]) {
                            ArrayList<Integer> cur = new ArrayList<>();
                            for(int j = i+1; j < size; j++) {
                                if(a[j] < b[j]) {
                                    a[i]--;
                                    a[j]++;
                                    cur.add(i+1);
                                    cur.add(j+1);
                                    break;
                                }
                            }
                            outnums.add(cur);
                        }
                    }

                }
                out.write(outnums.size() + "\n");
                for(ArrayList<Integer> x : outnums) {
                    out.write(x.get(0) + " " + x.get(1) +  "\n");
                }
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
