package com.docent.dsel.entity;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;


@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@ToString
@EqualsAndHashCode(of="fileLink")
public class UserBoardImage {
    private String fileLink;

    private int ord;

}
