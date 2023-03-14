import java.util.Random;

public class PeakFinder {

    /**
     * generate random 2D array
     */
    public int[][] random2dArray(int n, int m){
        int[][] a = new int[n][];
        Random r = new Random();
        for(int i = 0; i < n; i++){
            a[i] = new int[m];
            for (int j = 0; j < a[i].length; j++){
                a[i][j] = r.nextInt(20);
            }
        }
        return a;

    }


    public void print2d(int[][] a){
        for (int[] i: a){
            for (int item: i){
                System.out.print(item+"\t ");
            }
            System.out.println("");
        }
    }


    /**
     * n = number of rows,
     * m = number of columns
     * rowOrcol -> eger 0 ise sadece satirlari(n) bolecek
     *          eger 1 ise sadece sutunlari(m) bolecek
     *          eger 2 ise bir iterasyonda satirlari, diger iterasyonda sutunlari bolecek
     *              (m ve n degerlerinden buyuk olani bolebilirsiniz,
     *              bu m ve n degerleri arasaindaki fark fazla oldugunda daha mantikli.)
     */
    public int[] peakFinder2D(int[][] a, int n, int m, int rowOrcol) {
        int[] indx = new int[2];
        int startR = 0, endR = n, startC = 0, endC = m;
        int mid;
        if (rowOrcol == 0) {
            while (startR >= 0 && endR <= n) {
                mid = (startR + endR) / 2;
                int max = a[mid][startC];
                int imax = 0;
                for (int i = startC; i < endC; i++) {
                    if (max < a[mid][i]) {
                        max = a[mid][i];
                        imax = i;
                    }
                }

                //TODO edges------
                if (a[mid][imax] < a[mid + 1][imax]) {
                    startR = mid + 1;
                } else if (a[mid][imax] < a[mid - 1][imax]) {
                    endR = mid - 1;
                } else {
                    indx[0] = mid;
                    indx[1] = imax;
                    return indx;
                }
            }
        }
        if (rowOrcol == 1) {
            while (startC >= 0 && endC <= n) {
                mid = (startC + endC) / 2;
                int max = a[startR][mid];
                int imax = 0;

                for (int i = startR; i < endR; i++) {
                    if (max < a[i][mid]) {
                        max = a[mid][i];
                        imax = i;

                    }

                }
                if (a[imax][mid] < a[imax][mid + 1]) {
                    startC = mid + 1;
                } else if (a[imax][mid] < a[imax][mid - 1]) {
                    endC = mid - 1;
                } else {
                    indx[0] = imax;
                    indx[1] = mid;
                    return indx;
                }

            }
        }
        if (rowOrcol == 2) {

            int sayac = 0;

            while (sayac >= 0) {
                if (sayac % 2 == 0) {
                    sayac++;

                    mid = (startR + endR) / 2;
                    int max = a[mid][startC];
                    int imax = 0;
                    for (int i = startC; i < endC; i++) {
                        if (max < a[mid][i]) {
                            max = a[mid][i];
                            imax = i;

                        }
                    }
                    if (a[mid][imax] < a[mid + 1][imax]) {
                        startR = mid + 1;
                    } else if (a[mid][imax] < a[mid - 1][imax]) {
                        endR = mid - 1;
                    } else {
                        indx[0] = mid;
                        indx[1] = imax;
                        return indx;

                    }

                } else if (sayac % 2 == 1) {
                    sayac++;

                    mid = (startC + endC) / 2;
                    int max = a[startR][mid];
                    int imax = 0;

                    for (int i = startR; i < endR; i++) {
                        if (max < a[i][mid]) {
                            max = a[mid][i];
                            imax = i;
                        }
                    }
                    if (a[imax][mid] < a[imax][mid + 1]) {
                        startC = mid + 1;
                    } else if (a[imax][mid] < a[imax][mid - 1]) {
                        endC = mid - 1;
                    } else {
                        indx[0] = imax;
                        indx[1] = mid;
                        return indx;
                    }
                }
            }
        }
        return indx;
    }

    /**
     * uc boyutlu arrayde peak bulan method
     * @param a
     * @param r
     * @param c
     * @param d
     * @return
     */

    public int[][][] random3dArray(int n, int m, int k){
        int[][][] a = new int[n][m][];
        Random r = new Random();
        for(int i = 0; i < n; i++){
            for(int t=0; t < m; t++){
                a[i][t] = new int[k];
                for (int j = 0; j < a[i][t].length; j++){
                    a[i][t][j] = r.nextInt(20);
                }
            }
        }
        return a;

    }

    public void print3d(int[][][] a){
        for (int[][] i: a){
            for (int[] item: i){

                for (int y:item){
                    System.out.print(y+"\t ");
                }
                System.out.println("");
            }
            System.out.println("");
        }
    }

    public int[] peakFinder3d(int[][][] a, int r, int c, int d){


        return null;
    }

    public static void main(String[] args){
        PeakFinder pf = new PeakFinder();
        int m =5 , n =5 , u=5, rowOrcol = 0;
        int[][] a = pf.random2dArray(m,n);
        int[][][] a1 = pf.random3dArray(m,n,u);
        long t1 = System.nanoTime();
        pf.peakFinder2D(a, n, m, rowOrcol);
        long t2 = System.nanoTime();

        System.out.printf("%d, %d, %d, %d", n,m, rowOrcol, t2-t1);
        System.out.println();
        //pf.print2d(a);
        pf.print3d(a1);
        /* TODO: int[] peak = pf.peakFinder2D(a, n, m, rowOrcol);
            is peak correct?
        */
    }
}