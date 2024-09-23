package com.Myntra;

import java.time.Duration;
import java.util.ArrayList;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import io.github.bonigarcia.wdm.WebDriverManager;
@Test
public class Kids {

	static WebDriver driver;
   @BeforeClass()
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

	 @Test(priority=2,groups="sanity")
	 public void cickOnKids() {
			WebElement kids=driver.findElement(By.xpath("//a[@class='desktop-main' and text()='Kids']"));
			String text=kids.getText();
			System.out.println(text);
			kids.click();
		    SoftAssert soft=new SoftAssert();
	        soft.assertEquals(text,"kids","Assertion failure" );
	        soft.assertAll();
			if(text.equals("kids")) {
				System.out.println("Kids button is clicked");
			}
			else {
				System.out.println("Kids button is  not clicked");	
			}
		}
	 @Test(priority=3,groups="sanity")
	 public void validateKidsPage() {
		 List<WebElement> validate=driver.findElements(By.xpath("//h4[@class='text-banner-title']"));
		 List<String> headers=new ArrayList<String>();
		 headers.add("Favourite Brands");
		 headers.add("Top Picks");
		 headers.add("Iconic Brands");
		 headers.add("Fashion & Essentials");
		 headers.add("Explore More");
		 headers.add("The Kids Space");
		 headers.add("Budget Buy");
		 headers.add("Shop More Brands");
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
	 @Test(priority=4,groups="regression")
	 public void clickOnAllen() {
	        WebElement Allen = driver.findElement(By.xpath("//img[@src='https://assets.myntassets.com/w_108,c_limit,fl_progressive,dpr_2.0/assets/images/2020/11/9/ab69d015-a975-4bda-990c-49e68938f6b31604926460802-19-FavBrands-AllenSollyJuniors.jpg']"));
	       String text1=Allen.getText();
	       Allen.click();
	       if(text1.equals("Allen")) {
	    	   System.out.println("Expected brand name is displayed");
	       }
	       else {
	    	   System.out.println("Expected brand name is not displayed");
	       }
	   
	}
	@Test(priority=5,groups="regression")
	 public void validateAllen() {
			List<WebElement> brand=driver.findElements(By.tagName("h3"));
			for(int i=0;i<brand.size();i++) {
				WebElement brandname=brand.get(i);
				String brandname1=brandname.getText();
				if(brandname1.startsWith("Allen")) {
					System.out.println("Allen product is displayed");
				}
				else {
					System.out.println("Other product is displayed:"+brandname);
				}
			}
			
		}
	
	 
	 
	 
	 
}