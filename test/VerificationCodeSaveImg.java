package web.ui.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class VerificationCodeSaveImg {
	
	public void rightClickVerificationCodeImg(WebDriver driver,String verificationcode_element) throws AWTException, InterruptedException {
		
		//定位验证码图片
		Actions action = new Actions(driver);
		action.click
		(driver.findElement(By.cssSelector(verificationcode_element)));
		action.contextClick
			(driver.findElement(By.cssSelector(verificationcode_element))).build().perform();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
	}
	   
	public void saveImg(String savejpg_exe_address) {
		
		//使用第三方软件下载验证码图片
		try {
			Runtime.getRuntime().exec(savejpg_exe_address);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
