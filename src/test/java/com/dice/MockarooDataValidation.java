package com.dice;

import static org.testng.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MockarooDataValidation {
static WebDriver d;
static String cityCountry;
String currentTitle = "Mockaroo  - Random Data Generator and API Mocking Tool | JSON / CSV / SQL / Excel";
	@BeforeClass //runs once for all tests
	public void setUp() {
		System.out.println("Setting up WebDriver in BeforeClass...");
		WebDriverManager.chromedriver().setup();
		d = new ChromeDriver();
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@Test
	public void main() throws InterruptedException, IOException {
		d.get("https://mockaroo.com/");
	//	d.findElement(By.xpath("//div[@class='tagline']"));
		//WebElement title = d.findElement(By.tagName("title"));
		//title.getText();

		//Assert.assertEquals(currentTitle, title);
		WebElement failed=d.findElement(By.xpath("//div[@class='tagline']"));
		 failed.getText();

		 Assert.assertTrue(failed.isDisplayed());
		 
		WebElement failed1=d.findElement(By.xpath("//div[@class='brand']"));
		failed1.getText();
		
		 Assert.assertTrue(failed1.isDisplayed());
		
		//-----------555---------- 
		 click("//a[@class='close remove-field remove_nested_fields']");
		///-----6666------------- 
		 isDis("//a[@class='btn btn-default add-column-btn add_nested_fields']");
		 isDis("//div[@class='column column-header column-options']");
		 isDis("//div[@class='column column-header column-type']");
		 isDis("//div[@class='column column-header column-name']");
		 ///------------7------------
		 WebElement failed2=d.findElement(By.xpath("//a[@class='btn btn-default add-column-btn add_nested_fields']"));
			failed2.getText();
			
			 Assert.assertTrue(failed.isEnabled());
			//--------------888------------
			String n1000= d.findElement(By.xpath("//input[@id='num_rows']")).getAttribute("value");
			System.out.println(n1000);
			String n21000="1000";
		 Assert.assertEquals(n21000, n1000);
		 ////--------------9------
		 isTrue("//select[@id='schema_file_format']","CSV");
		 ///-------10----------
		 isTrue("//select[@id='schema_line_ending']","Unix (LF)");
		 //-----------------11-----------
		WebElement selec= d.findElement(By.xpath("//input[@id='schema_include_header']"));
		 Assert.assertTrue(selec.isSelected());
		 WebElement selec1=d.findElement(By.xpath("//input[@id='schema_bom']"));
		 Assert.assertFalse(selec1.isSelected());
		 ///------12---------------
		 d.findElement(By.xpath("//a[@class='btn btn-default add-column-btn add_nested_fields']")).click();
		 
				  d.findElement(By.xpath("(//input[@placeholder='enter name...'])[7]")).sendKeys("City");
		 
		 //-------------13------------------------///       (//input[@placeholder='choose type...'])[7]
		 WebElement click1=d.findElement(By.xpath("(//input[@placeholder='choose type...'])[7]"));
		 click1.click();
		 Assert.assertTrue(click1.isDisplayed());
		//--------------------14-------------
		 Thread.sleep(2000);
		 d.findElement(By.xpath("//input[@id='type_search_field']")).sendKeys("city"+Keys.TAB+Keys.ENTER);
		 
		//15-- 
		 Thread.sleep(2000);
		 d.findElement(By.xpath("//a[@class='btn btn-default add-column-btn add_nested_fields']")).click();
		 
		 List<WebElement> app= d.findElements(By.xpath("//input[@placeholder='enter name...']"));
		 for(int i =0;i<app.size();i++) {
			 if (i==app.size()-1) {
				 app.get(i).clear();
				 app.get(i).sendKeys("country");
				 break;
			 }
		 }
			 List<WebElement> app1= d.findElements(By.xpath("//input[@placeholder='choose type...']"));
			 for(int j =0;j<app1.size();j++) {
				 if (j==app1.size()-1) {
					 app1.get(j).click();;
				 }
			 
			 }
			 Thread.sleep(2000);
			 
			 d.findElement(By.xpath("//input[@id='type_search_field']")).clear();
			 Thread.sleep(2000);
			 d.findElement(By.xpath("//input[@id='type_search_field']")).sendKeys("country"+Keys.TAB+Keys.ENTER);
			 /////-----------------16-------------
			 Thread.sleep(2000);
		//	 d.findElement(By.xpath("//button[@id='download']")).click();
			 ///   C:\Users\narima\Downloadsb
			 excelReader();
			///---------18-------------------
			 Assert.assertEquals(cityCountry, "City,country");
			 //////----------------19----------
			 int size=excelReader().size();
			 int expec=1000;
			 Assert.assertEquals(size, expec);
			 /////////////-----------20--------------
			 List<String> city=new ArrayList<>();
			 List<String> country=new ArrayList<>();
			 List<String> name=excelReader();
			for(String c:name) {
			 String [] srt=c.split(",");
			 for(int i=0;i<srt.length;i++) {
				 if(i==0) {
				 city.add(srt[0]);
			 }else {
				country.add(srt[1]) ;
			 }
			} }
			//System.out.print(city);
			//System.out.println();
			//System.out.print(country);
			//---22---------------
			String cityMax=city.get(0);
			String cityMin=city.get(0);
			for (int i=0;i<city.size();i++) {
			
				if (cityMax.length()<city.get(i).length()) {
					cityMax=city.get(i);
				}
				if (cityMin.length()>city.get(i).length()) {
					cityMin=city.get(i);
				}
			}
			//System.out.println( cityMax+" "+ cityMin);
			////--------------23----------
			SortedSet<String> sort=new TreeSet<>();
			sort.addAll(country);
			for(String st:sort) {
				System.out.println("country "+ st+"--"+Collections.frequency(country,st));
				
			}
			
			///---------24---------
			Set<String> city4=new HashSet<>();
			city4.addAll(city);
			//--------------25--------
			int unique=0;
			for (int i=0;i<city.size();i++) {
				if(i==city.lastIndexOf(city.get(i))) {
					unique++;
			}
	
		
	}
			System.out.println(city4.size()+"  unique  "+ unique);
			Assert.assertEquals(unique, city4.size());
			
			//---------26--------------
			Set<String> country4=new HashSet<>();
			country4.addAll(country);
			int unique1=0;
			for (int i=0;i<country.size();i++) {
				if(i==country.lastIndexOf(country.get(i))) {
					unique1++;
			}
	
		
	}
			System.out.println(country4.size()+"  unique1 "+ unique1);
			Assert.assertEquals(unique1, country4.size());
			
			
		 }
	public static List excelReader() throws IOException {
		List<String> list = new ArrayList<>();
		BufferedReader br = null;
		String line = "";
		 cityCountry="";
		try {
			br = new BufferedReader(new FileReader("C:\\Users\\narima\\Downloads\\MOCK_DATA (2).csv"));
			while ((line = br.readLine()) != null) {
				if(line.contains("City,country")) {
					cityCountry=line;
				}else {
				list.add(line);
				
		//	System.out.println("Count : "+count++);	
			}}
		} catch (IOException e) {
			e.printStackTrace();
		}
		//System.out.println(list);
		System.out.println(list.size());
		return list;
	}
		 
	
	public static void click(String xpath) throws InterruptedException {
		 List<WebElement> app= d.findElements(By.xpath(xpath));////table[@style='font-size:13px']//tr
			for(WebElement clicke: app) {
				Thread.sleep(1000);
				clicke.click();
				
//			for(int i=0;i<app.size();i++) {
//				System.out.println("index- "+i+" value -"+app.get(i).getText());
			}
	}
			public void isDis(String xpath) {
				
			
			WebElement failed1=d.findElement(By.xpath(xpath));
	failed1.getText();
	
	 Assert.assertTrue(failed1.isDisplayed());
	
			}
	public static void isTrue(String xpath1,String actual) {
		WebElement format = d.findElement(By.xpath(xpath1));
		Select formatSelect = new Select(format);
		String form = formatSelect.getFirstSelectedOption().getText();
		System.out.println(form);
		assertEquals(form, actual);
	
	
	
	
	}
}
