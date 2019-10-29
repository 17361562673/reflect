/**
 * Company: ALIBABA
 * Author： ZHOUZHIQIANG
 * FileName:Person
 * Time:2019/10/2914:55
 * Description:
 */
package reflect;

public class Person {
    private Integer id;
    private String name;
    private Integer age;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    private static void print(){
        System.out.println("静态方法被调用");
    }
}
