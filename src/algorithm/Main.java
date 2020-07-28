package algorithm;//package algorithm;
//
//import java.text.DecimalFormat;
//import java.util.*;
//
//class ListNode {
//    public int val;
//    public ListNode next;
//
//    ListNode(int x) {
//        this.val = x;
//        this.next = null;
//
//    }
//}
//
//public class Main {
//    public int lastRemaining(int n, int m) {
//        ListNode root = new ListNode(0);
//        ListNode pre = root;
//        for (int i = 1; i < n; i++) {
//            ListNode temp = new ListNode(i);
//            pre.next = temp;
//            pre = temp;
//        }
//        pre.next = root;
//        ListNode worker = root;
//        Stack s = new Stack();
//
//        while (worker != worker.next) {
//            for (int i = 1; i < m - 1; i++)
//                worker = worker.next;
//            worker.next = worker.next.next;
//        }
//        return worker.val;
//    }
//
//    // static public void tencent1() {
////        Scanner sc = new Scanner(System.in);
////        String str = sc.nextLine();
////        //Stack<char> s = new Stack();
////        if (str.equals("")) {
////            System.out.print("");
////            return;
////        }
////        //StringBuffer re = new StringBuffer();
////        int start = 0;
////        StringBuffer tt = new StringBuffer();
////        int i = 0;
////        while (i < str.length()) {
////            char temp = str.charAt(i);
////            System.out.println(temp);
////            if (temp == '[') {
////                s.add('[');
////
////            } else if (temp == ']') {
////                String r = "";
////                while (!s.isEmpty() && s.peek() != '[') {
////                    r = s.pop() + r;
////                }
////                String[] sp=r.split("|");
////                for(int d=0;d<Integer.parseInt(sp[0]))
////                    tt.append(sp[1]);
////                s.pop();
////            } else {
////
////
////            }
////
////
////        }
////
////    }
//
//    public static void main(String[] argc) {
//        // tencent1();
//        // System.out.println(new Main().lastRemaining(5, 3));
//
//        //1
////        Scanner sc = new Scanner(System.in);
////        int t = Integer.parseInt(sc.nextLine());
////
////        for (int i = 0; i < t; i++) {
////            int qq = Integer.parseInt(sc.nextLine());
////            Queue<String> q = new LinkedList<>();
////            int j = 0;
////            while (j++ < qq) {
////                String str = sc.nextLine();
////                String sp[] = str.split(" ");
////
////                if (sp[0].equals("PUSH")) {
////                    q.add(sp[1]);
////                } else if (sp[0].equals("TOP")) {
////                    if (q.isEmpty()) System.out.println("-1");
////                    else System.out.println(q.peek());
////                } else if (sp[0].equals("CLEAR")) q.clear();
////                else if (sp[0].equals("SIZE")) System.out.println(q.size());
////                else {
////                    if (q.isEmpty()) System.out.println("-1");
////                    q.poll();
////                    //else System.out.println(q.poll());
////                }
////
////
////            }
////        }
//
//        //2
////        Scanner sc = new Scanner(System.in);
////        int t = Integer.parseInt(sc.nextLine());
////        for (int i = 0; i < t; i++) {
////            DecimalFormat df = new DecimalFormat("#0.000");
////            double min = Double.MAX_VALUE;
////            int n = Integer.parseInt(sc.nextLine());
////            int[][] pointA = new int[n][2];
////            int[][] pointB = new int[n][2];
////            for (int j = 0; j < n; j++) {
////                String ss[] = sc.nextLine().split(" ");
////                pointA[j][0] = Integer.parseInt(ss[0]);
////                pointA[j][1] = Integer.parseInt(ss[1]);
////            }
////            double temp = 0;
////            for (int j = 0; j < n; j++) {
////                String ss[] = sc.nextLine().split(" ");
//////                pointB[j][0] = Integer.parseInt(ss[0]);
//////                pointB[j][1] = Integer.parseInt(ss[1]);
////                for (int k = 0; k < n; k++) {
////                    double t1 = Math.pow(pointA[k][0] - Integer.parseInt(ss[0]), 2);
////                    double t2 = Math.pow(pointA[k][1] - Integer.parseInt(ss[1]), 2);
////                    temp = Math.pow(t1 + t2, 0.5);
////                    min = min < temp ? min : temp;
////                }
////            }
//
////            for (int k = 0; k < n; k++)
////                for (int p = 0; p < n; p++) {
////                    double t1 = Math.pow(pointA[k][0] - pointB[p][0], 2);
////                    double t2 = Math.pow(pointA[k][1] - pointB[p][1], 2);
////                    temp = Math.pow(t1 + t2, 0.5);
////                    min = min < temp ? min : temp;
////                }
////            if (min < 0)
////                System.out.println("0.000");
////            else
//        // System.out.print(df.format(min));
//
//
//        //  }
////        Scanner sc = new Scanner(System.in);
////        int t = Integer.parseInt(sc.nextLine());
////        int a[][] = new int[t][2];
////        String[] x = sc.nextLine().split(" ");
////        String[] y = sc.nextLine().split(" ");
////        for (int i = 0; i < t; i++) {
////            a[i][0] = Integer.parseInt(x[i]);
////            a[i][1] = Integer.parseInt(y[i]);
////        }
////        dp(a, 0, 0);
////        if (min == Integer.MAX_VALUE)
////            min = -1;
////        System.out.print(min);
//
//       int n=10,i=0,h=1;
//        while(n>=Math.pow(2,i)){
//            i++;
//        }
//        int k=i-h;
//        while(k-->0){
//            n/=2;
//        }
//        System.out.println(n);
//        System.out.print(i);
//
//    }
//
//    static int min = Integer.MAX_VALUE;
//    //static int i = 0;
//
//    public static void dp(int a[][], int i, int bu) {
//        if (i == (a.length - 1)) {
//            min = min < bu ? min : bu;
//        } else {
//            if (a[i][0] <= a[i + 1][0]) {
//                if (a[i + 1][1] <= a[i][1]) {
//                    dp(a, i + 1, bu);//不翻转
//                    a[i][0] = a[i + 1][1] + a[i][0] - (a[i + 1][1] = a[i][0]);
//                    a[i][1] = a[i][1] + a[i + 1][0] - (a[i + 1][0] = a[i][1]);
//                    dp(a, i + 1, bu + 1);
//                    a[i][0] = a[i + 1][1] + a[i][0] - (a[i + 1][1] = a[i][0]);
//                    a[i][1] = a[i][1] + a[i + 1][0] - (a[i + 1][0] = a[i][1]);
//                } else {
//                    dp(a, i + 1, bu);//不翻转
//                }
//
//            } else {
//                if (a[i + 1][1] <= a[i][1]) {
//                    a[i][0] = a[i + 1][1] + a[i][0] - (a[i + 1][1] = a[i][0]);
//                    a[i][1] = a[i][1] + a[i + 1][0] - (a[i + 1][0] = a[i][1]);
//                    dp(a, i + 1, bu + 1);
//                    a[i][0] = a[i + 1][1] + a[i][0] - (a[i + 1][1] = a[i][0]);
//                    a[i][1] = a[i][1] + a[i + 1][0] - (a[i + 1][0] = a[i][1]);
//                } else {
//                    return;
//                }
//
//            }
//        }
//
//    }
//}
import java.util.Scanner;
public class Main{
    public static void main(String[] argc){
        Scanner sc=new Scanner(System.in);
        String[] ss=sc.nextLine().split(" ");
        int N=Integer.parseInt(ss[0]),M=Integer.parseInt(ss[1]),L=Integer.parseInt(ss[2]),R=Integer.parseInt(ss[3]);
        long[] a=new long[N];
        long[] b=new long[M];
        String[] sa=sc.nextLine().split(" ");
        String[] sb=sc.nextLine().split(" ");
        long ii=0;int n=0,m=0, k=0,s=0;
        while(k<N){
            ii=Long.parseLong(sa[k]);
            if(ii>=L&&ii<=R){
                a[n]=ii;
                n++;}
            k++;
        }
        while(s<M)
        {
            ii=Long.parseLong(sb[s]);
            if(ii>=L&&ii<=R){
                b[m]=ii;
                m++;}
            s++;
        }
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                long jj=a[i]+b[j];
                if(jj<=R&&jj>=L) count++;
            }
        }
        System.out.print(count);
    }
    public int test(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return 2 * test(n - 1);
        }
    }


}