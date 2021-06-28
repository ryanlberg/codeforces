import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
public class G {


    public static void main(String[] args) {
        
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int n = fr.nextInt();
        int m = fr.nextInt();
        int stepsize = fr.nextInt();
        int[][] maze = new int[n][m];
        long[][] mins = new long[n][m];
        
        for(int i = 0; i < n; i++) {
            Arrays.fill(mins[i], Long.MAX_VALUE);
        }
        ArrayList<ArrayList<Integer>> portals = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int val = fr.nextInt();
                maze[i][j] = val;
                if(val > 0) {
                    portals.add(new ArrayList<Integer>(Arrays.asList(i, j)));
                }
            }
        }

        Deque<Integer> is = new LinkedList<Integer>();
        Deque<Integer> js = new LinkedList<Integer>();
        Deque<Long> moves = new LinkedList<Long>();

        is.addFirst(0);
        js.addFirst(0);
        moves.addFirst((long)0);

        while(is.size() > 0) {
            int curi = is.pollFirst();
            int curj = js.pollFirst();
            long curmove = moves.pollFirst();
            int l = maze[curi][curj];
            if(l > 0) {
                for(ArrayList x: portals) {
                    if(!(curi == (int)x.get(0) && curj == (int)x.get(1))) {
                        int nexti = (int)x.get(0);
                        int nextj = (int)x.get(1);
                        if(curmove + l + maze[nexti][nextj] < mins[nexti][nextj]) {
                            mins[nexti][nextj] = curmove + l + maze[nexti][nextj];
                            is.addLast(nexti);
                            js.addLast(nextj);
                            moves.addLast(curmove+l+maze[nexti][nextj]);
                        }
                    }
                }
            }
            if(isValid(curi+1, curj, n, m) && maze[curi+1][curj] != -1 && curmove + stepsize < mins[curi+1][curj]) {
                mins[curi+1][curj] = curmove + stepsize;
                is.addLast(curi+1);
                js.addLast(curj);
                moves.addLast(mins[curi+1][curj]);
            }
            if(isValid(curi-1, curj, n, m) && maze[curi-1][curj] != -1 && curmove + stepsize < mins[curi-1][curj]) {
                mins[curi-1][curj] = curmove + stepsize;
                is.addLast(curi-1);
                js.addLast(curj);
                moves.addLast(mins[curi-1][curj]);
            }
            if(isValid(curi, curj+1, n, m) && maze[curi][curj+1] != -1 && curmove + stepsize < mins[curi][curj+1]) {
                mins[curi][curj+1] = curmove + stepsize;
                is.addLast(curi);
                js.addLast(curj+1);
                moves.addLast(mins[curi][curj+1]);
            }
            if(isValid(curi, curj-1, n, m) && maze[curi][curj-1] != -1 && curmove + stepsize < mins[curi][curj-1]) {
                mins[curi][curj-1] = curmove + stepsize;
                is.addLast(curi);
                js.addLast(curj-1);
                moves.addLast(mins[curi][curj-1]);
            }
        }

        // for(int i = 0; i < n; i++) {
        //     for(int j = 0; j < m; j++) {
        //         System.out.print(mins[i][j] + " ");
        //     }
        //     System.out.println("");
        // }

        if (mins[n-1][m-1] == Long.MAX_VALUE) {
            out.write(-1 + "\n");
        }else {
            out.write(mins[n-1][m-1] + "\n");
        }



        out.close();
    }

    static boolean isValid(int i, int j, int n, int m) {
        return i >= 0 && i < n && j >= 0 && j < m;
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
