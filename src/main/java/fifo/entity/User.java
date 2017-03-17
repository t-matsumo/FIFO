package fifo.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.Transient;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import fifo.form.RegisterForm;

@Entity
public class User implements Serializable, UserDetails {
  @Transient
  private static final long serialVersionUID = 1L;

  public enum Authority {ROLE_USER, ROLE_ADMIN};

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false, unique = true)
  private String userId;

  @Column(nullable = false)
  private String encodedPassword;

  @Column(nullable = false)
  private Timestamp createdAt;

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private Authority authority;

  public User() {}

  public User(RegisterForm registerForm) {
    this.name = registerForm.getName();
    this.userId = registerForm.getUserId();

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    this.encodedPassword = encoder.encode(registerForm.getPassword());

    this.createdAt = new Timestamp(System.currentTimeMillis());
    this.authority = Authority.ROLE_USER;
  }

  @Override
  public String getUsername() {
    return this.name;
  }

  @Override
  public String getPassword() {
    return this.encodedPassword;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    List<GrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority(authority.toString()));
    return authorities;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  @Override
  public String toString() {
    return String.format(
      "User[id=%d, name='%s', userId='%s', passwordHash='%s', createdAt='$s']",
      id, name, userId, encodedPassword, createdAt);
  }
}