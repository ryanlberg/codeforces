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
            ArrayList<ArrayList<Integer>> ordering = new ArrayList<>();
            int caves = fr.nextInt();
            for(int i = 0; i < caves; i++) {
                ArrayList<Integer> in_and_size = getStartNeeded(fr);
                ordering.add(in_and_size);
            }

            Collections.sort(ordering, new Comparator<ArrayList<Integer>> () {
                public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                    int test = a.get(0).compareTo(b.get(0));
                    if(test == 0) {

                        return -a.get(1).compareTo(b.get(1));
                    }
                    return test;
                 }
            });


            out.write(getMin(ordering) + "\n");
        }
        out.close();
    }

    static int getMin(ArrayList<ArrayList<Integer>> ordering) {
        int min = ordering.get(0).get(0);
        int current = min + ordering.get(0).get(1);
        int monstersseen = ordering.get(0).get(1);
        for(int i = 1; i < ordering.size(); i++) {
            ArrayList<Integer> curcave = ordering.get(i);
            if(curcave.get(0) > current) {
                min = curcave.get(0)-monstersseen;
               
            }
            current = min + monstersseen+curcave.get(1);
            monstersseen += curcave.get(1);
        }

        return min;
    }
    static ArrayList<Integer> getStartNeeded(FastReader fr) {
        ArrayList<Integer> out = new ArrayList<>();
        int monsters = fr.nextInt();
        int inNeeded = 0;
        for(int i = 0; i < monsters; i++) {
            int current = fr.nextInt();
            inNeeded = Math.max(inNeeded, current - i + 1);
        }
        out.add(inNeeded);
        out.add(monsters);
        return out;
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
