package com.frnbrz.task;

import com.frnbrz.project.Project;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    private String description;

    @CreatedDate
    @Column(
            nullable = false,
            updatable = false
    )
    private LocalDateTime createDate;

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime lastModified;


    @CreatedBy
    @Column(
            nullable = false,
            updatable = false
    )
    private Integer createdBy;

    @ManyToOne
    @JoinColumn(insertable = false, updatable = false)
    private Project project;

    @Column(name = "project_id", insertable = false, updatable = false)
    private Integer projectId;


    @LastModifiedBy
    @Column(insertable = false)
    private Integer lastModifiedBy;
}
