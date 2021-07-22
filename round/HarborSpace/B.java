import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class B {


   
    static char[] table;
    static char[] test;
    static HashMap<Character, ArrayList<Integer>> locs;
    static boolean movedleft;
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        movedleft = false;
        for(int c = 0; c < cases; c++) {
            table = fr.next().toCharArray();
            test = fr.next().toCharArray();
            locs = new HashMap<>();
            for(int i = 0; i < table.length; i++) {
                if(!locs.containsKey(table[i])) {
                    locs.put(table[i], new ArrayList<Integer>());
                } 
                locs.get(table[i]).add(i);
                
            }
            boolean cando = solve();
            if(cando) {
                out.write("YES\n");
            } else {
                out.write("NO\n");
            }
        }
        out.close();
    }

    static boolean solve() {
        if(!locs.containsKey(test[0])) {
            return false;
        }
        ArrayList<Integer> startlocs = locs.get(test[0]);
        for(int x : startlocs) {
            //System.out.println("here");
            movedleft = false;
            if(cansolve(x, 0)) {
                return true;
            }
        }
        return false;
    }

    static boolean cansolve(int x, int testloc) {
        //System.out.println(x + ", " + testloc);
        if(x < 0 || x >= table.length) {
            return false;
        }
        if(testloc == test.length - 1 && test[testloc] == table[x]) {
            return true;
        }
        if(table[x] == test[testloc]) {
            boolean a = false;
            if(!movedleft) {
                a = cansolve(x+1, testloc+1);
            }
            movedleft = true;
            boolean b = cansolve(x-1, testloc+1);
            if(a || b) {
                return true;
            }
        }
        return false;
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
