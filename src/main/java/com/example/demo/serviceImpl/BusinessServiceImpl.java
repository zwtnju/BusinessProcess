package com.example.demo.serviceImpl;

import com.example.demo.entity.BusinessProcess;
import com.example.demo.entity.Transaction;
import com.example.demo.mapper.BlockMapper;
import com.example.demo.service.ConsortiumBlockchainService;
import com.example.demo.service.BusinessService;
import com.example.demo.utils.CooperationUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class BusinessServiceImpl implements BusinessService {
    @Autowired
    BlockMapper blockMapper;

    @Autowired
    ConsortiumBlockchainService consortiumBlockchainService;

    @Override
    public void creatCooperate(Integer bpId, Transaction tx, Integer preTransId) {
        int businessProcesssId;
        BusinessProcess bp;
        if (bpId == null) { //需要新建流程
            bp = new BusinessProcess();
            //可以尝试生成整数哈希值，一来是防伪，二来是不容易冲突
            blockMapper.insertBPDescription(bp);
            businessProcesssId = bp.getBpId();
        } else {
            bp = blockMapper.findBPByBPId(bpId);
            businessProcesssId = bpId;
        }
        tx.setBpId(businessProcesssId);
        tx.setSenderAck(true);
        tx.setTransId(preTransId + 1);
        tx.setCreateTime(new Timestamp(System.currentTimeMillis()));
        //协作业务流程发起者申请联盟链
        if (tx.getTransId().equals(1)) {
            consortiumBlockchainService.downloadPhase(bp, tx);
        } else {
            //协作业务流程响应其他人的任务
            Transaction preTx = blockMapper.findTransactionInInputByTranId(bpId, preTransId);
            consortiumBlockchainService.generatePhase(bp, preTx, tx);
            System.out.println("发起合作成功！");
        }
    }

    /*@Override
    public void createBusinessProcess(String id, String BPDescription, List<Transaction> transactions) {

    }*/

    //"默认接收合作"
    /*@Override
    public void processCooperationRequest(int contractId, boolean cooperationResponse) {
        BPContract bpContract = new BPContract();
        bpContract.setContractId(contractId);
        bpContract.setReceiverAccepted(cooperationResponse);
        bpMapper.updateBPContract(bpContract);
    }*/

    @Override
    public String confirmBusinessProcessCompletion(Integer userId, int bpId) {
        List<Transaction> txs = blockMapper.findWaitingTxsByUserIdAndBpId(userId, bpId);
        if (txs != null && txs.size() > 0) {
            return "还有交易未完成";
        }
        BusinessProcess businessProcess = blockMapper.findBPByBPId(bpId);
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<String>>() {
        }.getType();
        List<String> list = gson.fromJson(businessProcess.getAckUsers(), type);
        List<Integer> userIdlist = new ArrayList<>();
        for (String s : list) {
            userIdlist.add(Integer.parseInt(s));
        }
        userIdlist.add(userId);
        if (userIdlist.size() == businessProcess.getUserList().size()) {
            Timestamp comTime = new Timestamp(System.currentTimeMillis());
            businessProcess.setCompleteTime(comTime);
            //TODO 合作结束上传协作数据

//                if(consortiumBlockchainService.generatePhase()){
//
//                }


        }
        businessProcess.setAckUsers(gson.toJson(userIdlist));
        blockMapper.updateBP(businessProcess);
        return "";

    }

    @Override
    public void processTxInCooperation(Integer userId, int transId, int bpId) {
        //通过看所有接收者是否都ack 判断流程是否结束
//        int bpId = t.getBpId();
        BusinessProcess bp = blockMapper.findBPByBPId(bpId);
        boolean allOver = true;
        //TODO: 这里需要查所有的tx，而不是只有本地的

        List<Transaction> nextTxs = blockMapper.findTxsInOutputByTranId(bpId, transId + 1);
        //如果没有后继节点
        if (!nextTxs.isEmpty()) {
            //如果有后继节点没有完成，则返回错误
            for (Transaction tx : nextTxs) {
                if (!tx.getReceiverAck()) {
                    allOver = false;
                    System.out.println("还有后续任务没有完成！");
                    break;
                }
            }
        }

        //如果全部后继任务都完成了或没有后继任务则返回确认
        if (allOver) {
            //只处理自己接受的任务，意味着这笔tx也完成了，不需要再判断sender了
            Transaction t = blockMapper.findTransactionInInputByTranId(bpId, transId);
            t.setReceiverAck(true);
            Timestamp comTime = new Timestamp(System.currentTimeMillis());
            t.setCompleteTime(comTime);
            t.setHash();
            blockMapper.updateTransaction_input(t);

            //通知之前的节点该任务已完成
            Transaction tempTx = new Transaction();
            tempTx.setBpId(t.getBpId());
            tempTx.setSenderId(t.getReceiverId());
            tempTx.setReceiverId(CooperationUtil.FINISH_USER_ID);
            consortiumBlockchainService.generatePhase(bp, t, tempTx);

            if (transId == 0) {
                //说明是第一个用户发布的，此时整个bp都完成了，第一轮的迭代完成
                bp.setCompleteTime(comTime);
                blockMapper.updateBP(bp);
                System.out.println("该BP已经完成！");

                //向后通知传送数据
            }
        }
//        for (Transaction transaction : bp.getTxList()) {
//            if (!transaction.getReceiverAck()) {
//                allOver = false;
//                break;
//            }
//        }

    }
}
