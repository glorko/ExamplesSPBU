package net.punklan.glorfindeil.study.lesson2;

import java.util.Date;

/**
 * Created by Aleksandr_Kichev on 27-Feb-17.
 */
public class UserDTO {
    private String firstName;
    private String secondName;
    private Date birthDay;

    public UserDTO(String firstName, String secondName, Date birthDay) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.birthDay = birthDay;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public Date getBirthDay() {
        return birthDay;
    }
}
