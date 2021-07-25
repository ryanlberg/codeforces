import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class B2 {

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        for(int c = 0; c < cases; c++) {
            ArrayList<ArrayList<Integer>> nums = new ArrayList<>();
            int n = fr.nextInt();
            int k = fr.nextInt();
            int[] outnums = new int[n];
            int[] testnums = new int[n];
            HashMap<Integer, Integer> seen = new HashMap<>();
            for(int i = 0; i < n; i++) {
                ArrayList<Integer> cur = new ArrayList<>();
                int num = fr.nextInt();
                outnums[i] = num;
                cur.add(num);
                cur.add(i);
                nums.add(cur);
            }
            Collections.sort(nums, new Comparator<List<Integer>>() {
                public int compare(List<Integer> p, List<Integer> q) {
                    return Integer.compare(p.get(0), q.get(0));
                }
            });
            int fullgroups = 0;
            int group = 1;
            for(ArrayList<Integer> x : nums) {
                if(!seen.containsKey(x.get(0))) {
                    seen.put(x.get(0), 1);
                    testnums[x.get(1)] = group;
                    group = (group % k) + 1;
                    if(group == 1) {
                        fullgroups++;
                    }
                } else {
                    if(seen.get(x.get(0)) < k) {
                        seen.put(x.get(0), seen.get(x.get(0)) +1);
                        testnums[x.get(1)] = group;
                        group = (group % k) + 1;
                        if(group == 1) {
                            fullgroups++;
                        }
                    } 
                }

            }
            HashMap<Integer, Integer> fix = new HashMap<>();
            for(int i = 0; i < testnums.length; i++) {
                if(!fix.containsKey(testnums[i]) && testnums[i] != 0) {
                    fix.put(testnums[i], 1);
                } else {
                    if(testnums[i] != 0 && fix.get(testnums[i]) >= fullgroups) {
                        testnums[i] = 0;
                    } else if(testnums[i] != 0) {
                        fix.put(testnums[i], fix.get(testnums[i]) + 1);
                    }
                }
            }
            for(Integer x : testnums) {
               out.write(x + " ");
            }
            out.write("\n");
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
