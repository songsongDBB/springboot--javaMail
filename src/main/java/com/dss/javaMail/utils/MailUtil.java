package com.dss.javaMail.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/**
 * 发送邮件的工具类
 * @author duan ss
 *
 */
@Component
public class MailUtil {

	@Autowired
	private JavaMailSender javaMailSender;

	/**
	 * 发送邮件
	 * @param toUser	收件人
	 * @param code		激活码
	 * @return
	 */
	public String send(String toUser, String code) {
		
		// 建立邮件消息
		SimpleMailMessage mainMessage = new SimpleMailMessage();
		
		// 发送者
		mainMessage.setFrom("547674051@qq.com");
		
		// 接收者
		mainMessage.setTo(toUser);
		
		// 发送的标题
		mainMessage.setSubject("注册激活邮件");
		
		// 发送的内容
		mainMessage.setText("<h1>来自xxx网站的注册激活邮件，激活请点击以下链接：http://localhost:8081/user/regActive?code="+code+"");
		
		javaMailSender.send(mainMessage);
		
		return "success";
	}

}
