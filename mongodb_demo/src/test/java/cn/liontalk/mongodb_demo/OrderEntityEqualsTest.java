package cn.liontalk.mongodb_demo;

public class OrderEntityEqualsTest {

    private String name;

    private String id;


    public OrderEntityEqualsTest(String name, String id) {
        this.name = name;
        this.id = id;
    }


    public boolean equals(Object o) {
        OrderEntityEqualsTest obj = (OrderEntityEqualsTest) o;
        return this.name.equals(obj.name) && this.id.equals(obj.id);
    }

    public int hashCode(Object o){
        return 0;
    }

    public static void main(String[] args) {

        OrderEntityEqualsTest a = new OrderEntityEqualsTest("1", "2");
        OrderEntityEqualsTest b = new OrderEntityEqualsTest("1", "2");
        System.out.println(a.equals(b));
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
    }


}
