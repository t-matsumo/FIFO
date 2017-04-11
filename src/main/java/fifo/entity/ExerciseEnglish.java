package fifo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class ExerciseEnglish implements Serializable {
  @Transient
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;

  @Column(nullable = false)
  private String question;

  @Column(nullable = false)
  private String answer;

  public ExerciseEnglish() {}

  public ExerciseEnglish(String question, String answer) {
    this.question = question;
    this.answer = answer;
  }
}