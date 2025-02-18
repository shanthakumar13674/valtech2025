package servlets;

import java.io.IOException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/depts")
public class DeptServlet extends HttpServlet {
	
	private DeptDAO deptDAO;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		deptDAO = new DeptDAOImpl();
		deptDAO.save(new Dept(1,"HR","Blr"));
		deptDAO.save(new Dept(2,"HR","Ahm"));
		deptDAO.save(new Dept(3,"Dev","Blr"));
		deptDAO.save(new Dept(4,"Dev","Ahm"));
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String operation = req.getParameter("operation");
		HttpSession session = req.getSession();
		Dept current =(Dept) session.getAttribute("current");
		if(current == null) {
			current = deptDAO.first();
		} else	{
			if("First".equals(operation))	{
				current = deptDAO.first();
			} 	else if("Last".equals(operation)) {
				current = deptDAO.last();
			}	else if("Previous".equals(operation))	{
				current = deptDAO.previous(current.getId());
			}	else	{
				current = deptDAO.next(current.getId());
			}
		}
		session.setAttribute("current", current);
//		Expresions in JSP can work with objects in session also...
		req.setAttribute("dept", current);
		
		Cookie [] cookies = req.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			System.out.println(cookies[i].getName()+" "+cookies[i].getValue());
		}
		resp.addCookie(new Cookie("operation", operation));
		req.getRequestDispatcher("depts.jsp").forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("dept", deptDAO.first());
		HttpSession session = req.getSession();
		session.setAttribute("current", deptDAO.first());
		req.getRequestDispatcher("depts.jsp").forward(req, resp);
	}

}









