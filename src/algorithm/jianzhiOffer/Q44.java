package algorithm.jianzhiOffer;

public class Q44 {
    public int findNthDigit(int n) {
        long i = 1,k=n;
        if (k <= 9) return n;
      k -= 10;
        k += 1;
        while (k >= 0) {
            k -= (Math.pow(10, i + 1) - Math.pow(10, i)) * (++i);
        }
        k+= (Math.pow(10, i) - Math.pow(10, i - 1)) * i;
        System.out.println(k + "d" + i);
        if (k == 0) {
            return 9;
        }
        long yu = k % i;
        System.out.println(yu);
        long target = (long) Math.pow(10, i - 1) + k / i - 1;
        if (yu != 0) target++;
        else return (int)target % 10;
        System.out.println(target);

        //if(yu==0) return target%10;
        //else {
        //target++;
        int j = 0;
        long re=0;
        while (j <= (i - yu)) {
            j++;
            re = target % 10;
            target /= 10;
        }
        //System.out.println(Integer.Max);
        return (int)re;
        //}
    }

    public int findNthDigit2(int n) {
        long base = 9, digits = 1;
        while ((n - base * digits) > 0) {
            n -= base * digits;
            base *= 10;
            digits += 1;
        }
        long idx = n % digits;
        if (idx == 0)
            idx = digits;
        long number = 1;
        for (int i = 1; i < digits; i++) {
            number *= 10;
        }
        if (idx == digits)
            number += n / digits - 1;
        else
            number += n / digits;
        for (int i = (int)idx; i < digits; i++) {
            number /= 10;
        }
        return (int)number % 10;

    }

    public static void main(String[] argc) {
        Q44 e = new Q44();
        System.out.println(e.findNthDigit(1000000000) + ":" + e.findNthDigit2(1000000000));
    }
}
