package com.terrydr;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import java.util.Arrays;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr
 * @Description: 测试类
 * @author: YanZhengYuan
 * @Date: 2019/1/7 8:48
 * @version: 1.00
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TerrydrWSApplication.class)
public class TestAXIS {

    @Test
    public void test(){
        try {
            String encodingStyle = "utf-8";
            //WSDL的地址
            String endpoint = "http://www.webxml.com.cn/WebServices/RandomFontsWebService.asmx?wsdl";
            //命名空间，在WSDL中对应的标签是：参见说明第3条
            String targetNamespace = "http://WebXml.com.cn/";
            //具体方法的调用URI，在WSDL中对应的标签是：参见说明第4条
            String soapActionURI = "http://WebXml.com.cn/getCharFonts";
            //具体调用的方法名，在WSDL中对应的标签是：参见说明第5条
            String method = "getCharFonts";
            //调用接口的参数的名字
            String[] paramNames = {"byFontsLength"};
            //调用接口的参数的值
            Integer[] paramValues = {10};


            // 直接引用远程的wsdl文件
            Service service = new Service();
            Call call = (Call)service.createCall();
            call.setTimeout(20000);
            call.setEncodingStyle(encodingStyle);//设置传入服务端的字符集格式如utf-8等

            call.setTargetEndpointAddress(endpoint);
            call.setSOAPActionURI(soapActionURI);
            call.setOperationName(new QName(targetNamespace, method));// WSDL里面描述的接口名称
            call.setUseSOAPAction(true);

            //参数设置
            call.addParameter(new QName(targetNamespace, paramNames[0]),
                    XMLType.XSD_INTEGER, ParameterMode.IN);// 接口的参数

            //返回值设置
//            call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);// 设置返回类型
            call.setReturnClass(java.lang.String[].class);

            //调用 ，如果无参，则new Obe
            String[] result = (String[])call.invoke(new Object[]{paramValues[0]});

            // 打印
            System.out.println("result is " + Arrays.toString(result));
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    @Test
    public void test2(){
        try {
            String encodingStyle = "utf-8";
            //WSDL的地址
            String endpoint = "http://ws.webxml.com.cn/WebServices/WeatherWS.asmx?wsdl";
            //命名空间，在WSDL中对应的标签是：参见说明第3条
            String targetNamespace = "http://WebXml.com.cn/";
            //具体方法的调用URI，在WSDL中对应的标签是：参见说明第4条
            String soapActionURI = "http://WebXml.com.cn/getWeather";
            //具体调用的方法名，在WSDL中对应的标签是：参见说明第5条
            String method = "getWeather";
            //调用接口的参数的名字
            String[] paramNames = {"theCityCode"};
            //调用接口的参数的值
            Integer[] paramValues = {2002};


            // 直接引用远程的wsdl文件
            Service service = new Service();
            Call call = (Call)service.createCall();
            call.setTimeout(20000);
            call.setEncodingStyle(encodingStyle);//设置传入服务端的字符集格式如utf-8等

            call.setTargetEndpointAddress(endpoint);
            call.setSOAPActionURI(soapActionURI);
            call.setOperationName(new QName(targetNamespace, method));// WSDL里面描述的接口名称
            call.setUseSOAPAction(true);

            //参数设置
            call.addParameter(new QName(targetNamespace, paramNames[0]),
                    XMLType.XSD_INTEGER, ParameterMode.IN);// 接口的参数

            //返回值设置
//            call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);// 设置返回类型
            call.setReturnClass(String[].class);

            //调用 ，如果无参，则new Obe
            String[] result = (String[])call.invoke(new Object[]{paramValues[0]});

            // 打印
            System.out.println("result is " + Arrays.toString(result));

        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

}
