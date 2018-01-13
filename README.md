# boot-formcomp
automatic form complete

# for starting application
mvn package "-Dmaven.test.skip=true" && java -jar target/gs-spring-boot-0.1.0.jar

run Application directly

SeleniumAutoCompleteHandler also has main method for testing selenium

firefox version should be < 27 and > 23.

localhost:8080/
for post model has to be sent
{
	"address": "adress",
	"name": "burak"
	...
}
selenium
https://www.grazitti.com/resources/articles/automating-different-input-fields-using-selenium-webdriver/

to make a windows service
https://dzone.com/articles/spring-boot-as-a-windows-service-in-5-minutes