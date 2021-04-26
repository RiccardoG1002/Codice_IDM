package com.corso.filters;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class TimingFilter
 */
@WebFilter("/*")
public class TimeAnalysis implements Filter {

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		long t1 = System.currentTimeMillis();
		chain.doFilter(request, response);
		long t2 = System.currentTimeMillis();
		
		System.out.println("quanto ci metti? " + (t2-t1) + "[ms]");
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}


}
