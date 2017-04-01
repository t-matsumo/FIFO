package fifo.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import fifo.form.DeadlineForm;

@Entity
public class Deadline implements Serializable {
  @Transient
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;

  @Column(nullable = false)
  private String task;

  @Column(nullable = false)
  private int year;
  
  @Column(nullable = false)
  private int month;
  
  @Column(nullable = false)
  private int day;

  @Column(nullable = false)
  private Timestamp createdAt;

  public Deadline() {}

  public Deadline(String task, int year, int month, int day) {
    this.task      = task;
    this.year      = year;
    this.month     = month;
    this.day       = day;
    this.createdAt = new Timestamp(System.currentTimeMillis());
  }

  public String tell() {
    return year + "年" + month + "月" + day + "日";
  }

  public DeadlineForm createDeadlineForm() {
    return new DeadlineForm(task, year, month, day);
  }

  public void update(String task, int year, int month, int day) {
    this.task  = task;
    this.year  = year;
    this.month = month;
    this.day   = day;
  }

  public Long getId() {
    return this.id;
  }

  public String getTask() {
    return this.task;
  }

  public int getYear() {
    return this.year;
  }

  public int getMonth() {
    return this.month;
  }

  public int getDay() {
    return this.day;
  }
}