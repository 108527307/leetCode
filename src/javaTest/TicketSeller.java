package javaTest;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;

/***
 *
 * @return
 * @author chy
 * @creed: Talk is cheap,show me the code
 * @date 23/4/2020 9:31 PM
 * @desc: 机票类，用来描述一张机票的属性）
 */
class Ticket {


    private int id;//机票的id
    private String from;//出发地
    private String to;//目的地
    private String time;//出发时间
    private double price;//票价

    //方便打印机票信息
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.00");

        return "机票信息{机票编号:" + id +
                ",出发地:" + from +
                ", 目的地:" + to +
                ", 登机时间:" + time +
                ", 票价: ¥" + df.format(price) +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Ticket(int id, String from, String to, String time, double price) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.time = time;
        this.price = price;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

/**
 * @author chy
 * @return
 * @creed: Talk is cheap,show me the code
 * @date 23/4/2020 9:59 PM
 * @desc: 用于机票的销售
 */
public class TicketSeller {

    //    机场购买机票， 客户输入： 出发地， 结束地， 上机时间，  给出最低价的机票
//
    private static List<Ticket> tickets = new ArrayList<>();//模拟机票数据库，我这里用了一个list

    //我模拟生成了20000张机票，设计了三个地点，然后每张机票我设置了随机的价格
     static {
        for (int i = 0; i < 10; i++) {
            int j = i % 6;
            switch (j) {
//                case 0:
//                    tickets.add(new Ticket(i, "南京", "上海", "8:00", (Math.random() * 20000) + 1000));
//                    break;
//                case 1:
//                    tickets.add(new Ticket(i, "南京", "北京", "8:00", (Math.random() * 20000) + 1000));
//                    break;
//                case 2:
//                    tickets.add(new Ticket(i, "上海", "北京", "9:00", (Math.random() * 20000) + 1000));
//                    break;
//                case 3:
//                    tickets.add(new Ticket(i, "上海", "南京", "9:00", (Math.random() * 20000) + 1000));
//                    break;
//                case 4:
//                    tickets.add(new Ticket(i, "北京", "上海", "9：00", (Math.random() * 20000) + 1000));
//                    break;
                default:
                    tickets.add(new Ticket(i, "北京", "南京", "9:00", (Math.random() * 20000)));
            }
        }

    }

    //搜索最低票价
    static synchronized public String searchForLowestPrice(String from, String to, String time) {
        //这里我直接使用了Stream的filter对list进行过滤操作，然后根据票价的高低进行升序排列，最后返回list的第一个结果就是最低票价
        List<Ticket> result = tickets.stream()//Predicate
                .filter(x -> x.getFrom().equals(from))
                .filter(x -> x.getTo().equals(to))
                .filter(x -> x.getTime().equals(time))
                .sorted((x, y) -> new Double(x.getPrice() - y.getPrice()).intValue())
                .collect(Collectors.toList());

        if (result.size() == 0)
            return "抱歉，该航次无票";
        Ticket target = result.get(0);//找出最便宜的机票
        tickets.remove(target);

        return target.toString();
    }


    public static void main(String[] args) {
       // ticketsGeneration();
        int i = 0;
        while (i++ < 11) {
            new Thread(() -> {
                String ticket = TicketSeller.searchForLowestPrice("北京", "南京", "9:00");
                System.out.println(ticket);
            }

            ).start();
        }

    }
}




