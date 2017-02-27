package net.punklan.glorfindeil.study.lesson2;

import java.util.Date;

/**
 * Created by Aleksandr_Kichev on 27-Feb-17.
 */
public class UserPOJO {
    public UserPOJO() {
    }

    private String firstName;
    private String secondName;
    private Date birthDay;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        if (birthDay.after(new Date())) {
            throw new IllegalArgumentException("User is not born yet");
        }
        this.birthDay = birthDay;
    }

}
