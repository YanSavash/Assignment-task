package ru.netrax.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "last_modification_date")
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date lastModificationDate = new Timestamp(new Date().getTime());

    public Task(long id, String name, String description) {
        this.Id = id;
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Task{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
