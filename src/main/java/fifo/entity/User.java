package fifo.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.EnumType;
import javax.persistence.Transient;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import fifo.entity.Deadline;

@Entity
public class User implements Serializable, UserDetails {
  @Transient
  private static final long serialVersionUID = 1L;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @OrderBy("year ASC, month ASC, day ASC")
  private List<Deadline> deadlines; 

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

  public User(String name, String userId, String encodedPassword) {
    this.name            = name;
    this.userId          = userId;
    this.encodedPassword = encodedPassword;

    this.createdAt = new Timestamp(System.currentTimeMillis());
    this.authority = Authority.ROLE_USER;
  }

  @Transient
  public Boolean hasDifferentUserId(String userId) {
    return (this.userId != userId);
  }

  public void update(String name, String userId, String encodedPassword) {
    this.name            = name;
    this.userId          = userId;
    this.encodedPassword = encodedPassword;
  }

  public void addDeadline(Deadline deadline) {
    deadlines.add(deadline);
  }

  @Transient
  public List<Deadline> getDeadlines() {
    return this.deadlines;
  }

  public String getUserId() {
    return this.userId;
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