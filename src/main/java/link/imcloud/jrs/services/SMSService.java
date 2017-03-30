package link.imcloud.jrs.services;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EncodingUtils;
import org.apache.http.util.EntityUtils;
import org.apache.http.util.NetUtils;
import org.springframework.stereotype.Service;
import sun.net.util.URLUtil;

import java.io.IOException;
import java.net.URLEncoder;

/**
 * Created by 44247 on 2016/8/4 0004.
 */
@Service
public class SMSService {
    private String uid;
    private String key;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String sentSMS(String phones, String content) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        StringBuffer stringBuffer=new StringBuffer(url);
        stringBuffer.append("?Uid=");
        stringBuffer.append(uid);
        stringBuffer.append("&Key=");
        stringBuffer.append(key);
        stringBuffer.append("&smsMob=");
        stringBuffer.append(phones);
        stringBuffer.append("&smsText=");
        stringBuffer.append(URLEncoder.encode(content, "UTF-8"));
        HttpPost httppost = new HttpPost(stringBuffer.toString());
        httppost.setHeader("Content-Type", "application/x-www-form-urlencoded");
        HttpResponse httpResponse=httpclient.execute(httppost);
        return EntityUtils.toString(httpResponse.getEntity(),"UTF-8");
    }

}
