package persistence

import org.sql2o.Sql2o

const val DB_URL = "jdbc:h2:mem:carsdb"
const val DB_USERNAME = "sa"
const val DB_PASSWORD = ""

const val CREATE_CAR_TABLE = "create table if not exists car (id int auto_increment primary key, brand varchar(50), model varchar(100), year int)"

val sql2o: Sql2o = Sql2o(DB_URL, DB_USERNAME, DB_PASSWORD);
