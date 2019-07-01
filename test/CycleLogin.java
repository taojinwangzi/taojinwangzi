package web.ui.test;

import java.awt.AWTException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CycleLogin {
	
	//判断页面上是否有欢迎元素顿
	public boolean elementExist(WebDriver driver,String welcome_element) {
		try {
			driver.findElement(By.cssSelector(welcome_element));
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	//如果仍旧有欢迎元素就继续获得验证码
	public void loginAgain(WebDriver driver,String welcome_element,String verificationcode_element,
		String savejpg_exe_address,String verificationcode_img_address,String tess4j_address,String verificationcode,
		String verificationcode_sendkey_element,String loginbutton_element) throws InterruptedException, AWTException {
		
		Thread.sleep(5000);
		
		if (elementExist(driver,welcome_element)) {
			
			VerificationCodeSaveImg verificationcodesaveimg = new VerificationCodeSaveImg();
			//定位验证码图片
			verificationcodesaveimg.rightClickVerificationCodeImg(driver,verificationcode_element);
			//下载验证码图片
			verificationcodesaveimg.saveImg(savejpg_exe_address);
			
			//因为调用第三方软件所以要等待一段时间
			Thread.sleep(10000);
			
			//验证码识别和获得
			VerificationCodeManage verificationcodemanage = new VerificationCodeManage();
			String verificationcode_sendkey = verificationcodemanage.verificationCodeIdentify(verificationcode_img_address,tess4j_address,verificationcode);
			verificationcode_sendkey = verificationcodemanage.verificationCodeProcessing(verificationcode_sendkey);
			
			//输入验证码
			Login login = new Login();
			login.enterVerificationCode(driver,verificationcode_sendkey_element, verificationcode_sendkey);
			
			//点击登录按钮
			login.clickLoginButton(driver, loginbutton_element);
			
			loginAgain(driver,welcome_element,verificationcode_element,
					savejpg_exe_address,verificationcode_img_address,tess4j_address,verificationcode,
					verificationcode_sendkey_element,loginbutton_element);
		}
		else {
			System.out.println("登录成功");
		}
	}
}