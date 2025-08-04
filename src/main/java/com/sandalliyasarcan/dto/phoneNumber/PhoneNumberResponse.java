package com.sandalliyasarcan.dto.phoneNumber;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhoneNumberResponse { //Bu class Update islemi icin response class olarak kullanilcak // Update islemi sonrasi tum customer i ve customer a ait tum telefon numaralarini gostermeye gerek yok die dusunuyorum
    private Long phoneId; //DB deki id , su numarali telefon numarasi guncellenmistir diyebilmek icin
    private String phoneType; //Mobile Work Home vs.
    private String phoneNumber; //05 .... gibi
    private String customerFullName;
}
