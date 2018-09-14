package com.petrichor.strategy.bad2;

/**
 * Created by Administrator on 2018/9/2.
 * <p>
 * Sunny软件公司为某电影院开发了一套影院售票系统，在该系统中需要为不同类型的用户提供不同的电影票打折方式，具体打折方案如下：
 * (1) 学生凭学生证可享受票价8折优惠；
 * (2) 年龄在10周岁及以下的儿童可享受每张票减免10元的优惠（原始票价需大于等于20元）；
 * (3) 影院VIP用户除享受票价半价优惠外还可进行积分，积分累计到一定额度可换取电影院赠送的奖品。
 * 该系统在将来可能还要根据需要引入新的打折方式。
 *
 *
 * 如下代码的问题：
 *  (1) MovieTicket类的calculate()方法非常庞大，它包含各种打折算法的实现代码，在代码中出现了较长的if…else…语句，不利于测试和维护。

 (2) 增加新的打折算法或者对原有打折算法进行修改时必须修改MovieTicket类的源代码，违反了“开闭原则”，系统的灵活性和可扩展性较差。

 (3) 算法的复用性差，如果在另一个系统（如商场销售管理系统）中需要重用某些打折算法，只能通过对源代码进行复制粘贴来重用，无法单独重用其中的某个或某些算法（重用较为麻烦）。

 导致产生这些问题的主要原因在于MovieTicket类职责过重，它将各种打折算法都定义在一个类中，这既不便于算法的重用，也不便于算法的扩展。因此我们需要对MovieTicket类进行重构，
 将原本庞大的MovieTicket类的职责进行分解，将算法的定义和使用分离，这就是策略模式所要解决的问题，下面将进入策略模式的学习。
 */
public class MovieTicketDiscount {
}


//电影票类
class MovieTicket {
    private double price; //电影票价格
    private String type; //电影票类型

    public void setPrice(double price) {
        this.price = price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return this.calculate();
    }

    //计算打折之后的票价
    public double calculate() {
        //学生票折后票价计算
        if (this.type.equalsIgnoreCase("student")) {
            System.out.println("学生票：");
            return this.price * 0.8;
        }
        //儿童票折后票价计算
        else if (this.type.equalsIgnoreCase("children") && this.price >= 20) {
            System.out.println("儿童票：");
            return this.price - 10;
        }
        //VIP票折后票价计算
        else if (this.type.equalsIgnoreCase("vip")) {
            System.out.println("VIP票：");
            System.out.println("增加积分！");
            return this.price * 0.5;
        } else {
            return this.price; //如果不满足任何打折要求，则返回原始票价
        }
    }
    // 感觉这里充满了if else，所以之前的职责链就能去掉if else判断。这个也能去掉。但是那个是不管前面执行与否，都要让链条后面的继续执行。
    // 但是这个策略是选择了一个，就只执行这个策略。别的肯定不会选择。
}

class Client {
    public static void main(String args[]) {
        MovieTicket mt = new MovieTicket();
        double originalPrice = 60.0; //原始票价
        double currentPrice; //折后价

        mt.setPrice(originalPrice);
        System.out.println("原始价为：" + originalPrice);
        System.out.println("---------------------------------");

        mt.setType("student"); //学生票
        currentPrice = mt.getPrice();
        System.out.println("折后价为：" + currentPrice);
        System.out.println("---------------------------------");

        mt.setType("children"); //儿童票
        currentPrice = mt.getPrice();
        System.out.println("折后价为：" + currentPrice);
    }
}