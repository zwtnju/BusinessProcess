package com.example.demo.mapper;

import com.example.demo.entity.BusinessProcess;
import com.example.demo.entity.PrivateTransaction;
import com.example.demo.entity.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlockMapper {

    BusinessProcess findBPByBPId(int bpId);

    BusinessProcess findLatestBP();

    List<BusinessProcess> findBPsByBlockId(int blockId);

    List<BusinessProcess> findAllBPsByUserId(int userId); //注意加distinct

    //List<BusinessProcess> findWaitingBPsByUserId(int userId);//注意加distinct

    //List<BusinessProcess> findUnclosedBPsByUserId(int userId);//注意加distinct

    //List<BusinessProcess> findClosedBPsByUserId(int userId);//注意加distinct

    List<Transaction> findAllInputTxsByBPId(int businessProcessId);

    List<Transaction> findAllOutputTxsByBPId(int businessProcessId);

    //List<Transaction> findAllInputTxsByUserIdAndBpId(int userId, int bpId);

    //List<Transaction> findAllOutputTxsByUserIdAndBpId(int userId, int bpId);

    List<Transaction> findWaitingTxsByUserIdAndBpId(int userId, int bpId);

    //List<Transaction> findWaitingTxsByUserId(int userId);

    //insert
    //插入一条新的流程获得bpId，仔插入一条交易
    void insertBPDescription(BusinessProcess businessProcess);

    //插入从其他人那里获取的流程信息
    void insertBPDescriptionFromOthers(BusinessProcess businessProcess);

    //void insertBP_Tx(int bpId, int transId); //流程新增一条交易

    Integer insertTransaction_input(Transaction transaction);

    Integer insertTransaction_output(Transaction transaction);

    void updateBP(BusinessProcess businessProcess);

    void updateTransaction_input(Transaction transaction);

    void updateTransaction_output(Transaction transaction);

    //初始化本地的区块数据
    List<Transaction> findAllInputTxs();

    List<Transaction> findAllOutputTxs();


    // 这里需要使用bpId和transId同时确定唯一的主键
    // 使用transId找当前的输入任务
    Transaction findTransactionInInputByTranId(int bpId, int transId);
    // 使用前置任务的transId+1 找对应的全部后续任务
    List<Transaction> findTxsInOutputByTranId(int bpId, int transId);

    //往数据库插入隐私交易
    void insertPrivateOutputTx(PrivateTransaction privateTransaction);

    List<PrivateTransaction> findPrivateTxsById(int bpId, int transId);

}
