package com.test.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.springframework.ui.Model;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.care.member_dao.LogDAO;
import com.care.member_dto.LogDTO;


public class LogSaveServiceImpl{

	public void loginstart() {
		ServletRequestAttributes sra = (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
		HttpServletRequest request = sra.getRequest();
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("mySession");
		Date date = new Date();
		SimpleDateFormat simpleDateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String starttime = simpleDateformat.format(date);
		LogDAO dao = new LogDAO();
		LogDTO dto = new LogDTO();
		dto.setId(id);
		dto.setStarttime(starttime);
		dao.saveLog(dto);
		//세션에 저장해서 넘겨주기 dao에 저장xxx
		
	}
	
	public void loginend() throws ParseException {
		LogDAO dao = new LogDAO();
		ServletRequestAttributes sra = (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
		HttpServletRequest request = sra.getRequest();
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("mySession");
		String beforetime = dao.log(id).getStarttime();
		LogDTO dto = new LogDTO();
		dto.setId(id);
		Date date = new Date();
		SimpleDateFormat simpleDateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String endtime = simpleDateformat.format(date);
		dto.setEndtime(endtime);
		Date starttime = simpleDateformat.parse(beforetime);
		long date2 = date.getTime() - starttime.getTime();
		int resulttime = (int) date2;
		String resulttime2 = resulttime+"";
		dto.setResulttime(resulttime2);
		dao.updateLog(dto);
	}

}
