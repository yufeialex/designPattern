package com.petrichor.cor.good1;

/**
 * Created by Administrator on 2018/9/2.
 */

//请假单：请求类
class LeaveRequest {
    private double days;  //请假天数
    private int number;  //请假单编号
    private String reason;  //请假原因

    public LeaveRequest(double days, int number, String reason) {
        this.days = days;
        this.number = number;
        this.reason = reason;
    }

    public void setDays(double days) {
        this.days = days;
    }

    public double getDays() {
        return this.days;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return this.reason;
    }
}

//审批者类：抽象处理者
abstract class Approver {
    protected Approver successor; //定义后继对象
    protected String name; //审批者姓名

    public Approver(String name) {
        this.name = name;
    }

    //设置后继者
    public void setSuccessor(Approver successor) {
        this.successor = successor;
    }

    //抽象请求处理方法
    public abstract void processRequest(LeaveRequest request);
}

//主任类：具体处理者
class Director extends Approver {
    public Director(String name) {
        super(name);
    }

    //具体请求处理方法
    public void processRequest(LeaveRequest request) {
        if (request.getDays() < 3) {
            System.out.println("主任" + this.name + "审批请假单：" + request.getNumber() + "，天数：" + request.getDays() + "天，请假原因：" + request.getReason() + "。");  //处理请求
        } else if(this.successor != null) {
            this.successor.processRequest(request);  //转发请求
        }
    }
}

//经理类：具体处理者
class Manager extends Approver {
    public Manager(String name) {
        super(name);
    }

    //具体请求处理方法
    public void processRequest(LeaveRequest request) {
        if (request.getDays() < 10) {
            System.out.println("经理" + this.name + "审批请假单：" + request.getNumber() + "，天数：" + request.getDays() + "天，请假原因：" + request.getReason() + "。");  //处理请求
        } else if(this.successor != null) {
            this.successor.processRequest(request);  //转发请求
        }
    }
}

//系统拒绝类：具体处理者
class Rejector extends Approver {
    public Rejector(String name) {
        super(name);
    }

    //具体请求处理方法
    public void processRequest(LeaveRequest request) {
        System.out.println("由于请假天数超过10天，拒绝申请！当前请假申请为：" + request.getNumber() + "，天数：" + request.getDays() + "天，请假原因：" + request.getReason() + "。");  //处理请求
        if(this.successor != null){
            this.successor.processRequest(request);  //转发请求
        }
    }
}

class Client {
    public static void main(String[] args) {
        Approver zhangsan,lisi,sys;
        zhangsan = new Director("张三");
        lisi = new Manager("李四");
        sys = new Rejector("系统");

        //创建职责链
        zhangsan.setSuccessor(lisi);
        lisi.setSuccessor(sys);

        //创建请假单
        LeaveRequest pr1 = new LeaveRequest(1, 10001, "感冒");
        zhangsan.processRequest(pr1);

        LeaveRequest pr2 = new LeaveRequest(5, 10002, "头疼");
        zhangsan.processRequest(pr2);

        LeaveRequest pr3 = new LeaveRequest(20, 10003, "阑尾炎");
        zhangsan.processRequest(pr3);

    }
}