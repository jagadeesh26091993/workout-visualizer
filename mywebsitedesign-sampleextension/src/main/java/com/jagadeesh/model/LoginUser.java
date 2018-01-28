package com.jagadeesh.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//Entity class for storing the login details of the user
@Entity
@Table(name="login_table")
public class LoginUser {

	@Id
	  @Column(name = "USERNAME")
	  private String username;

	  @Column(name = "PASSWORD", nullable = false)
	  private String password;

	  @Column(name = "ENABLED", nullable = false)
	  private boolean enabled;

	  @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	  private Set<Authorities> authorities = new HashSet<>();

	  public LoginUser() {}

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

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Authorities> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<Authorities> authorities) {
		this.authorities = authorities;
	}
	  
	public void addAuthorities(Authorities auth)
	{
		authorities.add(auth);
		auth.setUser(this);
	}
	  
	  
}