package com.example.demo.entity;

/**
 * 需要回传的协作数据
 */
public class TransportEncryptMsg {
    private Transaction preTx;
    private String curEncryptTx;

    public TransportEncryptMsg(Transaction preTx, String curEncryptTx) {
        this.preTx = preTx;
        this.curEncryptTx = curEncryptTx;
    }

    public Transaction getPreTx() {
        return preTx;
    }

    public void setPreTx(Transaction preTx) {
        this.preTx = preTx;
    }

    public String getCurEncryptTx() {
        return curEncryptTx;
    }

    public void setCurEncryptTx(String curEncryptTx) {
        this.curEncryptTx = curEncryptTx;
    }
}
