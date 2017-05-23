package com.zzptc.fox.expresscheck.beans;

/**
 *
 * @auther : wanderders
 * @date : 2016/8/7
 * @instructions :
 *
 */
public class GuideMessage {
    private int id;
    private String name;
    private int pic;
    private String phone;

    public GuideMessage(String name, int pic,String phone) {
        super();
        this.name= name;
        this.pic= pic;
        this.phone = phone;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
