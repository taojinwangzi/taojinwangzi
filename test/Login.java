package web.ui.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
	public void enterAccountPassword(WebDriver driver,String chromedriver_address,String loginpage_address,
		String welcome_element,String username_element,String pwd_element,String username,String pwd)  {
		
		//�ȴ���¼ҳԪ�س���
		WebDriverWait webdriverwait = new WebDriverWait(driver, 8);
		webdriverwait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(welcome_element)));
		WebElement webelement = driver.findElement(By.cssSelector(welcome_element));
		System.out.println(webelement.getText());
		driver.manage().window().maximize();
		
		//�����˺�����
		driver.findElement(By.cssSelector(username_element)).clear();
		driver.findElement(By.cssSelector(username_element)).sendKeys(username);
		driver.findElement(By.cssSelector(pwd_element)).clear();
		driver.findElement(By.cssSelector(pwd_element)).sendKeys(pwd);
	}

	public void enterVerificationCode(WebDriver driver,String verificationcode_sendkey_element,String verificationcode) {
		//������֤��֤
		driver.findElement(By.cssSelector(verificationcode_sendkey_element)).clear();
		driver.findElement(By.cssSelector(verificationcode_sendkey_element)).sendKeys(verificationcode);
	}
		
	public void clickLoginButton(WebDriver driver,String loginbutton_element){
		//�����¼��ť
		driver.findElement(By.cssSelector(loginbutton_element)).click();
 	}
}