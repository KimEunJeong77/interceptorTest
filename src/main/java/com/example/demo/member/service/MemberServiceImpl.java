package com.example.demo.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.member.dto.MemberDTO;
import com.example.demo.member.exception.IdNotFoundException;
import com.example.demo.member.exception.PwMissMatchException;
import com.example.demo.member.mapper.MemberMapper;


@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public List<MemberDTO> findMemberList() {
		// TODO Auto-generated method stub
		return memberMapper.selectMemberList();
	}
	
	@Override
	public MemberDTO findMemberDetail(String id) {
		// TODO Auto-generated method stub
		return memberMapper.selectMemberDetail(id);
	}

	@Override
	public void login(String id, String pw){
		// TODO Auto-generated method stub
		MemberDTO dto=memberMapper.selectMemberDetail(id);
		if(dto==null) throw new IdNotFoundException("���������ʴ�ID");
		else 
			if(! dto.getPw().equals(pw) ) throw new PwMissMatchException("��й�ȣ ����ġ");
	}
}