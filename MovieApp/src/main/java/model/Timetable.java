package model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Timetable {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private String date;
    private int time;


    public Timetable() {
    }

    public Timetable(Long id, String date, int time) {
        this.id = id;
        this.date = date;
        this.time = time;
    }

    enum days{
        Monday, tuesday, Wednesday, Thursday, Friday, Saturday, Sunday
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
