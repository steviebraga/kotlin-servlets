package servlets

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import persistence.CarRepository

@WebServlet("/cars")
class CarsServlet: HttpServlet() {
	
	override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
		val carRepository: CarRepository = CarRepository()
		response.writer.write(carRepository.getCars().toString())
	}
	
}