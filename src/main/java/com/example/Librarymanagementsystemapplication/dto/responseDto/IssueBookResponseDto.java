package com.example.Librarymanagementsystemapplication.dto.responseDto;

import com.example.Librarymanagementsystemapplication.enums.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class IssueBookResponseDto {

    private String transacrionNumber;
    private TransactionStatus transactionStatus;
    private String bookName;
}
