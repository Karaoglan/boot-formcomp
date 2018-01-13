package hello;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

@Component
public class SeleniumAutoCompleteHandler {

    public static void handle(Model model) {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://sendr-test.remitone.com/");

        driver.findElement(By.name("u_field")).sendKeys("zahid");
        driver.findElement(By.name("p_field")).sendKeys("Zahid1234");
        driver.findElement(By.name("Submit")).click();
        driver.navigate().to("http://sendr-test.remitone.com/member_new.php");

        driver.findElement(By.name("fname")).sendKeys(model.getName());
        driver.findElement(By.name("lname")).sendKeys(model.getSurname());
        new Select(driver.findElement(By.name("nationality"))).selectByVisibleText(model.getNationality());
        new Select(driver.findElement(By.name("gender"))).selectByVisibleText(model.getGender().getValue());
        driver.findElement(By.name("country")).sendKeys(model.getCountry()); //dr with coun. code
        driver.findElement(By.name("address1")).sendKeys(model.getAddress());
        driver.findElement(By.name("email")).sendKeys(model.getEmail());
        driver.findElement(By.name("input_telephone")).sendKeys(model.getPhone());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
        driver.findElement(By.name("dob")).sendKeys(model.getBirthDate().format(formatter));

        new Select(driver.findElement(By.name("id1_type"))).selectByVisibleText("Passport");
        driver.findElement(By.name("id1_details")).sendKeys(model.getIdentityNo());

        driver.findElement(By.name("id1_expiry")).sendKeys(model.getExpiryDate().format(formatter));

    }

    public static void main(String[] args) {
        Model m = new Model();
        m.setGender(Model.Gender.M);
        m.setName("burak");
        m.setSurname("karaoglan");
        m.setNationality("Turkey");
        m.setGender(Model.Gender.M);
        m.setCountry("Turkey");
        m.setAddress("address");
        m.setEmail("sda@email.com");
        m.setPhone("123132");
        m.setBirthDate(LocalDate.now());
        m.setIdentityNo("12312123");
        m.setExpiryDate(LocalDate.now());

        handle(m);
    }
}
