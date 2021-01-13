package com.example.demo.entity;

/**
 * 往后传递的协作业务流程数据
 */
public class TransportCoopMsg {
    private Transaction coopTx;
    private BusinessProcess coopBp;

    public TransportCoopMsg(Transaction coopTx, BusinessProcess coopBp) {
        this.coopTx = coopTx;
        this.coopBp = coopBp;
    }

    public Transaction getCoopTx() {
        return coopTx;
    }

    public void setCoopTx(Transaction coopTx) {
        this.coopTx = coopTx;
    }

    public BusinessProcess getCoopBp() {
        return coopBp;
    }

    public void setCoopBp(BusinessProcess coopBp) {
        this.coopBp = coopBp;
    }
}
