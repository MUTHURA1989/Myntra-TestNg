package com.Myntra;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Myntra.rerun.RetryAnalyser;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Women {
	  static WebDriver driver;
	 
	 @BeforeClass
	public void applicationLaunch() {
		WebDriverManager.edgedriver().setup();
	    driver =new EdgeDriver();
		String url="https://www.myntra.com/";
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String currenturl=driver.getCurrentUrl();
		System.out.println(currenturl);
		if(currenturl.startsWith(url)) {
			System.out.println("Application is launched successfully");
			
		}
		else {
			System.out.println("Application is  not launched successfully");

}		
}

	 @Test(priority=2)
	 public void women() {
		   
		        WebElement women =driver.findElement(By.xpath("//a[text()='Women' and @class='desktop-main']"));
		        String text=women.getText();
		        System.out.println(text);
		        women.click();
		        SoftAssert soft=new SoftAssert();
		        soft.assertEquals(text,"men","Assertion failure" );
		        soft.assertAll();
		        if(text.equals("men")) {
					System.out.println("Women button is clicked");
				}
				else {
					System.out.println("Women button is  not clicked");	
				}
		      
		}
	 @Test(priority=3)
	 public void validateWomanPage() {
		 List<WebElement> validate=driver.findElements(By.xpath("//h4[@class='text-banner-title']"));
		 List<String> headers=new ArrayList<String>();
		 headers.add("Biggest Deals On Top Brands");
		 headers.add("Categories To Bag");
		 headers.add("Explore Top Brands");
		 headers.add("Trending In Western Wear");
		 headers.add("Trending In Indian Wear");
		 headers.add("Trending In Sports Wear");
		 headers.add("Trending In Footwear");
		 headers.add("Trending In Footwear");
		 for(int i=0;i<validate.size();i++) {
			 WebElement heading=validate.get(i);
			 String heading1=heading.getText();
			 String headers1=headers.get(i);
			 if(heading1.equals(headers1)) {
				 System.out.println("Actual heading matched expected heading:"+heading1+" vs "+headers1);
			 }
			 else{
				 System.out.println("Actual heading is not matched with expected heading:"+heading1+" vs "+headers1);
			 }
			 
		 }
	 }
	 @Test(priority=4)
	 	 public void clickOnBiba() {
		        WebElement biba = driver.findElement(By.xpath("//img[@src='https://assets.myntassets.com/w_196,c_limit,fl_progressive,dpr_2.0/assets/images/2020/8/31/814b8ff4-1dec-4a6e-86b8-c26f5c40fe4c1598892518923-Biba.jpg']"));
		       biba.click();
		}
	
	 @Test(priority=5)
		public void validateBiba( ) {
		
			List<WebElement> brand=driver.findElements(By.tagName("h3"));
			for(int i=0;i<brand.size();i++) {
				WebElement brandname=brand.get(i);
				String brandname1=brandname.getText();
				if(brandname1.equals("Biba")) {
					System.out.println("Biba product is displayed");
				}
				else {
					System.out.println("Other product is displayed");
				}
			}
			
		}
}
	 