import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
public class B {


   

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        for(int c = 0; c < cases; c++) {
            int size = fr.nextInt();
            int[][] nums = new int[size][2];
            for(int i = 0; i < size; i++) {
                nums[i] = new int[]{fr.nextInt(), i};
            }
            Deque<int[]> ret = new LinkedList<>();
            ret.add(new int[]{0, -1});
            nums = sort(nums);
            BigInteger total = new BigInteger("0");
            int i = 0;
            int lr = 1; 
            while(i < size) {
                long toadd = 2 * lr * (long)nums[i][0];
                total = total.add(new BigInteger(Long.toString(toadd)));
                ret.addLast(new int[]{nums[i][1]+1, lr});
                i++;
                if(i >= size) {
                    break;
                }
                toadd = 2 * lr * (long)nums[i][0];
                total = total.add(new BigInteger(Long.toString(toadd)));
                ret.addFirst(new int[]{nums[i][1]+1, -lr});
                i++;
                lr++;
            }

            out.write(total.toString() + "\n");
            int[] re = new int[size+1];
           
            while(ret.size() > 0) {
                int[] cur = ret.pollFirst();
                if(cur[0] == 0) {
                   continue;
                } else {
                    re[cur[0]] = cur[1];
                }
            }
            for(int f = 0; f < re.length; f++) {
                out.write(re[f] + " ");
            }
            out.write("\n");
        }
        out.close();
    }

    static int[][] sort(int[][] nums) {
        ArrayList<int[]> num = new ArrayList<>();
        for(int[] x : nums) num.add(x);
        Collections.sort(num, (a, b) -> -Integer.compare(a[0], b[0]));
        for(int i = 0; i < num.size(); i++) {
            nums[i] = num.get(i);
        }
        return nums;
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
