import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
public class A {


   

    public static void main(String[] args) {
        
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        for(int c = 0; c < cases; c++) {
            int rows = fr.nextInt();
            int cols = fr.nextInt();
            ArrayList<ArrayList<Integer>> locs = new ArrayList<>();
            for(int i = 0; i < rows; i++) {
                char[] x = fr.nextLine().toCharArray();
                for(int j = 0; j < cols; j++) {
                    if (x[j] != '.') {
                        ArrayList<Integer> cur = new ArrayList<>();
                        cur.add(i);
                        cur.add(j);
                        cur.add((int)x[j]);
                        locs.add(cur);
                    }
                }
            }

            char[][] testone = create(rows, cols, 'R');
            char[][] testtwo = create(rows, cols, 'W');
            boolean canone = true;
            boolean cantwo = true;
            for(int i = 0; i < locs.size(); i++) {
                ArrayList<Integer> cur = locs.get(i);
                if ((int)testone[cur.get(0)][cur.get(1)] != cur.get(2)) {
                    canone = false;
                    break;
                }
            } 
            for(int i = 0; i < locs.size(); i++) {
                ArrayList<Integer> cur = locs.get(i);
                if ((int)testtwo[cur.get(0)][cur.get(1)] != cur.get(2)) {
                    cantwo = false;
                    break;
                }
            }
            if (canone) {
                out.write("YES\n");
                for(char[] x : testone) {
                    for(char y : x) {
                        out.write(y);
                    }
                    out.write("\n");
                }
            } else if(cantwo) {
                out.write("YES\n");
                for(char[] x : testtwo) {
                    for(char y : x) {
                        out.write(y);
                    }
                    out.write("\n");
                }
            } else {
                out.write("NO\n");
            }
        }
        out.close();
    }

    static char[][] create(int x, int y, char start) {
        char[][] ret = new char[x][y];
        char current = start;
        for(int i = 0; i < x; i++) {
            if(i > 0) {
                if (ret[i-1][0] == current) {
                    current = swap(current);
                }
            }
            for(int j = 0; j < y; j++) {
                ret[i][j] = current;
                current = swap(current);
            }
        }
        return ret;
    }

    static char swap(char current) {
        if (current == 'R') {
            return 'W';
        }
        return 'R';
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
