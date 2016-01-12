
package com.allinfnt._2014._08.atomic.oa.userinfo.types;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.3-hudson-390-
 * Generated source version: 2.0
* <p>
* An example of how this class may be used:
* <pre>
* UserInfoControllerService service = new UserInfoControllerService();
* Userinfo portType = service.getUserinfoPort();
* portType.getUserInfoByNo(...);
* </pre>
* </p>
 * 
 */
@WebServiceClient(name = "UserInfoControllerService", targetNamespace = "http://www.allinfnt.com/2014/08/atomic/oa/userInfo/types", wsdlLocation = "http://10.252.102.81:8080/oa/ws/api/userinfo?wsdl")
public class UserInfoControllerService
    extends Service
{

    private final static URL USERINFOCONTROLLERSERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(com.allinfnt._2014._08.atomic.oa.userinfo.types.UserInfoControllerService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = com.allinfnt._2014._08.atomic.oa.userinfo.types.UserInfoControllerService.class.getResource(".");
            url = new URL(baseUrl, "http://10.252.102.81:8080/oa/ws/api/userinfo?wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://10.252.102.81:8080/oa/ws/api/userinfo?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        USERINFOCONTROLLERSERVICE_WSDL_LOCATION = url;
    }

    public UserInfoControllerService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public UserInfoControllerService() {
        super(USERINFOCONTROLLERSERVICE_WSDL_LOCATION, new QName("http://www.allinfnt.com/2014/08/atomic/oa/userInfo/types", "UserInfoControllerService"));
    }

    /**
     * 
     * @return
     *     returns Userinfo
     */
    @WebEndpoint(name = "userinfoPort")
    public Userinfo getUserinfoPort() {
        return super.getPort(new QName("http://www.allinfnt.com/2014/08/atomic/oa/userInfo/types", "userinfoPort"), Userinfo.class);
    }

}
