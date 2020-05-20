package com.test.service;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.care.member_dao.LogDAO;
import com.care.member_dto.LogDTO;


public class LogShowServiceImpl {

	public void logs(Model model) {
		LogDAO dao = new LogDAO();
		ArrayList<LogDTO> logs = dao.logs();
		model.addAttribute("logs", logs);
		System.out.println(logs);
	}

}
