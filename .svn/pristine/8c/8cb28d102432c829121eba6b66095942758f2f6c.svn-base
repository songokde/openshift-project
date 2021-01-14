package com.newcloud.waf.util;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContextBuilder;

public class HttpClientFactory {
	private static HttpClientFactory httpClientFactory = null;

	private CloseableHttpClient httpClient = null;
    private CloseableHttpClient httpsClient = null;
    
    private  RequestConfig requestConfig = null;
	private  final String HTTP = "http";
	private  PoolingHttpClientConnectionManager httpCm = null;
    private  final String HTTPS = "https";
    private  SSLContextBuilder builder = null;
    private  SSLConnectionSocketFactory sslsf = null;
    private  PoolingHttpClientConnectionManager httpsCm = null;
    private  int maxPerRoute = 5;							//链接线程数
    private  int maxTotal = 100;							//每个线程池的最大连接数
    private  int connectTimeout = 30000;					//设置连接超时时间，单位毫秒。
    private  int connectionRequestTimeout = 30000; 			//设置从connect Manager获取Connection 超时时间，单位毫秒。这个属性是新加的属性，因为目前版本是可以共享连接池的。
    private  int socketTimeout = 30000; 					//请求获取数据的超时时间，单位毫秒。 如果访问一个接口，多少时间内无法返回数据，就直接放弃此次调用
	
	private HttpClientFactory(){}
	
	public static HttpClientFactory getHttpClientFactory(){
		synchronized (HttpClientFactory.class) {
			if(httpClientFactory==null){
				httpClientFactory = new HttpClientFactory();
				httpClientFactory.init();
			}
			return httpClientFactory;
		}
	}
	
	private void init(){
		try {
        	//超时
        	requestConfig = RequestConfig.custom()
        			.setConnectTimeout(connectTimeout)
					.setConnectionRequestTimeout(connectionRequestTimeout)
			        .setSocketTimeout(socketTimeout).build();
        	
        	//HTTP
        	Registry<ConnectionSocketFactory> httpReg = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register(HTTP, new PlainConnectionSocketFactory())
                    .build();
        	httpCm = new PoolingHttpClientConnectionManager(httpReg);
        	httpCm.setDefaultMaxPerRoute(maxPerRoute);
        	httpCm.setMaxTotal(maxTotal);
        	
        	//HTTP&HTTPS
            builder = new SSLContextBuilder();
            builder.loadTrustMaterial(null, new TrustStrategy() {
                @Override
                public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                    return true;
                }
            });
            sslsf = new SSLConnectionSocketFactory(builder.build(), new String[]{"SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.2"}, null, NoopHostnameVerifier.INSTANCE);
            Registry<ConnectionSocketFactory> httpsReg = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register(HTTP, new PlainConnectionSocketFactory())
                    .register(HTTPS, sslsf)
                    .build();
            httpsCm = new PoolingHttpClientConnectionManager(httpsReg);
            httpsCm.setDefaultMaxPerRoute(maxPerRoute);
            httpsCm.setMaxTotal(maxTotal);
            
            //创建实例
            httpClient = HttpClients.custom()
                    .setConnectionManager(httpCm)
                    .setDefaultRequestConfig(requestConfig)
                    .setConnectionManagerShared(true)
                    .build();
            httpsClient = HttpClients.custom()
		            .setSSLSocketFactory(sslsf)
		            .setConnectionManager(httpsCm)
		            .setDefaultRequestConfig(requestConfig)
		            .setConnectionManagerShared(true)
		            .build();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	 public CloseableHttpClient getDefaultHttpClient(){
		 return httpClient;
	 }
	 
	 public CloseableHttpClient getDefaultHttpsClient(){
		 return httpsClient;
	 }


    /**
     * 获取HTTPS实例
     * 
     * @return
     * @throws Exception
     */
    public CloseableHttpClient getHttpsClient() throws Exception {
    	 CloseableHttpClient httpClient = HttpClients.custom()
               .setSSLSocketFactory(sslsf)
               .setConnectionManager(httpsCm)
               .setDefaultRequestConfig(requestConfig)
               .setConnectionManagerShared(true)
               .build();
       return httpClient;
    }
    
    /**
     * 获取HTTP实例
     * 
     * @return
     * @throws Exception
     */
    public CloseableHttpClient getHttpClient() throws Exception {
        CloseableHttpClient httpClient = HttpClients.custom()
                .setConnectionManager(httpCm)
                .setDefaultRequestConfig(requestConfig)
                .setConnectionManagerShared(true)
                .build();
        return httpClient;
    }
}
