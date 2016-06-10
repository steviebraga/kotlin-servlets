
package servlets

import freemarker.template.Configuration
import persistence.CarRepository
import java.io.File
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import freemarker.template.TemplateExceptionHandler
import freemarker.template.Template

@WebServlet("/cars")
class CarsServlet: HttpServlet() {
	
	override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
		val carRepository: CarRepository = CarRepository()
		
		response.contentType = "text/html"
		
		val templatesDir: File = File(this.javaClass.classLoader.getResource("templates").file)
		
		var freemarkerConfiguration: Configuration = Configuration(Configuration.VERSION_2_3_23)
		freemarkerConfiguration.setDirectoryForTemplateLoading(templatesDir)
		freemarkerConfiguration.defaultEncoding = "UTF-8"
		freemarkerConfiguration.templateExceptionHandler = TemplateExceptionHandler.HTML_DEBUG_HANDLER
		freemarkerConfiguration.logTemplateExceptions = false
		
		var dataModel = mapOf("cars" to carRepository.getCars())
		var carListTemplate: Template = freemarkerConfiguration.getTemplate("car-list.ftl")
		
		carListTemplate.process(dataModel, response.writer)
		
		response.writer.close()
	}
	
}