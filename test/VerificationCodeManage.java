package web.ui.test;

import java.io.File;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class VerificationCodeManage {
	public String verificationCodeIdentify(String verificationcode_img_address,String tess4j_address,String verificationcode) throws InterruptedException {
		
        File imageFile = new File(verificationcode_img_address);
        ITesseract instance = new Tesseract();
        instance.setDatapath(tess4j_address);

        try {
        	verificationcode= instance.doOCR(imageFile);
            System.out.println(verificationcode);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
        
        return verificationcode;
	}
	public String verificationCodeProcessing(String verificationcode){
		//去除验证码中非数字非英文字母的字符
		verificationcode = verificationcode.replaceAll("[^0-9a-zA-Z]","");
		return verificationcode;
	}
}
