package com.jinbo.pms.rbac.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "pms_user")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
/**
 * 
 * @author Administrator  liwx
 *
 */
public class User {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "id", nullable = false)
	    private int id;
	 	@Column(name = "username", nullable = false, length=20)
	 	private String username;
	 	@Column(name = "password", nullable = false, length=20)
	 	private String password;
	 	@Column(name = "realname")
	 	private String realname;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getRealname() {
			return realname;
		}
		public void setRealname(String realname) {
			this.realname = realname;
		}
}
