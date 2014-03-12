
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.ClassPathXmlApplicationContext;


@WebServlet("/Controller")
public class Controller extends HttpServlet {
	
	ModelInterface mi;
	
	public void init(ServletConfig config) throws ServletException 
	{
		ClassPathXmlApplicationContext cxt = new ClassPathXmlApplicationContext("springcfg.xml");
		mi = (ModelInterface) cxt.getBean("mb");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int sno = Integer.parseInt(request.getParameter("t1"));
		String name = request.getParameter("t2");
		String location = request.getParameter("t3");
		String email = request.getParameter("t4");
		
		mi.display(sno, name, location, email);
		
		response.sendRedirect("result.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
	
	public void destroy() 
	{
		mi = null;
	}

}
