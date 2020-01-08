package com.qq.b1.member;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="members")
public class MemberVO {
	
	@Id
	private String id;
	//@Column(name="password")
	private String pw;
	@Transient
	private String pw2;
	private String name;
	private String email;

}
