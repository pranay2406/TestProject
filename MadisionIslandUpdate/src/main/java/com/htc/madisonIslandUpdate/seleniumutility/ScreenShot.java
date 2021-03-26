package com.htc.madisonIslandUpdate.seleniumutility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShot {
	public static String capturescreenShot(WebDriver driver, String path,String methodname) throws IOException, InterruptedException {

		String screenshotpath = path +"\\"+methodname+ UtilClass.getCurrentTime();
		 //File name=new File(screenshotpath);
		File name=UtilClass.creatingFile(screenshotpath);
		  name.mkdir();

		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//File s = new File(screenshotpath+"\\"+methodname+".jpg");
		File s=UtilClass.creatingFile((screenshotpath+"\\"+methodname+".jpg"));
		FileHandler.copy(file, s);
		return screenshotpath;
	}
}