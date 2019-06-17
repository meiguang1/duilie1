package com.hcycom.ctginms.service.tool;

import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

/**      
 * @author: 北京华晨阳通信技术有限责任公司
 * @date:2018年11月7日 下午4:58:02   
 * @name 李硕
 * @Description: 
 */
@Component
public class TestMDFive {

	
	private final String slat = "&^1%3$#5%^&a&s#d^f&";
	
	
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestMDFive a=new TestMDFive();
		String pass=a.meMD5("admin");
		System.out.println(pass);
	}*/
	
	
	public String meMD5(String password){
		
		String base = password + "/" + slat;
		String md5=DigestUtils.md5DigestAsHex(base.getBytes());
		return md5;		
	}

}
