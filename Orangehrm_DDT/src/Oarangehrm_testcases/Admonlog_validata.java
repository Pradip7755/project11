package Oarangehrm_testcases;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import orangehrm.library.LoginPage;
import utils.AppUtils;
import utils.XLutills;

public class Admonlog_validata extends AppUtils
{
    String datafile="C:\\Temp\\DDT_testdatafile.xlsx";
    String datasheet="Adminlog_validdata";
	
	String uid,pwd;
	@Test
	public void checklogin() throws IOException
	{
		int rowcount = XLutills.getrowcount(datafile, datasheet);
		LoginPage lp=new LoginPage();
		for (int i = 1; i <=rowcount; i++)
		{
		uid=XLutills.getstringcelldata(datafile, datasheet, i, 0);
		pwd=XLutills.getstringcelldata(datafile, datasheet, i, 1);
		
		lp.login(uid, pwd);
	    boolean res=lp.isAdminModuleDisplayed();
	    Assert.assertTrue(res);
		if (res)
		{
		XLutills.setcelldata(datafile,datasheet,i,2,"pass");
		XLutills.fillgreencolor(datafile, datasheet, i, 2);
		}else
		{
		XLutills.setcelldata(datafile, datasheet, i, 2,"Fail");
		XLutills.fillredcolor(datafile, datasheet, i, 2);
		} 
		lp.logout();
		}	
	}
	}
