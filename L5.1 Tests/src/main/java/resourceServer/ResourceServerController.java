package resourceServer;

/**
 * Created by Артем on 21.08.2016.
 */
public class ResourceServerController implements ResourceServerControllerMBean {
    private final ResourceServerI resourceServer;

    public ResourceServerController(ResourceServerI resourceServer) {
        this.resourceServer = resourceServer;
    }

    @Override
    public String getName() {
        return resourceServer.getTestResource().getName();
    }

    @Override
    public void setName(String name) {
        resourceServer.getTestResource().setName(name);
    }

    @Override
    public int getAge() {
        return resourceServer.getTestResource().getAge();
    }

    @Override
    public void setAge(int age) {
        resourceServer.getTestResource().setAge(age);
    }
}
