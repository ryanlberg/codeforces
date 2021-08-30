import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class B {


   

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        for(int c = 0; c < cases; c++) {
            int size = fr.nextInt();
            int[] nums = new int[size];
            Queue<Integer> evenlocs = new PriorityQueue<>();
            Queue<Integer> oddlocs = new PriorityQueue<>();
            Queue<Integer> othereven = new PriorityQueue<>();
            Queue<Integer> otherodd = new PriorityQueue<>();
            for (int i = 0; i < size; i++) {
                int curnum = fr.nextInt() % 2;
                nums[i] = curnum;
                if(curnum == 0) {
                    evenlocs.add(i);
                    othereven.add(i);
                } else {
                    oddlocs.add(i);
                    otherodd.add(i);
                }
            }

            if(Math.abs(evenlocs.size() - oddlocs.size()) > 1) {
                out.write(-1 + "\n");
            } else {
                out.write(solve(nums, evenlocs, oddlocs, othereven, otherodd) + "\n");
            }
        }
        out.close();
    }


    static int solve(int[] nums, Queue<Integer> evenlocs, Queue<Integer> oddlocs, Queue<Integer> othereven, Queue<Integer> otherodd) {
        if(evenlocs.size() > oddlocs.size()) {
            return solveHelper(nums, evenlocs, oddlocs, 0);
        } else if(oddlocs.size() > evenlocs.size()) {
            return solveHelper(nums, oddlocs, evenlocs, 1);
        } else {
            if(nums[0] == 0) {
                int[] othernums = Arrays.copyOf(nums, nums.length);
                return Math.min(solveHelper(nums, evenlocs, oddlocs, 0), solveHelper(othernums, otherodd, othereven, 1));
            } else {
                int[] othernums = Arrays.copyOf(nums, nums.length);
                return Math.min(solveHelper(nums, oddlocs, evenlocs, 1), solveHelper(othernums, othereven, otherodd, 0));
            }
        }
    }

    static int solveHelper(int[] nums, Queue<Integer> startnums, Queue<Integer> others, int parity) {

        int swaps = 0;
        int curpar  = parity;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != curpar) {
                if (nums[i] == parity) {
                    while(others.peek() <= i) {
                        others.poll();
                    }
                    int needed = others.poll();
                   
                    swaps += needed - i; 
                    nums[needed] = curpar ^ 1;
                    startnums.add(needed);

                } else {
                    while(startnums.peek() <= i) {
                        startnums.poll();
                    }
                    
                    int needed = startnums.poll();
                    
                    swaps += needed - i; 
                    nums[needed] = curpar ^ 1;
                    others.add(needed);
                }
            }
            
           curpar ^= 1;
        }
        return swaps;
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
