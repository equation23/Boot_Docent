package com.docent.dsel.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "tbl_userboard")
public class UserBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ubno")
    private Long ubno;

    @Column(length = 50, nullable = false)
    private String did;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 50, nullable = false)
    private String nickName;

    @Column(length = 3000, nullable = false)
    private String content;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime regDate;

    @LastModifiedDate
    private LocalDateTime updateDate;


    @ElementCollection(fetch = FetchType.LAZY)
    @Builder.Default
    private Set<UserBoardImage> imgSet = new HashSet<>();

    public void change(String title, String content){
        this.title = title;
        this.content = content;
    }

    public void addImage(String fileLink){

        UserBoardImage image = UserBoardImage.builder().fileLink(fileLink)
                .ord(imgSet.size())
                .build();
        imgSet.add(image);
    }

    public void clearImgSet() {

        imgSet.clear();
    }
}
