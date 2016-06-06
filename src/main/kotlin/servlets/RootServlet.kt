package servlets

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet("/")
class RootServlet: HttpServlet() {
	
	override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
		response.writer.write("it works!")
	}
	
}