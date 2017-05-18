package com.traveledge.common;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
 
public class GetScreenShot {
	
     
    public static String capture(WebDriver driver,String screenShotName) throws IOException
    {
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        System.out.println("screenshot"+source);
        String dest = System.getProperty("user.dir") +"/ErrorScreenshots/"+screenShotName+".png";
        File destination = new File(dest);
        System.out.println(destination);
        FileUtils.copyFile(source, destination);        
                     
        return dest;
    }
   
}