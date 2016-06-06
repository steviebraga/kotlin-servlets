package persistence

import javax.servlet.ServletContextEvent
import javax.servlet.ServletContextListener
import java.io.File
import model.Car

class InitDatabaseListener: ServletContextListener {
	
	override fun contextInitialized(servletContextEvent: ServletContextEvent) {
		sql2o.open().createQuery(CREATE_CAR_TABLE).executeUpdate().commit()
		
		val carsFile = File(this.javaClass.getResource("cars.txt").file)
		val carRepository: CarRepository = CarRepository()
		
		for (carFields in carsFile.readLines()) {
			var(brand, model, year) = carFields.split(";")
			carRepository.addCar(Car(0, brand, model, year.toInt()))
		}
	}

	override fun contextDestroyed(servletContextEvent: ServletContextEvent) {
		
	}
	
}