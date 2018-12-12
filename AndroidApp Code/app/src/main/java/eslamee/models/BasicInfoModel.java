package eslamee.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

/**
 * Created by Manjeet Singh on 7/26/2018.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BasicInfoModel {

    private String name;
    private String mothers_name;
    private String fathers_name;
    private String sun_sign;
    private String hobbies;
    private String aim_in_life;
    private String motto;
    private String pic;
    private String describe_urslf;
    private int contact;
    private Date dob;
    private String mail_id;
    private String user_id;
    private FunInfoModel fun_info;
    private AddressInfoModel address;

    public String getMothers_name() {
        return mothers_name;
    }

    public void setMothers_name(String mothers_name) {
        this.mothers_name = mothers_name;
    }

    public String getFathers_name() {
        return fathers_name;
    }

    public void setFathers_name(String fathers_name) {
        this.fathers_name = fathers_name;
    }

    public String getSun_sign() {
        return sun_sign;
    }

    public void setSun_sign(String sun_sign) {
        this.sun_sign = sun_sign;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public String getAim_in_life() {
        return aim_in_life;
    }

    public void setAim_in_life(String aim_in_life) {
        this.aim_in_life = aim_in_life;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDescribe_urslf() {
        return describe_urslf;
    }

    public void setDescribe_urslf(String describe_urslf) {
        this.describe_urslf = describe_urslf;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public AddressInfoModel getAddress() {
        return address;
    }

    public void setAddress(AddressInfoModel address) {
        this.address = address;
    }

    public FunInfoModel getFun_info() {
        return fun_info;
    }

    public void setFun_info(FunInfoModel fun_info) {
        this.fun_info = fun_info;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getMail_id() {
        return mail_id;
    }

    public void setMail_id(String mail_id) {
        this.mail_id = mail_id;
    }
//private String movie;
    // after this, generate after right click// shift + neeche neeeche vale.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
