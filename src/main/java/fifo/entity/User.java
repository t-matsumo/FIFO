package fifo.entity;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class User implements Serializable {
  @Transient
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;

  private String name;
  private String userId;
  private String encodedPassword;
  private Timestamp timestamp;

  public User(String name, String userId, String password) {
    this.name = name;
    this.userId = userId;

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    this.encodedPassword = encoder.encode(password);

    this.timestamp = new Timestamp(System.currentTimeMillis());
  }

  @Override
  public String toString() {
    return String.format(
      "User[id=%d, name='%s', userId='%s', passwordHash='%s', timestamp='$s']",
      id, name, userId, encodedPassword, timestamp);
  }
}