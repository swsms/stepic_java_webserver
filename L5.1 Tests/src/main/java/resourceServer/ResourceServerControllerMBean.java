package resourceServer;

@SuppressWarnings("UnusedDeclaration")
public interface ResourceServerControllerMBean {

    String getName();

    void setName(String name);

    int getAge();

    void setAge(int age);
}