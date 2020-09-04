package EL;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ELObject {
    private String name;
    private int age;
    private Date birthday;

    public String getDsf(){
        if(birthday != null){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年mm月dd日");
            return sdf.format(birthday);
        }else{
            return "";
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
