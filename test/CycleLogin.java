package web.ui.test;

import java.awt.AWTException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CycleLogin {
	
	//�ж�ҳ�����Ƿ��л�ӭԪ�ض�
	public boolean elementExist(WebDriver driver,String welcome_element) {
		try {
			driver.findElement(By.cssSelector(welcome_element));
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	//����Ծ��л�ӭԪ�ؾͼ��������֤��
	public void loginAgain(WebDriver driver,String welcome_element,String verificationcode_element,
		String savejpg_exe_address,String verificationcode_img_address,String tess4j_address,String verificationcode,
		String verificationcode_sendkey_element,String loginbutton_element) throws InterruptedException, AWTException {
		
		Thread.sleep(5000);
		
		if (elementExist(driver,welcome_element)) {
			
			VerificationCodeSaveImg verificationcodesaveimg = new VerificationCodeSaveImg();
			//��λ��֤��ͼƬ
			verificationcodesaveimg.rightClickVerificationCodeImg(driver,verificationcode_element);
			//������֤��ͼƬ
			verificationcodesaveimg.saveImg(savejpg_exe_address);
			
			//��Ϊ���õ������������Ҫ�ȴ�һ��ʱ��
			Thread.sleep(10000);
			
			//��֤��ʶ��ͻ��
			VerificationCodeManage verificationcodemanage = new VerificationCodeManage();
			String verificationcode_sendkey = verificationcodemanage.verificationCodeIdentify(verificationcode_img_address,tess4j_address,verificationcode);
			verificationcode_sendkey = verificationcodemanage.verificationCodeProcessing(verificationcode_sendkey);
			
			//������֤��
			Login login = new Login();
			login.enterVerificationCode(driver,verificationcode_sendkey_element, verificationcode_sendkey);
			
			//�����¼��ť
			login.clickLoginButton(driver, loginbutton_element);
			
			loginAgain(driver,welcome_element,verificationcode_element,
					savejpg_exe_address,verificationcode_img_address,tess4j_address,verificationcode,
					verificationcode_sendkey_element,loginbutton_element);
		}
		else {
			System.out.println("��¼�ɹ�");
		}
	}
}