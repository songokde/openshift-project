package com.newcloud.waf.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class ShyyRequestUtil {
	
	/**
	 * POST请求
	 * 
	 * @param postUrl
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public static String[] commPost(String postUrl,Map<String,String> param){
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;
        try{
        	httpClient = HttpClientFactory.getHttpClientFactory().getHttpClient();
            HttpPost post = new HttpPost(postUrl);
        	List<NameValuePair> formparams = new ArrayList<NameValuePair>();
            for (Map.Entry<String, String> entry : param.entrySet()) {
                formparams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
            post.setEntity(urlEncodedFormEntity);
	        response = httpClient.execute(post);
            Integer result = response.getStatusLine().getStatusCode();
            HttpEntity entity = response.getEntity();
            String html = EntityUtils.toString(entity, "UTF-8");
            EntityUtils.consume(entity);
            return new String[]{result.toString(),html};
        }catch (Exception e) {
            return new String[]{"500",e.getMessage()};
        }finally{
        	HttpClientUtils.closeQuietly(response);
        	HttpClientUtils.closeQuietly(httpClient);
        }
    }

}
