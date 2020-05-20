package com.care.member_service;

import java.util.ArrayList;


import org.springframework.ui.Model;
import com.care.member_dao.MemberDAO;
import com.care.member_dto.MemberDTO;

public class memberInfoServiceImpl implements MemberService{

	@Override
	public void execute(Model model) {
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberDTO> list = dao.list();
		
		for(int i = 0; i<list.size(); i++) {
			System.out.println(list.get(i).getId());
			System.out.println(list.get(i).getPwd());
		}
		model.addAttribute("list", list);
	
	}

}
