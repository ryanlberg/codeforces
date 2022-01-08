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
            HashMap<Integer, ArrayList<Integer>> locs = new HashMap<>();
            int nums = fr.nextInt();
            int sum = 0;
            int[] num = new int[nums];
            for(int i = 0; i < nums; i++) {
                int cur = fr.nextInt();
                if(!locs.containsKey(cur)) {
                    locs.put(cur, new ArrayList<Integer>());
                }
                locs.get(cur).add(i);
                sum += cur;
                num[i] = cur;
            }
           
        
            int total = 0;
            if((2 * sum) % nums != 0) {
                out.write(0 + "\n");
            } else {
                int newn = (2*sum)/nums;
                for(int i = 0; i < nums; i++) {
                    
                    int newneed = newn - num[i];
                    if(locs.containsKey(newneed)) {
                        ArrayList<Integer> curne = locs.get(newneed);
                        for(int j = 0; j < curne.size(); j++) {
                            if(curne.get(j) > i) {
                                total++;
                            }
                        }
                    }
                    
                }
                out.write(total + "\n");
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
