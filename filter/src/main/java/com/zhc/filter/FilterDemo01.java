package com.zhc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @ClassName: FilterDemo01
 * @Description:filter�����ֵ���Ӧ�ã� 1��������filter�и������������Ƿ����chain.doFilter(request,
 *                             response)������ ���Ƿ���Ŀ����Դִ��
 *                             2������Ŀ����Դִ��֮ǰ�����Զ�request\response��Ԥ��������Ŀ����Դִ��
 *                             3����Ŀ����Դִ��֮�󣬿��Բ���Ŀ����Դ��ִ�н�����Ӷ�ʵ��һЩ����Ĺ���
 * @author: �°�����
 * @date: 2014-8-31 ����10:09:24
 */
public class FilterDemo01 implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("FilterName: " + filterConfig.getFilterName());
		System.out.println("----FilterDemo01��ʼ��----");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// ��request��response����һЩԤ����
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		System.out.println("FilterDemo01ִ��ǰ������");
		chain.doFilter(request, response); // ��Ŀ����Դִ�У�����
		System.out.println("FilterDemo01ִ�к󣡣���");
	}

	@Override
	public void destroy() {
		System.out.println("----FilterDemo01����----");
	}
}