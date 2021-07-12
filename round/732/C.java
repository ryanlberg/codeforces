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
            HashMap<Integer, Integer> evens = new HashMap<>();
            HashMap<Integer, Integer> odds = new HashMap<>();
            ArrayList<Integer> nums = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                int cur = fr.nextInt();
                if(!evens.containsKey(cur)) {
                    evens.put(cur, 0);
                }
                if(!odds.containsKey(cur)) {
                    odds.put(cur, 0);
                }
                if(i % 2 == 0) {    
                    evens.put(cur, evens.get(cur) +1);
                } else {
                    odds.put(cur, odds.get(cur) +1 );
                }
                nums.add(cur);
            }
            Collections.sort(nums);
            for(int i = 0; i < size; i++) {
                if(i % 2 == 0) {
                    evens.put(nums.get(i), evens.get(nums.get(i)) - 1);
                } else {
                    odds.put(nums.get(i), odds.get(nums.get(i))-1);
                }
            }
            boolean cando = true;
            for(int x : evens.keySet()) {
                if(evens.get(x) != 0) {
                    cando = false;
                    break;
                }
            }
            for(int x : odds.keySet()) {
                if(odds.get(x) != 0) {
                    cando = false;
                    break;
                }
            }
            if(cando) {
                out.write("Yes\n");
            } else {
                out.write("No\n");
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
