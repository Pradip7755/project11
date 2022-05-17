package orangehrm.library;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.AppUtils;

public class Employee extends AppUtils
{

	
	public boolean addEmployee(String fname,String lname)
	{
	
		driver.findElement(By.linkText("PIM")).click();
		driver.findElement(By.linkText("Add Employee")).click();
		driver.findElement(By.id("firstName")).sendKeys(fname);
		driver.findElement(By.id("lastName")).sendKeys(lname);
		
		String empid;
		empid = driver.findElement(By.id("employeeId")).getAttribute("value");
		driver.findElement(By.id("btnSave")).click();
		
		driver.findElement(By.linkText("Employee List")).click();
		driver.findElement(By.id("empsearch_id")).sendKeys(empid);	
		driver.findElement(By.id("searchBtn")).click();
		
		WebElement emptable;
		emptable = driver.findElement(By.id("resultTable"));
		List<WebElement> rows,cols;
		
		rows = emptable.findElements(By.tagName("tr"));
		cols =  rows.get(1).findElements(By.tagName("td"));
		if(cols.get(1).getText().equals(empid))
		{
			return true;
		}else
		{
			return false;
		}
					
	}	
	
	
	
		
}
