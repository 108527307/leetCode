package algorithm.jianzhiOffer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q45 {
    public String minNumber(int[] nums) {
        List<String> list1 = Arrays.stream(nums).boxed().map((i)->{return i+"";}).collect(Collectors.toList());
        list1.sort((i, j) -> {
            return(i+j).compareTo(j+i);


        });
        StringBuffer re = new StringBuffer();
        for (String i : list1)
            re.append(i);
        return re.toString();
    }

    public static void main(String[] argc) {
        System.out.println(new Q45().minNumber(new int[]{2,2060,213,216}));
    }
}
