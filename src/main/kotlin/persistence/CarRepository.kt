package persistence

import model.Car
import org.sql2o.Connection

class CarRepository {
	
	val getCarsSql = "select c.id, c.brand, c.model, c.year from car c"
	val addCarSql = "insert into car(brand, model, year) values (:brand, :model, :year)"
	
	fun getCars(): List<Car> {
		return sql2o.open().createQuery(getCarsSql).executeAndFetch(Car::class.java)
	}
	
	fun addCar(car: Car) {
		sql2o.open().createQuery(addCarSql).bind(car).executeUpdate()
	}
	
}