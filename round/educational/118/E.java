import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class E {



    public static void main(String[] args) {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        for(int c = 0; c < cases; c++) {
            int l = fr.nextInt();
            int h = fr.nextInt();
            char[][] board = new char[l][h];
            for(int i =0; i < l; i++) {
                board[i] = fr.next().toCharArray();
            } 
            int startx = -1;
            int starty = -1;
            for(int i = 0; i < l; i++) {
                for(int j = 0; j < h; j++) {
                    if(board[i][j] == 'L') {
                        startx = i;
                        starty = j;
                        break;
                    }
                }
                if(startx > -1) {
                    break;
                }
            }

            int[][] around = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            Deque<Integer> xqueue = new LinkedList<>();
            Deque<Integer> yqueue = new LinkedList<>();
            
            for(int[] x : around) {
                int startspotx = startx + x[0];
                int startspoty = starty + x[1];
                if(isValid(startspotx, startspoty, l, h) && board[startspotx][startspoty] == '.') {
                    xqueue.addLast(startspotx);
                    yqueue.addLast(startspoty);
                }
            }

            while(xqueue.size() > 0) {
                int curx = xqueue.pollFirst();
                int cury = yqueue.pollFirst();
                int surroundcount = 0;
                for(int[] x : around) {
                    int aroundx = curx + x[0];
                    int aroundy = cury + x[1];
                    if(!isValid(aroundx, aroundy, l, h) || board[aroundx][aroundy] != '.') {
                        surroundcount++;
                    }
                }
                if(surroundcount >= 3) {
                    board[curx][cury] = '+';
                    for(int[] x : around) {
                        int aroundx = curx + x[0];
                        int aroundy = cury + x[1];
                        if(isValid(aroundx, aroundy, l, h) && board[aroundx][aroundy] == '.') {
                            xqueue.addLast(aroundx);
                            yqueue.addLast(aroundy);
                        }
                    }
                }
            }

            for(char[] x : board) {
                for(char y : x) {
                    out.write(y);
                }
                out.write("\n");
            }

        }
        out.close();
    }

    static boolean isValid(int i, int j, int maxi, int maxj) {
        return i >= 0 && i < maxi && j >= 0 && j < maxj;
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
