package com.book.manager.util.http;


import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.book.manager.exception.CheckException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * Description : XXXX
 * Author by zengh17
 * Date on 2021/1/27 16:53
 */
public class HttpBase {
    private static final Logger logger = LoggerFactory.getLogger(HttpBase.class);


    /**
     * form表表单提交
     * @param url
     * @param params
     * @return
     */
    public static ResponseEntity<String> httpPostWithFormData(String url, MultiValueMap<String, String> params){
        ResponseEntity<String> response =null;
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            // 以表单的方式提交
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            //将请求头部和参数合成一个请求
            HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, headers);
            //执行HTTP请求，将返回的结构使用ResultVO类格式化
            response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
            logger.info("post --> 请求的url ："+url +" ,请求头信息 headers : "+headers+" ,请求参数 params"+params);
//            logger.info("post --> 返回的response ："+response);
        } catch (Exception e) {
            logger.error("调用接口异常，{}", e);
            throw new CheckException(e.getMessage());
        }
        return response;
    }


    /**
     * Json提交
     * @param url
     * @param json
     * @return
     */
    public static ResponseEntity<String> httpPost(String url, Map<String,Object> map, String json){
        ResponseEntity<String> response =null;
        if(map!=null){
            try {
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                // 以Json的方式提交
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    headers.add(entry.getKey(),entry.getValue().toString());
                }
                //将请求头部和参数合成一个请求
                HttpEntity<String> requestEntity = new HttpEntity<>(json, headers);
                //执行HTTP请求，将返回的结构使用ResultVO类格式化
                response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
                logger.info("post --> 请求的url ："+url +" ,请求头信息 headers : "+headers+" ,请求参数 json : "+json);
                logger.info("post -->  返回的response ："+response);
            } catch (Exception e) {
                logger.error("调用接口异常，{}", e);
                throw new CheckException(e.getMessage());
            }
        }
        return response;
    }





    /**
     * Json提交
     * @param url
     * @param json
     * @return
     */
    public static ResponseEntity<String> httpPost(String url, String json){
        ResponseEntity<String> response =null;
        Map<String,Object> map=new HashMap<>();
        try {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            // 以Json的方式提交
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                headers.add(entry.getKey(),entry.getValue().toString());
            }
            //将请求头部和参数合成一个请求
            HttpEntity<String> requestEntity = new HttpEntity<>(json, headers);
            //执行HTTP请求，将返回的结构使用ResultVO类格式化
            response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
            logger.info("post --> 请求的url  ："+url +" ,请求头信息 headers : "+headers+" ,请求参数 json : "+json);
            logger.info("post --> 返回的response ："+response);
        } catch (Exception e) {
            logger.error("调用接口异常， {}", e);
            throw new CheckException(e.getMessage());
        }

        return response;
    }




    /**
     * form表表单提交
     * @param url
     * @param params
     * @return
     */
    public static ResponseEntity<String> httpPost(String url, Map<String,Object> map, MultiValueMap<String, String> params){
        ResponseEntity<String> response =null;
        if(map!=null){
            try {
                RestTemplate restTemplate = new RestTemplate();
                HttpHeaders headers = new HttpHeaders();
                // 以表单的方式提交
                if(map==null){
                    headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
                }
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    headers.add(entry.getKey(),entry.getValue().toString());
                }
                //将请求头部和参数合成一个请求
                HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, headers);
                //执行HTTP请求，将返回的结构使用ResultVO类格式化
                response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
            logger.info("post --> 请求的url ："+url +" ,请求头信息 headers : "+headers+" ,请求参数 params"+params);
            logger.info("post --> 返回的response ："+response);
            } catch (Exception e) {
                logger.error("调用接口异常，{}", e);
                throw new CheckException(e.getMessage());
            }
        }

        return response;
    }


    /**
     * Json提交
     * @param url
     * @param json
     * @return
     */
    public static ResponseEntity<String> httpPostWithJson(String url, String cookie, String json){
        ResponseEntity<String> response =null;
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            // 以Json的方式提交
            headers.add("Cookie",cookie);
            headers.setContentType(MediaType.APPLICATION_JSON);
            //将请求头部和参数合成一个请求
            HttpEntity<String> requestEntity = new HttpEntity<>(json, headers);
            //执行HTTP请求，将返回的结构使用ResultVO类格式化
            response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
//            logger.info("post --> 请求的url ："+url +" ,请求头信息 headers : "+headers+" ,请求参数 json : "+json);
            logger.info("post --> 返回的response ："+response);
        } catch (Exception e) {
            logger.error("调用接口异常，{}", e);
            throw new CheckException(e.getMessage());
        }
        return response;
    }


    /**
     * Json提交
     * @param url
     * @param json
     * @return
     */
    public static ResponseEntity<String> httpPutWithJson(String url, String cookie, String json){
        ResponseEntity<String> response =null;
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            // 以Json的方式提交
            headers.add("Cookie",cookie);
            headers.setContentType(MediaType.APPLICATION_JSON);
            //将请求头部和参数合成一个请求
            HttpEntity<String> requestEntity = new HttpEntity<>(json, headers);
            //执行HTTP请求，将返回的结构使用ResultVO类格式化
            response = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
            logger.info("post --> 请求的url ："+url +" ,请求头信息 headers : "+headers+" ,请求参数 json : "+json);
            logger.info("post --> 返回的response ："+response);
        } catch (Exception e) {
            logger.error("调用接口异常，{}", e);
            throw new CheckException(e.getMessage());
        }
        return response;
    }


    /**
     * get带请求头的方式
     * @param url
     * @return
     */
    public static ResponseEntity<String> httpGet(String url){
        ResponseEntity<String> response =null;
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);
            response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);
            logger.info("get --> 请求的url ："+url +" ,请求头信息 headers : "+headers);
            logger.info("get --> 返回的response ："+response);
        } catch (Exception e) {
            logger.error("调用接口异常，{}", e);
            throw new CheckException(e.getMessage());
        }
        return response;
    }


    /**
     * get带请求头的方式
     * @param url
     * @param cookie
     * @return
     */
    public static ResponseEntity<String> httpGet(String url, String cookie){
        ResponseEntity<String> response =null;
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.add("Cookie",cookie);
            HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);
            response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);
            logger.info("get --> 请求的url ："+url +" ,请求头信息 headers : "+headers);
            logger.info("get --> 返回的response ："+response);
        } catch (Exception e) {
            logger.error("调用接口异常，{}", e);
            throw new CheckException(e.getMessage());
        }
        return response;
    }


    /**
     * get带请求头的方式
     * @param url
     * @return
     */
    public static ResponseEntity<String> httpGet(String url, Map<String,Object> map){
        logger.info("get --> 请求的url ："+url +" ,请求头信息 headers : "+map.toString());

        ResponseEntity<String> response ;
        HttpHeaders headers=null;
        try {
            RestTemplate restTemplate = new RestTemplate();
//            restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
            restTemplate.getMessageConverters().add(new FastJsonHttpMessageConverter());
            if(map!=null){
                headers = new HttpHeaders();
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    headers.add(entry.getKey(),entry.getValue().toString());
                }
            }
            HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);
            response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);
            logger.info("get --> 返回的response ："+response);
        } catch (Exception e) {
            logger.error("调用接口异常，{}", e);
            throw new CheckException(e.getMessage());
        }
        return response;
    }

}
