package hello.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter // lombok은 getter, setter를 만들지 않아도 사용가능
@Setter // 다른 기능도 많다.
@ToString
public class HelloLombok {

    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("Adfdsfsfa");
        
        String name = helloLombok.getName();
        System.out.println("name = " + name);
        System.out.println("helloLombok = " + helloLombok);
    }
}
