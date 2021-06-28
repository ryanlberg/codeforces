import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
public class E {


    public static void main(String[] args) {
        
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        for(int c = 0; c < cases; c++) {
            int size = fr.nextInt();
            HashMap<Integer, Integer> counts = new HashMap<>();
            int maxcount = 0;
            for(int i = 0; i < size; i++) {
                int num = fr.nextInt();
                if(!counts.containsKey(num)) {
                    counts.put(num, 1);
                } else {
                    counts.put(num, counts.get(num)+1);
                }
                maxcount = Math.max(maxcount, counts.get(num));
            }

            int minremoves = Integer.MAX_VALUE;
            HashSet<Integer> seen = new HashSet<>();
            for(Integer k: counts.keySet()) {
                int i = counts.get(k);
                if(seen.contains(i)) {
                    continue;
                } else {
                    seen.add(i);
                }
                int removes = 0;
                for(Integer key: counts.keySet()) {
                    int val = counts.get(key);
                    if (val >= i) {
                        removes += (val - i);
                    } else {
                        removes += val;
                    }
                }
                minremoves = Math.min(minremoves, removes);
            }
            out.write(minremoves + "\n");
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
