package com.manager.util.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

import java.util.Map;

/**
 * Description : XXXX
 * Author by zengh17
 * Date on 2021/5/11 18:17
 */
public class HttpUtils extends HttpBase {

    private static final Logger logger= LoggerFactory.getLogger(HttpUtils.class);

    /**
     *
     * @param url
     * @param headers
     * @param obj
     * @return
     */
    public static ResponseEntity<String> doPost(String url, Map headers, Object obj) {
        if(obj instanceof String){
            return httpPost(url, headers, (String) obj);
        }else if (obj instanceof MultiValueMap){
            return httpPost(url,headers, (MultiValueMap<String, String>) obj);
        }else {
            throw new RuntimeException("obj参数不合法!!!");
        }
    }

    /**
     *
     * @param url
     * @param headers
     * @return
     */
    public static ResponseEntity<String> doGet(String url, Map headers) {
        return httpGet(url,headers);
    }


    public static void main(String[] args) {
        String json="{\"id\":\"case_002\",\"name\":\"ASN创建，生成inbAsnHeaderId\",\"request\":{\"url\":\"https://sitwgw.vxlogisticproperties.com/inbound/web/asn/header/add\",\"method\":\"POST\",\"headers\":{\"Content-Type\":\"application/json\",\"tokenId\":\"$tokenId\"},\"json\":{\"externAsnCode\":\"\",\"clientCode\":\"autotest\",\"clientName\":\"自动化测试专用\",\"asnType\":\"INB_NOR\",\"appointmentTotalQty\":\"\",\"statusCode\":\"100\",\"actualTotalQty\":\"\",\"endReceiveDate\":\"\",\"startReceiveDate\":\"\",\"expectedArrivedDate\":\"\",\"actualArrivedDate\":\"\",\"leaveDate\":\"\",\"createdDate\":\"\",\"remark\":\"\",\"vendorCode\":\"\",\"vendorName\":\"\",\"carrierCode\":\"\",\"carrierName\":\"\",\"driver\":\"\",\"driverPhone\":\"\",\"truckNo\":\"\",\"expectedDock\":\"\",\"temperatureRange\":\"\",\"canceledDate\":\"\",\"closedDate\":\"\",\"appointmentDate\":\"\",\"carTemperature\":\"\",\"cargoTemperature\":\"\",\"sealCode\":\"\",\"startUnloadDate\":\"\",\"endUnloadDate\":\"\",\"detail\":{\"orderNo\":\"\",\"inbAsnHeaderId\":\"\",\"lineNo\":\"\",\"externAsnLineNo\":\"\",\"poNo\":\"\",\"poLineNo\":\"\",\"asnCode\":\"\",\"clientCode\":\"autotest\",\"clientName\":\"自动化测试专用\",\"vendorCode\":\"\",\"vendorName\":\"\",\"qcFlag\":0,\"qcAutoAdjustFlag\":0,\"externAsnCode\":\"\",\"skuCode\":\"autotest2\",\"skuName\":\"自动化测试专用货品2\",\"packageCode\":\"PKG033808\",\"appointmentUomCode\":\"EA\",\"appointmentUomName\":\"片\",\"basicUom\":\"EA\",\"basicUomName\":\"片\",\"receiveLocation\":\"RECEIVE_DOCK\",\"receivePallet\":\"\",\"lockReasonCode\":\"\",\"totalGrossWeight\":0,\"totalNetWeight\":0,\"totalWeight\":0,\"mfgDate\":1620887448890,\"receiveDate\":\"\",\"expDate\":1621785600000,\"totalQty\":\"100\",\"openQty\":0,\"adjustedQty\":0,\"receivedQty\":0,\"rejectedQty\":0,\"isActive\":\"\",\"ignoreReceiveControlFlag\":0,\"usingQcSampleBatch\":1,\"uomName\":\"\",\"uomCode\":\"\",\"inventoryQuality\":\"100\",\"putawayRule\":\"\",\"tempZone\":\"\",\"appointmentUomRatio\":1}}},\"validate\":[{\"eq\":[\"$.msg\",\"login success!\"]},{\"eq\":[\"$.code\",0]}]}\n";
        String Sta=json.replace("$tokenId","11111111");
        System.out.println(Sta);
    }
}
