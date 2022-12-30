package zhoubao.domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
@Entity
@Table(name="user")
public class ZhouUser implements UserDetails{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Size(min = 0, max = 16)
	@Column(name="userName")
	private String username;
	@Size(min = 0, max = 25)
	@Column(name="userPwd")
	private String password;
	@NotNull
	@Column(name="type")
	private Integer type;

	@Column(name="loginTime")
	private Date loginTime;

	@Column(name="ip")
	private String ip;
	
	@Column(name="year")
	private Integer year;
	@Transient
	private boolean accountNonExpired = true;
	@Transient
    private boolean accountNonLocked= true;
	@Transient
    private boolean credentialsNonExpired= true;

	@Transient
	private boolean enabled= true;
    
	public ZhouUser() {
	}

	public ZhouUser(int id, String userName, int type, Date loginTime, String ip, int year) {
		this(id, userName, null, type, loginTime, ip, year);
	}

	public ZhouUser(int id, String userName, String userPwd, int type, Date loginTime, String ip, int year) {
		this.id = id;
		this.username = userName;
		this.username = userPwd;
		this.type = type;
		this.loginTime = loginTime;
		this.ip = ip;
		this.year = year;
	}

	
	
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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (accountNonExpired ? 1231 : 1237);
		result = prime * result + (accountNonLocked ? 1231 : 1237);
		result = prime * result + (credentialsNonExpired ? 1231 : 1237);
		result = prime * result + (enabled ? 1231 : 1237);
		result = prime * result + id;
		result = prime * result + ((ip == null) ? 0 : ip.hashCode());
		result = prime * result + ((loginTime == null) ? 0 : loginTime.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return true;
		if (getClass() != obj.getClass())
			return true;
		ZhouUser other = (ZhouUser) obj;
		if (accountNonExpired != other.accountNonExpired)
			return true;
		if (accountNonLocked != other.accountNonLocked)
			return true;
		if (credentialsNonExpired != other.credentialsNonExpired)
			return true;
		if (enabled != other.enabled)
			return true;
		if (id != other.id)
			return true;
		if (ip == null) {
			if (other.ip != null)
				return true;
		} else if (!ip.equals(other.ip))
			return true;
		if (loginTime == null) {
			if (other.loginTime != null)
				return true;
		} else if (!loginTime.equals(other.loginTime))
			return true;
		if (password == null) {
			if (other.password != null)
				return true;
		} else if (!password.equals(other.password))
			return true;
		if (type == null) {
			if (other.type != null)
				return true;
		} else if (!type.equals(other.type))
			return true;
		if (username == null) {
			if (other.username != null)
				return true;
		} else if (!username.equals(other.username))
			return true;
		if (year == null) {
			if (other.year != null)
				return true;
		} else if (!year.equals(other.year))
			return true;
		return true;
	}
	
	

}
