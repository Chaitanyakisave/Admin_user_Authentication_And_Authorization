package in;

import java.io.IOException;
import java.net.http.HttpRequest;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 @WebFilter("/userlist/*")
public class Filter1 implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);
        System.out.print(session.getAttribute("role"));
        if (session != null && "ADMIN".equals(session.getAttribute("role"))) {
            chain.doFilter(request, response);
            
        } else {
          //  res.sendRedirect("/index.jsp");res.setContentType("text/html");
        	res.getWriter().print("<h1 style ='color:red'>Your not Admin....</h1>");
        	RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
        	rd.include(req,res);
        }
    }
	}
