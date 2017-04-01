package fifo.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import fifo.entity.Deadline;

public class DeadlineForm {
  @NotNull
  @Size(min = 1)
  private String task;

  @NotNull
  @Min(2016)
  @Max(2100)
  private int year;
  
  @NotNull
  @Min(1)
  @Max(12)
  private int month;
  
  @NotNull
  @Min(1)
  @Max(31)
  private int day;

  public DeadlineForm() {}

  public DeadlineForm(String task, int year, int month, int day) {
    this.task  = task;
    this.year  = year;
    this.month = month;
    this.day   = day;
  }

  public String getTask() {
    return this.task;
  }

  public void setTask(String task) {
    this.task = task;
  }

  public int getYear() {
    return this.year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public int getMonth() {
    return this.month;
  }

  public void setMonth(int month) {
    this.month = month;
  }

  public int getDay() {
    return this.day;
  }

  public void setDay(int day) {
    this.day = day;
  }
}