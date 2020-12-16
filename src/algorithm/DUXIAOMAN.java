//package algorithm;
//
//import java.lang.annotation.Annotation;
//import java.lang.annotation.Documented;
//import java.lang.annotation.Retention;
//import java.lang.annotation.Target;
//import java.lang.reflect.AnnotatedElement;
//import java.lang.reflect.Field;
//import java.lang.reflect.Method;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//import static java.lang.annotation.ElementType.FIELD;
//import static java.lang.annotation.ElementType.METHOD;
//import static java.lang.annotation.RetentionPolicy.RUNTIME;
//
//@Target({FIELD, METHOD})
//@Retention(RUNTIME)
//@Documented
//@interface example {
//    String value() default "";
//}
//
//class Father {
//    //1
//    static {
//        int a = 0;
//    }
//    //2
//
//    int b = 0;
//
//    @example("dasd")
//    public void fun1() {
//
//    }
//
//    //3
//    Father() throws NoSuchMethodException {
//        Class cla = this.getClass();
//        Method m = cla.getDeclaredMethod("fun1");
//        Annotation[] annotationm =m.getDeclaredAnnotations();
//        System.out.println("Father constructor");
//    }
//}
//
//class Son extends Father {
//    //4
//    private int i = 0;
//
//    static {
//        int d = 0;
//    }
//
//    //5
//    {
//        int s = 0;
//    }
//
//    //6
//    Son() {
//        System.out.println("Son");
//    }
//
//    interface a {
//    }
//
//    interface b {
//
//    }
//
//    interface c extends a, b {
//
//    }
//
//    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
//        Son s = new Son();
//        s.fun1();
//        List<String> a = new ArrayList();
//        a.add(new String("sda"));
//        a.add(1);
//
//        Class sonClass = s.getClass();
//        Field field = sonClass.getDeclaredField("i");
//        field.setAccessible(true);
//        field.get(s);
//
//        // 1 父类的静态代码块 4 子类的静态代码块 2父类的动态代码块 3 父类的构造函数 5 6
//    }
//}
//
//
//public class DUXIAOMAN {
//    public static void main(String[] args) {
//        String s = new String("abc");
//        String ss = "abc";
//        float a = (float) 0.1;
//        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
//
//        test();
//    }
//
//    public static void test() {
//        Scanner in = new Scanner(System.in);
//        int T = Integer.parseInt(in.nextLine());
//        int i = 0;
//        while (i++ < T) {
//            String[] ss = in.nextLine().split(" ");
//            int N = Integer.parseInt(ss[0]), M = Integer.parseInt(ss[1]);
//            char[][] mi = new char[N][M];
//            int j = 0;
//            int startI = 0, startJ = 0;
//            String str;
//            while (j < N) {
//                str = in.nextLine();
//                for (int u = 0; u < str.length(); u++) {
//                    mi[j][u] = str.charAt(u);
//                    if (mi[j][u] == '@') {
//                        startI = j;
//                        startJ = u;
//                        mi[j][u] = '.';
//                    }
//                }
//                j++;
//            }
//            dfs(mi, startI, startJ, 0, 0);
//            if (min != Integer.MAX_VALUE)
//                System.out.println(min);
//            else System.out.println(-1);
//            min = Integer.MAX_VALUE;
//        }
//    }
//
//    public static int min = Integer.MAX_VALUE;
//
//    public static void dfs(char[][] mi, int i, int j, int count, int pre) {
//        if (i >= mi.length || i < 0 || j >= mi.length || j < 0) {
//            min = Math.min(min, count);
//            return;
//        }
//        if (mi[i][j] == '*') {
//            mi[i][j] = '-';
//            if (pre != 1)
//                dfs(mi, i + 1, j, count + 1, 3);
//            if (pre != 2)
//                dfs(mi, i, j + 1, count + 1, 4);
//            if (pre != 3)
//                dfs(mi, i - 1, j, count + 1, 1);
//            if (pre != 4)
//                dfs(mi, i, j - 1, count + 1, 2);
//            mi[i][j] = '*';
//
//
//        } else if (mi[i][j] == '.') {
//            mi[i][j] = '-';
//            if (pre != 1)
//                dfs(mi, i + 1, j, count, 3);
//            if (pre != 2)
//                dfs(mi, i, j + 1, count, 4);
//            if (pre != 3)
//                dfs(mi, i - 1, j, count, 1);
//            if (pre != 4)
//                dfs(mi, i, j - 1, count, 2);
//            mi[i][j] = '.';
//        }
//    }
//}
