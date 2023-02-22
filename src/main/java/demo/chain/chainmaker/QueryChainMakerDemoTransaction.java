package demo.chain.chainmaker;

import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.tbaas.v20180416.TbaasClient;
import com.tencentcloudapi.tbaas.v20180416.models.QueryChainMakerDemoTransactionRequest;
import com.tencentcloudapi.tbaas.v20180416.models.QueryChainMakerDemoTransactionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class QueryChainMakerDemoTransaction {
    private static final String TENCENTCLOUD_SECRET_ID = "xxx";
    private static final String TENCENTCLOUD_SECRET_KEY = "xxx";

    public static void main(String[] args) {
        try{
            Credential cred = new Credential(TENCENTCLOUD_SECRET_ID, TENCENTCLOUD_SECRET_KEY);
            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("tbaas.tencentcloudapi.com");
            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);

            TbaasClient client = new TbaasClient(cred, "ap-beijing", clientProfile);
            QueryChainMakerDemoTransactionRequest req = new QueryChainMakerDemoTransactionRequest();
            req.setClusterId("chainmaker-demo");
            req.setChainId("chain_demo");
            req.setTxID("1484aef15f094e87acb0d639345aa046195d1c3e211940efa5f3843aee98eac3");

            QueryChainMakerDemoTransactionResponse resp = client.QueryChainMakerDemoTransaction(req);
            log.info(QueryChainMakerDemoTransactionResponse.toJsonString(resp));
        } catch (TencentCloudSDKException e) {
            System.out.println(e.toString());
        }
    }
}
