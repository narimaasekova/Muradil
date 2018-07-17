package com.dice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DiceJobSearch {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();//set up path 
WebDriver driver= new ChromeDriver();
driver.manage().window().fullscreen();
driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
String url="https://dice.com";
driver.get(url);
String  actualTitlle=driver.getTitle();
String expectedTitle="Job Search for Technology Professionals | Dice.com";
if (actualTitlle.equals(expectedTitle)) {
	System.out.println("Dice homepage successfully laoded");
	
}else {
	System.out.println("Step fail.Dice homepage didnot laod successfully");
	throw new RuntimeException ("Step fail.Dice homepage didnot laod successfully");
}

String keyword= "java developer";
driver.findElement(By.id("search-field-keyword")).clear();
driver.findElement(By.id("search-field-keyword")).sendKeys(keyword);
String  location ="60660";
driver.findElement(By.name("l")).clear();
driver.findElement(By.name("l")).sendKeys(location);
driver.findElement(By.id("findTechJobs")).click();

String count=driver.findElement(By.id("posiCountId")).getText();
System.out.println(count);
int  countResult=Integer.parseInt(count.replaceAll(",", ""));
if( countResult>0) {
	System.out.println(" Pass :Keyword : "+keyword+" search retuned"+ countResult+" result in "+ location);
	
}else {
	System.out.println(" Fail :Keyword : "+keyword+" search retuned"+ countResult+" result in "+ location);
	
}
driver.close();
System.out.println("Test completed - ");

System.out.println("Turkana changed");
System.out.println("Turkana's second day changes have been made!!!");
	}

}
