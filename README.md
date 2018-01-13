# boot-formcomp
automatic form complete

# for starting application
mvn package "-Dmaven.test.skip=true" && java -jar target/gs-spring-boot-0.1.0.jar

run Application directly

SeleniumAutoCompleteHandler also has main method for testing selenium

localhost:8080/
for post model has to be sent
{
	"address": "adress",
	"name": "burak"
	...
}