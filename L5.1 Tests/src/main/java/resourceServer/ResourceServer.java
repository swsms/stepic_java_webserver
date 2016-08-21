package resourceServer;

import resources.TestResource;

public class ResourceServer implements ResourceServerI {
    private TestResource resource;

    public ResourceServer() {

    }

    public ResourceServer(TestResource resource) {
        this.resource = resource;
    }

    @Override
    public TestResource getTestResource() {
        return resource;
    }

    @Override
    public void setTestResource(TestResource resource) {
        this.resource = resource;
    }
}
