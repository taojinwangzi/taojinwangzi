package web.ui.test;

import java.awt.AWTException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConfigureChannels {
	public static void main(String[] args) throws AWTException, InterruptedException {
		
        //���������·��
        //��¼ҳ��ַ
		//��ӭԪ��
		//�û���Ԫ��
		//����Ԫ��
		//�û���
		//����
		//��֤��ͼƬԪ��
		//�����������ַ
		//��֤��ͼƬ��ַ
		//ͼƬʶ�����õ�ַ
		//��֤����дԪ��
		//��֤��
		//ȥ�������ַ�Ӣ����ĸ�����Ҫ��д����֤��
		//��¼��ťԪ��
		
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
		
		//�ȴ���¼ҳԪ�س��� �����˺�����
		Login login = new Login();
		login.enterAccountPassword(driver,chromedriver_address,loginpage_address,welcome_element,username_element,pwd_element,username,pwd);
		
		VerificationCodeSaveImg verificationcodesaveimg = new VerificationCodeSaveImg();
		//��λ��֤��ͼƬ
		verificationcodesaveimg.rightClickVerificationCodeImg(driver,verificationcode_element);
		//������֤��ͼƬ
		verificationcodesaveimg.saveImg(savejpg_exe_address);
		
		//��Ϊ���õ������������Ҫ�ȴ�һ��ʱ��
		Thread.sleep(10000);
		
		//��֤��ʶ��ͻ��
		VerificationCodeManage verificationcodemanage = new VerificationCodeManage();
		verificationcode_sendkey = verificationcodemanage.verificationCodeIdentify(verificationcode_img_address,tess4j_address,verificationcode);
		verificationcode_sendkey = verificationcodemanage.verificationCodeProcessing(verificationcode_sendkey);
		
		//������֤��
		login.enterVerificationCode(driver, verificationcode_sendkey_element, verificationcode_sendkey);
		
		//�����¼��ť
		login.clickLoginButton(driver, loginbutton_element);
		
		//�����֤������������֤��ʶ��ͻ��
		CycleLogin cyclelogin = new CycleLogin();
		cyclelogin.loginAgain(driver, welcome_element, verificationcode_element, 
				savejpg_exe_address, verificationcode_img_address, tess4j_address, 
				verificationcode_sendkey, verificationcode_sendkey_element, loginbutton_element);
	}
}
