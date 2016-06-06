package persistence

import org.sql2o.Sql2o

private val dbURL = ""
private val dbUser = ""
private val dbPassword = ""

val sql2o: Sql2o = Sql2o(dbURL, dbUser, dbPassword);

