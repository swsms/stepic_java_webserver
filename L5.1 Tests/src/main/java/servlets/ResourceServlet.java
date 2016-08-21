package servlets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import resourceServer.ResourceServerI;
import resources.TestResource;
import sax.ReadXMLFileSAX;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResourceServlet extends HttpServlet {
    static final Logger logger = LogManager.getLogger(ResourceServlet.class.getName());
    public static final String PAGE_URL = "/resources";
    private final ResourceServerI resourceServer;

    private static final String path = "path";

    public ResourceServlet(ResourceServerI resourceServer) {
        this.resourceServer = resourceServer;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathToFile = req.getParameter(path);

        if (!isEmptyOrNullString(pathToFile)) {
            TestResource resource = (TestResource) ReadXMLFileSAX.readXML(pathToFile);
            if (resource != null) {
                logger.info("Resource has been created. Info: {}", resource);
                resourceServer.setTestResource(resource);

                resp.setStatus(HttpServletResponse.SC_OK);
                return;
            }
        }
        resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    }

    private boolean isEmptyOrNullString(String string) {
        return (string == null) || (string.equalsIgnoreCase(""));
    }
}
