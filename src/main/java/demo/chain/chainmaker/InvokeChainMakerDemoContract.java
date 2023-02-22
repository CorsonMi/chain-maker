package demo.chain.chainmaker;

import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.tbaas.v20180416.TbaasClient;
import com.tencentcloudapi.tbaas.v20180416.models.InvokeChainMakerDemoContractRequest;
import com.tencentcloudapi.tbaas.v20180416.models.InvokeChainMakerDemoContractResponse;

public class InvokeChainMakerDemoContract {
    private static final String TENCENTCLOUD_SECRET_ID = "xxx";
    private static final String TENCENTCLOUD_SECRET_KEY = "xxx";
    public static void main(String [] args) {
        try{
            Credential cred = new Credential(TENCENTCLOUD_SECRET_ID, TENCENTCLOUD_SECRET_KEY);
            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("tbaas.tencentcloudapi.com");
            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);
            TbaasClient client = new TbaasClient(cred, "ap-beijing", clientProfile);
            InvokeChainMakerDemoContractRequest req = new InvokeChainMakerDemoContractRequest();
            req.setClusterId("chainmaker-demo");
            req.setChainId("chain_demo");
            req.setContractName("ChainMakerDemo");
            req.setFuncName("get");
            req.setFuncParam("{\"field\":\"name\",\"key\":\"student_name\",\"method\":\"get\",\"value\":\"lisi\"}");
            req.setAsyncFlag(0L);
            InvokeChainMakerDemoContractResponse resp = client.InvokeChainMakerDemoContract(req);
            System.out.println(InvokeChainMakerDemoContractResponse.toJsonString(resp));
        } catch (TencentCloudSDKException e) {
            System.out.println(e.toString());
        }
    }
}
