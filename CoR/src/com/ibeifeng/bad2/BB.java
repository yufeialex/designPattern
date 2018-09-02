package com.ibeifeng.bad2;

/**
 * Created by Administrator on 2018/9/2.
 * 采购单的分级审批
 *
 * Sunny软件公司承接了某企业SCM(Supply Chain Management，供应链管理)系统的开发任务，
 * 其中包含一个采购审批子系统。该企业的采购审批是分级进行的，即根据采购金额的不同由不同层次的主管人员来审批，
 * 主任可以审批5万元以下（不包括5万元）的采购单，副董事长可以审批5万元至10万元（不包括10万元）的采购单，
 * 董事长可以审批10万元至50万元（不包括50万元）的采购单，50万元及以上的采购单就需要开董事会讨论决定。
 */
//采购单：请求类
class PurchaseRequest {
    private double amount;  //采购金额
    private int number;  //采购单编号
    private String purpose;  //采购目的

    public PurchaseRequest(double amount, int number, String purpose) {
        this.amount = amount;
        this.number = number;
        this.purpose = purpose;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getPurpose() {
        return this.purpose;
    }
}


//采购单处理类
class PurchaseRequestHandler {
    //递交采购单给主任
    public void sendRequestToDirector(PurchaseRequest request) {
        if (request.getAmount() < 50000) {
            //主任可审批该采购单
            this.handleByDirector(request);
        } else if (request.getAmount() < 100000) {
            //副董事长可审批该采购单
            this.handleByVicePresident(request);
        } else if (request.getAmount() < 500000) {
            //董事长可审批该采购单
            this.handleByPresident(request);
        } else {
            //董事会可审批该采购单
            this.handleByCongress(request);
        }
    }

    //主任审批采购单
    public void handleByDirector(PurchaseRequest request) {
        //代码省略
    }

    //副董事长审批采购单
    public void handleByVicePresident(PurchaseRequest request) {
        //代码省略
    }

    //董事长审批采购单
    public void handleByPresident(PurchaseRequest request) {
        //代码省略
    }

    //董事会审批采购单
    public void handleByCongress(PurchaseRequest request) {
        //代码省略
    }
}