import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class D {

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
       
    
        int rows = fr.nextInt();
        int colqs = fr.nextInt();
        Row[] rowlist = new Row[rows];
        for(int i = 0; i < rows; i++) {
            rowlist[i] = new Row();
        }
        for(int i = 0; i < colqs; i++) {
            int rowtoadd = fr.nextInt();
            int a = fr.nextInt();
            int b = fr.nextInt();
            rowlist[rowtoadd-1].addColumn(a, b);
        }
       
        for(int i = 0; i < rows; i++) {
            rowlist[i].sortColumns();
            System.out.println(rowlist[i]);
        }

        out.write("0\n");
    
        out.close();
    }

    static class Row {
        ArrayList<ArrayList<Integer>> columnloc;

        public Row() {
            this.columnloc = new ArrayList<>();
        }

        public void addColumn(int a, int b) {
            ArrayList<Integer> toadd = new ArrayList<>();
            toadd.add(a);
            toadd.add(b);
            columnloc.add(toadd);
        }

        public void sortColumns() {
            Collections.sort(this.columnloc, (a, b) -> Integer.compare(a.get(0), b.get(0)));
        }

        public String toString() {
            String out = "";
            for(ArrayList<Integer> n : columnloc) {
                out += n.get(0) + ", " + n.get(1) + " ";
            }
            return out;
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
