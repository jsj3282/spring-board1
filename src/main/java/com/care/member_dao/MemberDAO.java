package com.care.member_dao;

import java.util.ArrayList;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import com.care.member_dto.MemberDTO;
import com.care.template.Constant;

public class MemberDAO {
	private JdbcTemplate template;

	public MemberDAO() {
		this.template = Constant.template;
	}
	public boolean memberChkUser(String id, String pwd) {
		String sql = "select * from member02 where id = '" + id + "'";
		MemberDTO dto = null;
		try {
			dto =  template.queryForObject(sql, new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class));
			System.out.println("===DB : " + dto.getId());
			System.out.println("===DB : " + dto.getPwd());
		}catch(EmptyResultDataAccessException e) {
			e.printStackTrace();
		}
		if(dto == null) {
			return false;
		}else {			
			if(dto.getId().equals(id) && dto.getPwd().equals(pwd)) {
				return true;
			}else {
				return false;
			}
		}
	}
	public boolean memberChk(String id, String pwd) {
		String sql = "select * from member02 where id = '" + id + "'";
		MemberDTO dto = null;
		try {
			System.out.println(id);
			System.out.println(template);
			dto =  template.queryForObject(sql, new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class));
		}catch(EmptyResultDataAccessException e) {
			e.printStackTrace();
		}
		if(dto==null) {
			String sql2 = "insert into member02 values(?,?)";
			template.update(sql2, ps->{
				ps.setString(1,  id);
				ps.setString(2,  pwd);
			});
			return true;
		}else {
			return false;
		}
	}
	public ArrayList<MemberDTO> list() {
		String sql = "select * from member02";
		ArrayList<MemberDTO> list = (ArrayList<MemberDTO>)template.query(sql, new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class));
		for(int i = 0; i<list.size(); i++) {
			System.out.println(list.get(i).getId());
			System.out.println(list.get(i).getPwd());
		}
		return list;

	}
	
	public MemberDTO userInfo(String id) {
		String sql = "select * from member02 where id = '" + id + "'";
		MemberDTO dto = null;
		try {
			dto =  template.queryForObject(sql, new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class));	
			return dto;
		}catch(EmptyResultDataAccessException e) {
			e.printStackTrace();
			return dto;
		}
	}

}
