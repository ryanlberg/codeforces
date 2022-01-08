import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class B {


    static class Point {
        int x;
        int y;

        public Point(int a, int b) {
            this.x= a;
            this.y = b;
        }

        public String toString() {
            String out = "(" + x + ", " + y + ")";
            return out;
        }


    }

    static int getAreaSquared(Point a, Point b, Point c) {
        return (int)Math.abs((a.x * b.y + b.x*c.y + c.x * a.y - a.y*b.x -b.y*c.x-c.y*a.x));
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
       
        for(int c = 0; c < cases; c++) {
            int w = fr.nextInt();
            int h = fr.nextInt();
            int side = fr.nextInt();
            ArrayList<Point> sideOnes = new ArrayList<>();
            ArrayList<Point> sideTwos = new ArrayList<>();
            ArrayList<Point> sideThree = new ArrayList<>(); 
            ArrayList<Point> sideFour = new ArrayList<>();
            ArrayList<Point> all = new ArrayList<>();
            for(int i = 0; i < side; i++) {
                Point l = new Point(fr.nextInt(), 0);
                sideOnes.add(l);
                all.add(l);
            }
            //Collections.sort(sideOnes, (a, b) -> Integer.compare(a.x, b.x));
            side = fr.nextInt();
            for(int i = 0; i < side; i++) {
                Point l = new Point(fr.nextInt(), h);
                sideTwos.add(l);
                all.add(l);
            } 
            //Collections.sort(sideTwos, (a, b) -> Integer.compare(a.x, b.x));
            side = fr.nextInt();
            for(int i = 0; i < side; i++) {
                Point l = new Point(0, fr.nextInt());
                sideThree.add(l);
                all.add(l);
            }
            //Collections.sort(sideThree, (a, b) -> Integer.compare(a.y, b.y));
            side = fr.nextInt();
            for(int i = 0; i < side; i++) {
                Point l = new Point(w, fr.nextInt());
                sideFour.add(l);
                all.add(l);
            }
            //Collections.sort(sideFour, (a, b) -> Integer.compare(a.y, b.y));
            int maxdist = Integer.MIN_VALUE;
            for(int i = 0 ; i < sideOnes.size()-1; i++) {
                for(int j = i+1; j < sideOnes.size(); j++) {
                    for(Point p : all) {
                        if(p.y != sideOnes.get(0).y) {
                            maxdist = Math.max(maxdist, getAreaSquared(sideOnes.get(i), sideOnes.get(j), p));
                        }
                    }
                }
            }
           
            for(int i = 0 ; i < sideTwos.size()-1; i++) {
                for(int j = i+1; j < sideTwos.size(); j++) {
                    for(Point p : all) {
                        if(p.y != sideTwos.get(0).y) {
                            maxdist = Math.max(maxdist, getAreaSquared(sideTwos.get(i), sideTwos.get(j), p));
                        }
                    }
                }
            }
            for(int i = 0 ; i < sideThree.size()-1; i++) {
                for(int j = i+1; j < sideThree.size(); j++) {
                    for(Point p : all) {
                        if(p.x != sideThree.get(0).x) {
                            maxdist = Math.max(maxdist, getAreaSquared(sideThree.get(i), sideThree.get(j), p));
                        }
                    }
                }
            }
            for(int i = 0 ; i < sideFour.size()-1; i++) {
                for(int j = i+1; j < sideFour.size(); j++) {
                    for(Point p : all) {
                        if(p.x != sideFour.get(0).x) {
                            maxdist = Math.max(maxdist, getAreaSquared(sideFour.get(i), sideFour.get(j), p));
                        }
                    }
                }
            }
            out.write(maxdist + "\n");
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
