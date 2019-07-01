package web.ui.test;

import java.awt.AWTException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConfigureChannels {
	public static void main(String[] args) throws AWTException, InterruptedException {
		
        //浏览器驱动路径
        //登录页网址
		//欢迎元素
		//用户名元素
		//密码元素
		//用户名
		//密码
		//验证码图片元素
		//第三方软件地址
		//验证码图片地址
		//图片识别配置地址
		//验证码填写元素
		//验证码
		//去除非数字非英文字母后的需要填写的验证码
		//登录按钮元素
		
		String chromedriver_address = "D://chromedriver//chromedriver.exe";
		String loginpage_address = "http://xxx.com.cn";
		String welcome_element = "body > div.login-page > div.login-box > h1 > span";
		String username_element = "#username";
		String pwd_element = "#pwd";
		String username = "wangtao1";
		String pwd = "wangtao1";
		String verificationcode_element = "body > div.login-page > div.login-box > form > div > img";
		String savejpg_exe_address = "D://workspace//wangtao//src//web//ui//test//SaveJpg.exe";
		String verificationcode_img_address = "D://workspace//wangtao//src//web//ui//test//1.jpg";
		String tess4j_address = "D://MyDrivers//software//Tess4J";
		String verificationcode_sendkey_element = "body > div.login-page > div.login-box > form > div > input";
		String verificationcode = "";
		String verificationcode_sendkey = "";
		String loginbutton_element = "body > div.login-page > div.login-box > form > button";
		
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver",chromedriver_address);
		driver.get(loginpage_address);
		
		//等待登录页元素出现 输入账号密码
		Login login = new Login();
		login.enterAccountPassword(driver,chromedriver_address,loginpage_address,welcome_element,username_element,pwd_element,username,pwd);
		
		VerificationCodeSaveImg verificationcodesaveimg = new VerificationCodeSaveImg();
		//定位验证码图片
		verificationcodesaveimg.rightClickVerificationCodeImg(driver,verificationcode_element);
		//下载验证码图片
		verificationcodesaveimg.saveImg(savejpg_exe_address);
		
		//因为调用第三方软件所以要等待一段时间
		Thread.sleep(10000);
		
		//验证码识别和获得
		VerificationCodeManage verificationcodemanage = new VerificationCodeManage();
		verificationcode_sendkey = verificationcodemanage.verificationCodeIdentify(verificationcode_img_address,tess4j_address,verificationcode);
		verificationcode_sendkey = verificationcodemanage.verificationCodeProcessing(verificationcode_sendkey);
		
		//输入验证码
		login.enterVerificationCode(driver, verificationcode_sendkey_element, verificationcode_sendkey);
		
		//点击登录按钮
		login.clickLoginButton(driver, loginbutton_element);
		
		//如果验证码错误则继续验证码识别和获得
		CycleLogin cyclelogin = new CycleLogin();
		cyclelogin.loginAgain(driver, welcome_element, verificationcode_element, 
				savejpg_exe_address, verificationcode_img_address, tess4j_address, 
				verificationcode_sendkey, verificationcode_sendkey_element, loginbutton_element);
	}
}
