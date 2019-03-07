package maven_project_001.maven_project_002;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestngForMavenDemo {
	WebDriver driver;
	 @Test(priority=1,  description="login with valid username and password")
	  public void logiwithvaliddetails() {
		  System.out.println("In logiwithvaliddetails under");
		  String act_title=driver.getTitle();
		  String exp_title="Welcome: Mercury Tours";
		  AssertJUnit.assertEquals(act_title, exp_title);
		  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("diptichopade");
		  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("chopade123");
		  driver.findElement(By.xpath("//input[@name='login']")).click();
		  boolean act_flag=driver.findElement(By.xpath("//img[@src='/images/nav/logo.gif']")).isDisplayed();
		  boolean act_flag1=true;
		  Assert.assertEquals(act_flag, act_flag1);
		  driver.findElement(By.linkText("SIGN-OFF")).click();
		  System.out.println("user has login succesfully");
		  
	  }
	 
	 @Test(priority=2,  description="Verify login with valid username and password")
	 public void verifydetails()
	 {
      String act_title1=driver.getTitle();
      String exp_title1="Sign-on: Mercury Tours";
      Assert.assertEquals(exp_title1, act_title1, "wrong");
	 }
	 
	 @Test(priority=3,  description="login with Invalid username and password")
	 public void loginwithInvaliddetails(){
		 driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("diptichopade");
		  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("chopade");
		  boolean act_flag=driver.findElement(By.xpath("//img[@src='/images/nav/logo.gif']")).isDisplayed();
		  Assert.assertFalse(act_flag, "wronn msg");

	 }

	 @BeforeMethod
	  public void beforeMethod() {
		  
		  System.out.println("In getcookies method under beforeMethod");
		  Set<Cookie> cookies= driver.manage().getCookies();
		  System.out.println("get all cookies under beforeMethod");
		  for(Cookie cookie:cookies)
		  {
			  System.out.println(cookie.getName());
			  
		  }
	  }

	  @AfterMethod
	  public void capturescreenshot() throws IOException {
		  
		  System.out.println("In capturescreenshot under AfterMethod");
		  File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(src,new File("F:\\cjc_software\\java elipse\\eclips\\maven_project_002\\src\\test\\resource\\Screenshot\\Screenshotmercury.jpeg"));
		  System.out.println("get screenshot successfully");
	  }
 
	  @BeforeClass
	  public void browser_maximize() {
		  System.out.println("In browser_maximize method under BeforeClass");
		  driver.manage().window().maximize();
		  System.out.println("maximize window succesfully");
	  }

	  @AfterClass
	  public void DeteleAllCookies() {
		  
		  System.out.println("In DeteleAllCookies under afterClass");
		  driver.manage().deleteAllCookies();
		  System.out.println("Delete allcookies succesfully");
	  }

	  @BeforeTest
	  public void getApplicationurl(){
		  System.out.println("In getApplicationurl method under beforeTest");
		  driver.get("http://newtours.demoaut.com/");
		  System.out.println("add browser url to open browser successfully");
	  }

	  @AfterTest
	  public void dbconnectionclosed() {
		  System.out.println("In dbconnectionclosed under afterTest");
		  
	  }

	  @BeforeSuite
	  public void open_browser() {
		  System.out.println("In open_browser method under beforeSuite");
		  System.setProperty("webdriver.chrome.driver","F:\\16122018\\chromedriver_win32\\chromedriver.exe");
		  driver=new ChromeDriver();
	      System.out.println("browser path");
	  }

	  @AfterSuite
	  public void Browser_closed() {
		  System.out.println("In Browser_closed under afterSuite");
		  driver.close();
		  System.out.println("browser closed sucessfully");
		  
	  }
}
