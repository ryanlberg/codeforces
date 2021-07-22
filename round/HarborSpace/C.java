import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class C {


    static char[] kicks;
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        for(int c = 0; c < cases; c++) {
            kicks = fr.next().toCharArray();
            int min = solve();
            out.write(min + "\n");
        }
        out.close();
    }

    static int solve() {
        if(kicks[0] == '?') {
            return Math.min(solveHelper(1, 1, 0, 4, 5), solveHelper(1, 0, 0, 4, 5));

        } else if(kicks[0] == '1') {
            return solveHelper(1, 1, 0, 4, 5);
        } else {
            return solveHelper(1, 0, 0, 4, 5);
        }
    }

    static int solveHelper(int loc, int teamone, int teamtwo,  int oneleft, int twoleft) {
        if(teamone + oneleft < teamtwo || teamtwo + twoleft < teamone) {
            return loc;
        }
        if(loc > 9) {
            return 10;
        }
        if(loc % 2 == 0) {
            if (kicks[loc] == '?') {
                return Math.min(solveHelper(loc+1, teamone+1, teamtwo,  oneleft-1, twoleft), solveHelper(loc+1, teamone, teamtwo,  oneleft-1, twoleft));
            } else if(kicks[loc] == '1') {
                return solveHelper(loc+1, teamone+1, teamtwo,  oneleft-1, twoleft);
            } else {
                return solveHelper(loc+1, teamone, teamtwo,  oneleft-1, twoleft);
            }
        } else {
            if (kicks[loc] == '?') {
                return Math.min(solveHelper(loc+1, teamone, teamtwo+1,  oneleft, twoleft-1), solveHelper(loc+1, teamone, teamtwo,  oneleft, twoleft-1));
            } else if(kicks[loc] == '1') {
                return solveHelper(loc+1, teamone, teamtwo+1,  oneleft, twoleft-1);
            } else {
                return solveHelper(loc+1, teamone, teamtwo,  oneleft, twoleft-1);
            }
        }
       
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
