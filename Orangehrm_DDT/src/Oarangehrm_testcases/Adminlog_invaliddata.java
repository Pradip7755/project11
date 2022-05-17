package Oarangehrm_testcases;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import orangehrm.library.LoginPage;
import utils.AppUtils;
import utils.XLutills;

public class Adminlog_invaliddata extends AppUtils
{
     String datafile1= "C:\\Temp\\DDT_testdatafile.xlsx";
     String datasheet1= "Adminlog_invaliddata";
	
   
    @Test
	public  void checkadminlogin() throws IOException
	{
    	 String uid,pwd;
    	 LoginPage lp=new LoginPage();
		 int rowcount=XLutills.getrowcount(datafile1,datasheet1);
		 for (int i = 1; i <=rowcount; i++)
		 {
		uid=XLutills.getstringcelldata(datafile1, datasheet1, i, 0);
		pwd=XLutills.getstringcelldata(datafile1, datasheet1, i, 1);
		lp.login(uid, pwd);
		boolean res=lp.isErrMsgDisplayed();
		Assert.assertTrue(res);
		if (res)
		{
		XLutills.setcelldata(datafile1, datasheet1, i, 2,"pass");
		XLutills.fillgreencolor(datafile1, datasheet1, i, 2);
		}else 
		{
		XLutills.setcelldata(datafile1, datasheet1, i, 2,"fail");
		XLutills.fillredcolor(datafile1, datasheet1, i, 2);
		}
		}
	}
	
	 
	
	
	
}
