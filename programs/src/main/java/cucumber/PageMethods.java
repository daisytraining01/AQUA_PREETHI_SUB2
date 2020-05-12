package cucumber;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class PageMethods {
	
	public static WebDriver driver;
	
	ArrayList<String> amount=new ArrayList<String>();
	
	List<List<String>> recepients=new ArrayList<List<String>>();
	
	Connection con=null;
	Statement st=null;
	
	public void url() {
		
       System.setProperty("webdriver.chrome.driver", "D:\\project 11-05-2020\\programs\\src\\main\\java\\driver\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.get("http://elastic.rapidtestpro.com:8086/index");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
	}
	public void loginCredentails()
	{
		driver.findElement(By.id("username")).sendKeys("labuser");
		driver.findElement(By.id("password")).sendKeys("labuser@01");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		/*String s1 = driver.findElement(By.xpath("//h2[@]")).getText();
		System.out.println(s1);
		String s2 ="Primary Balance:";
		Assert.assertEquals(s2, s1);*/	
	}
	
	public void SelectAccounts() {
		// TODO Auto-generated method stub
		
		driver.findElement(By.xpath("//a[@role='button'][text()='Transfer ']")).click();
		driver.findElement(By.xpath("//a[text()='Between Accounts']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	public void FundTransferDetails() {
		// TODO Auto-generated method stub
		
		try {
			connectDatabase();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i=0;i<amount.size();i++) {
			
			WebElement element=	driver.findElement(By.xpath("//select[@name='transferFrom']"));
			
			element.click();
			
			Select select=new Select(element);
			
			select.selectByVisibleText("Primary");
		
		    driver.findElement(By.xpath("//input[@id='amount']")).sendKeys(amount.get(i));
		
		    driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		    driver.findElement(By.xpath("//a[@role='button'][text()='Transfer ']")).click();
		    
		    driver.findElement(By.xpath("//a[text()='Between Accounts']")).click();
		
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		}
		
	//	driver.findElement(By.xpath("//a[@class='navbar-brand page-scroll']")).click();
		
		
	}
	public void AmountDeductions() {
		// TODO Auto-generated method stub
		
		driver.findElement(By.xpath("//a[@class='navbar-brand page-scroll']")).click();
		
	}
	public void SignOut() {
		// TODO Auto-generated method stub
		
		driver.findElement(By.xpath("//a[@role='button'][text()='Me ']")).click();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		
	}
	public void SelectReceipts() {
		// TODO Auto-generated method stub
		
		driver.findElement(By.xpath("//a[@role='button'][text()='Transfer ']")).click();
		driver.findElement(By.xpath("//a[text()='Add/Edit Recipient']")).click();
		
	}
	public void fillReceiptDetails() {
		// TODO Auto-generated method stub
		
		try {
			getRecepients();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for(int i=0;i<recepients.size();i++) {
			
			List<String> list=new ArrayList<String>(recepients.get(i));
			
			for(int j=0;j<list.size();j++) {
			
			switch(j) {
			
			case 0 : driver.findElement(By.xpath("//input[@id='recipientName']")).sendKeys(list.get(j));
			         break;
		
			case 1 : driver.findElement(By.xpath("//input[@id='recipientEmail']")).sendKeys(list.get(j));
			         break;
		
			case 2 : driver.findElement(By.xpath("//input[@id='recipientPhone']")).sendKeys(list.get(j));
			         break;
		
			case 3 : driver.findElement(By.xpath("//input[@id='recipientAccountNumber']")).sendKeys(list.get(j));
			         break;
		
			case 4 : driver.findElement(By.xpath("//textarea[@id='recipientDescription']")).sendKeys(list.get(j));
			         break;
		
			}
			
			}
		
		    driver.findElement(By.xpath("//button[@type='submit']")).click();
		    
		}
		
	}

	public void connectDatabase() throws SQLException {
		
		try {
			
			connectDb();
			
			ResultSet rs=st.executeQuery("select * from amount");
			
			while(rs.next()){
				
				amount.add(rs.getString("amount"));
			}
			
		
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void getRecepients() throws SQLException {
		
		try {
			
			connectDb();
			
				
				ResultSet rs=st.executeQuery("select * from receipient");
				
				while(rs.next()){
					
					ArrayList<String> recepient=new ArrayList<String>();
					
					recepient.add(rs.getString("name"));
					recepient.add(rs.getString("email"));
					recepient.add(rs.getString("pno"));
					recepient.add(rs.getString("accountno"));
					recepient.add(rs.getString("description"));
					
					recepients.add(recepient);
				}
			
				
				
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void connectDb() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		con=DriverManager.getConnection("jdbc:mysql://localhost/test","root","mysql");
		
		st=con.createStatement();
	}
}
