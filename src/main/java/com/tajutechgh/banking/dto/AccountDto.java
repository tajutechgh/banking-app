package com.tajutechgh.banking.dto;

//import lombok.AllArgsConstructor;
//import lombok.Data;
//
//@Data
//@AllArgsConstructor
//public class AccountDto {
//    private Long id;
//    private String accountHolderName;
//    private double accountBalance;
//}

public record AccountDto(Long id, String accountHolderName, double accountBalance) {


}
