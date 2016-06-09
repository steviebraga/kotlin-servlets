package persistence

import model.Car
import java.io.File
import javax.servlet.ServletContextEvent
import javax.servlet.ServletContextListener
import javax.servlet.annotation.WebListener

@WebListener
class InitDatabaseListener: ServletContextListener {
	
	override fun contextInitialized(servletContextEvent: ServletContextEvent) {
		println(sql2o.dataSource.connection)
		sql2o.beginTransaction().createQuery(CREATE_CAR_TABLE).executeUpdate().commit()
		
//		val carsFile = File(this.javaClass.classLoader.getResource("cars.txt").path)
		val carsFile = File(servletContextEvent.servletContext.getRealPath("/WEB-INF/classes/cars.txt"))
		
		val carRepository: CarRepository = CarRepository()
		
		for (carFields in carsFile.readLines()) {
			var(brand, model, year) = carFields.split(";")
			carRepository.addCar(Car(0, brand, model, year.toInt()))
		}
	}

	override fun contextDestroyed(servletContextEvent: ServletContextEvent) {
		
	}
	
}