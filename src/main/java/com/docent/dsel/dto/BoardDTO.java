package com.docent.dsel.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {

    private Long bno;
    private String title;
    private String image;
    private String classify;
    private String location;
    private String introduce;
    private String audio;


    private LocalDateTime updatedate;
}
