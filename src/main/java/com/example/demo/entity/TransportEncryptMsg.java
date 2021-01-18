package com.example.demo.entity;

/**
 * 需要回传的协作数据
 */
public class TransportEncryptMsg {
    private Transaction preTx;
//    private String curEncryptTx;
    private String otherEncryptTxs;

    public TransportEncryptMsg(Transaction preTx, String otherEncryptTxs) {
        this.preTx = preTx;
//        this.curEncryptTx = curEncryptTx;
        this.otherEncryptTxs = otherEncryptTxs;
    }

    public Transaction getPreTx() {
        return preTx;
    }

    public void setPreTx(Transaction preTx) {
        this.preTx = preTx;
    }
//
//    public String getCurEncryptTx() {
//        return curEncryptTx;
//    }
//
//    public void setCurEncryptTx(String curEncryptTx) {
//        this.curEncryptTx = curEncryptTx;
//    }

    public String getOtherEncryptTxs() {
        return otherEncryptTxs;
    }

    public void setOtherEncryptTxs(String otherEncryptTxs) {
        this.otherEncryptTxs = otherEncryptTxs;
    }
}
