package com.example.Librarymanagementsystemapplication.dto.responseDto;

import com.example.Librarymanagementsystemapplication.enums.CardStatus;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CardResponseDto {

    private int id;
    private Date issueDate;
    private Date updateOn;
    private CardStatus cardStatus;
    private String validTill;

}
