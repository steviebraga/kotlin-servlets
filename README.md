# kotlin-servlets

This is an example of a web application that uses kotlin instead of java.

## What is used here:

- Servlet 3.1 API
- [Maven](https://maven.apache.org) as dependency manager and building tool
- Database persistence using [H2 database](http://www.h2database.com) and [sql2o](http://www.sql2o.org)
- Templating using [Freemarker](http://freemarker.org)

## How to run:

* Glassfish

1. Set the **glassfish.dir** property in your *pom.xml* to your glassfish instalation dir
2. If you're not using the default domain *domain1* change the **glassfish.domain** property in *pom.xml* to the one you're using
3. Run the maven command `mvn package glassfish:deploy` in command line ou just `package glassfish:deploy` through eclipse *"Run as > Maven build"*
4. Tip: if you change something and try to run the project again, use the `redeploy` goal instead of `deploy`. And also remember when you're finished to run `glassfish:stop-domain` to stop the server


* Wildfly

TODO


* Jetty

TODO

