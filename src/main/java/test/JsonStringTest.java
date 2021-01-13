package test;

public class JsonStringTest {

    public static void main(String[] args) {
        String bpData = "{\"bpId\":1,\"createTime\":1610433332744,\"receiverId\":1,\"senderAck\":true,\"senderId\":2,\"tranDescription\":\"test\",\"transId\":2}$${\"ackUsers\":\"[]\",\"bpId\":1,\"createTime\":1610384298000,\"txList\":[{\"bpId\":1,\"createTime\":1610333898000,\"receiverAck\":false,\"receiverId\":2,\"senderAck\":true,\"senderId\":1,\"tranDescription\":\"test\",\"transId\":1},{\"bpId\":1,\"createTime\":1610420129000,\"receiverAck\":false,\"receiverId\":1,\"senderAck\":true,\"senderId\":2,\"tranDescription\":\"test2\",\"transId\":2},{\"bpId\":1,\"createTime\":1610420176000,\"receiverAck\":false,\"receiverId\":1,\"senderAck\":true,\"senderId\":2,\"tranDescription\":\"test2\",\"transId\":2},{\"bpId\":1,\"createTime\":1610420524000,\"receiverAck\":false,\"receiverId\":1,\"senderAck\":true,\"senderId\":2,\"tranDescription\":\"t7\",\"transId\":2},{\"bpId\":1,\"createTime\":1610433304000,\"receiverAck\":false,\"receiverId\":1,\"senderAck\":true,\"senderId\":2,\"tranDescription\":\"111\",\"transId\":2}],\"userList\":[{\"assessment\":\"ass\",\"coreBusiness\":\"core\",\"description\":\"des\",\"identity\":\"u1\",\"userid\":1,\"username\":\"u1\"},{\"assessment\":\"ass\",\"coreBusiness\":\"core\",\"description\":\"des\",\"identity\":\"u2\",\"userid\":2,\"username\":\"u2\"}]}\n";
        String testData = "a$b";
        String[] test = testData.split("$");
        System.out.println(test[0]);
    }
}
