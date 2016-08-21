package resourceServer;

import resources.TestResource;

public interface ResourceServerI {

    TestResource getTestResource();

    void setTestResource(TestResource resource);
}
