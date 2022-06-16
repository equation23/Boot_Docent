package com.docent.dsel.entity;

import lombok.*;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
@Table(name = "tbl_doc")
@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Board {
    @Id
    private Long bno;
    private String title;
    private String image;
    private String classify;
    private String location;
    private String introduce;
    private String audio;

    @LastModifiedDate
    private LocalDateTime updatedate;
}
