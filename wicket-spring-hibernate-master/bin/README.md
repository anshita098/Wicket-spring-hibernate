# wicket-spring-hibernate
This is an Apache Wicket project, pre-configured with Spring & Hibernate.
To get started, clone this repo and start working

##Whats this?
* Persistence.xml : This file is in the resources/META-INF folder, contains information related to your database.
* beans.xml : This file is in the resources folder and contains information required to run Spring.
* web.xml : This file is in the webapp/WEB-INF folder. It contains the ContextLoaderListener which creates a Spring container for all your components as well as the location of your beans.xml.

##Use as a quickstart
The best way to use this project would be as a maven archetype (quickstart). Here is how to do it:
* Go to the project directory and type `mvn archetype:create-from-project`.
* Go to the `target/generated-sources/archetype` folder.
* Run the `mvn install` command.
This will add the archetype to the .m2/archetype-catalog.xml file.
* After this head to your favourite IDE and re-index the repository.

## How can I help?
* I work heavily with Apache Wicket, this was made as a quickstart to avoid configuration headaches. If you found this useful for yourself, amazing. If you found any issues you can open a ticket or submit a pull request.



