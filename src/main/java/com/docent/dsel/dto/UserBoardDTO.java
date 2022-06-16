package com.docent.dsel.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserBoardDTO {

    private Long ubno;

    @NotEmpty
    private String did;
    @NotEmpty
    @Size(min = 3, max = 100)
    private String title;
    @NotEmpty
    private String nickName;
    @NotEmpty
    private String content;

    private LocalDateTime regDate;

    private LocalDateTime updateDate;


}
