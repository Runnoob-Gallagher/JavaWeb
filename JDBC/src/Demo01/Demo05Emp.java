package Demo01;

public class Demo05Emp {
    private int id;
    private String name;
    private int age;
    private String dep_name;
    private String dep_location;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDep_name(String dep_name) {
        this.dep_name = dep_name;
    }

    public void setDep_location(String dep_location) {
        this.dep_location = dep_location;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDep_name() {
        return dep_name;
    }

    public String getDep_location() {
        return dep_location;
    }

    @Override
    public String toString() {
        return "Demo05Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", dep_name='" + dep_name + '\'' +
                ", dep_location='" + dep_location + '\'' +
                '}';
    }
}
