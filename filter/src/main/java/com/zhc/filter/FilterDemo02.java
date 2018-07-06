package com.zhc.filter;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterDemo02 implements Filter {

    /* ��������ʼ��
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("----FilterDemo02��ʼ��----");
        /**
         *  <filter>
                  <filter-name>FilterDemo02</filter-name>
                  <filter-class>me.gacl.web.filter.FilterDemo02</filter-class>
                  <!--����FilterDemo02�������ĳ�ʼ������-->
                  <init-param>
                      <description>����FilterDemo02�������ĳ�ʼ������</description>
                      <param-name>name</param-name>
                      <param-value>gacl</param-value>
                  </init-param>
                  <init-param>
                      <description>����FilterDemo02�������ĳ�ʼ������</description>
                      <param-name>like</param-name>
                      <param-value>java</param-value>
                  </init-param>
            </filter>
            
             <filter-mapping>
                  <filter-name>FilterDemo02</filter-name>
                  <!--��/*����ʾ�������е����� -->
                  <url-pattern>/*</url-pattern>
             </filter-mapping>
         */
        //�õ�������������
        String filterName = filterConfig.getFilterName();
        //�õ���web.xml�ļ������õĳ�ʼ������
        String initParam1 = filterConfig.getInitParameter("name");
        String initParam2 = filterConfig.getInitParameter("like");
        //���ع����������г�ʼ�����������ֵ�ö�ټ��ϡ�
        Enumeration<String> initParameterNames = filterConfig.getInitParameterNames();
        
        System.out.println("FilterName:" + filterName);
        System.out.println(initParam1);
        System.out.println(initParam2);
        while (initParameterNames.hasMoreElements()) {
            String paramName = (String) initParameterNames.nextElement();
            System.out.println(paramName);
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        System.out.println("FilterDemo02ִ��ǰ������");
        chain.doFilter(request, response);  //��Ŀ����Դִ�У�����
        System.out.println("FilterDemo02ִ�к󣡣���");
    }

    @Override
    public void destroy() {
        System.out.println("----FilterDemo02����----");
    }
}