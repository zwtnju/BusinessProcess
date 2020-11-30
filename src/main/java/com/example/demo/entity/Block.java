package com.example.demo.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 区块block的数据结构
 */
public class Block extends LightBlock {

    private List<Transaction> txs;  //当前区块包含的业务流程
    private List<User> users;  //当前区块包含的用户信息
    private List<Data> data;  //当前区块包含的用户数据

    public Block() {
    }

    public Block(int blockId, long timestamp, int difficulty, int nonce, String preHash, String hash, List<Transaction> txs, List<User> users, List<Data> data) {
        super(blockId, timestamp, difficulty, nonce, preHash, hash);
        this.txs = txs;
        this.users = users;
        this.data = data;
    }

    public List<Transaction> getTxs() {
        return txs;
    }

    public void setTxs(List<Transaction> txs) {
        this.txs = txs;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }
}
