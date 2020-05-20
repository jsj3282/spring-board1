package com.care.member_dao;

import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.care.member_dto.LogDTO;
import com.care.template.Constant;

public class LogDAO {
	private JdbcTemplate template;

	public LogDAO() {
		this.template = Constant.template;
	}
	
	public void saveLog(LogDTO dto) {
		String sql = "insert into userlog values(time_number.nextval,?,?,?,?)";
		template.update(sql, ps->{
			ps.setString(1,  dto.getId());
			ps.setString(2,  dto.getStarttime());
			ps.setString(3,  dto.getEndtime());
			ps.setString(4,  dto.getResulttime());
		});
	}
	
	public void updateLog(LogDTO dto) {
		String sql = "update userlog set endtime=?, resulttime=? where id=?";
		template.update(sql, ps->{
			ps.setString(1,  dto.getEndtime());
			ps.setString(2,  dto.getResulttime());
			ps.setString(3,  dto.getId());
		});
		
	}
	public ArrayList<LogDTO> logs(){
		String sql = "select * from userlog";
		ArrayList<LogDTO> logs = (ArrayList<LogDTO>)template.query(sql,  new BeanPropertyRowMapper<LogDTO>(LogDTO.class));
		return logs;
	}
	
	public LogDTO log(String id) {
		String sql = "select * from userlog where id = '" + id + "'";
		LogDTO log = (LogDTO) template.queryForObject(sql, new BeanPropertyRowMapper(LogDTO.class));
		return log;
	}

}
