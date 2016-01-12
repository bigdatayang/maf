
package com.allinfnt._2014._08.atomic.oa.userinfo.types;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.3-hudson-390-
 * Generated source version: 2.0
 * 
 */
@WebService(name = "userinfo", targetNamespace = "http://www.allinfnt.com/2014/08/atomic/oa/userInfo/types")
public interface Userinfo {


    /**
     * 
     * @param userNo
     * @return
     *     returns com.allinfnt._2014._08.atomic.oa.userinfo.types.User
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getUserInfoByNo", targetNamespace = "http://www.allinfnt.com/2014/08/atomic/oa/userInfo/types", className = "com.allinfnt._2014._08.atomic.oa.userinfo.types.GetUserInfoByNo")
    @ResponseWrapper(localName = "getUserInfoByNoResponse", targetNamespace = "http://www.allinfnt.com/2014/08/atomic/oa/userInfo/types", className = "com.allinfnt._2014._08.atomic.oa.userinfo.types.GetUserInfoByNoResponse")
    public User getUserInfoByNo(
        @WebParam(name = "userNo", targetNamespace = "")
        String userNo);

    /**
     * 
     * @param userName
     * @return
     *     returns com.allinfnt._2014._08.atomic.oa.userinfo.types.User
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getUserInfoByName", targetNamespace = "http://www.allinfnt.com/2014/08/atomic/oa/userInfo/types", className = "com.allinfnt._2014._08.atomic.oa.userinfo.types.GetUserInfoByName")
    @ResponseWrapper(localName = "getUserInfoByNameResponse", targetNamespace = "http://www.allinfnt.com/2014/08/atomic/oa/userInfo/types", className = "com.allinfnt._2014._08.atomic.oa.userinfo.types.GetUserInfoByNameResponse")
    public User getUserInfoByName(
        @WebParam(name = "userName", targetNamespace = "")
        String userName);

    /**
     * 
     * @return
     *     returns java.util.List<com.allinfnt._2014._08.atomic.oa.userinfo.types.User>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getBirthDayUserList", targetNamespace = "http://www.allinfnt.com/2014/08/atomic/oa/userInfo/types", className = "com.allinfnt._2014._08.atomic.oa.userinfo.types.GetBirthDayUserList")
    @ResponseWrapper(localName = "getBirthDayUserListResponse", targetNamespace = "http://www.allinfnt.com/2014/08/atomic/oa/userInfo/types", className = "com.allinfnt._2014._08.atomic.oa.userinfo.types.GetBirthDayUserListResponse")
    public List<User> getBirthDayUserList();

    /**
     * 
     * @return
     *     returns java.util.List<com.allinfnt._2014._08.atomic.oa.userinfo.types.User>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getNewUserList", targetNamespace = "http://www.allinfnt.com/2014/08/atomic/oa/userInfo/types", className = "com.allinfnt._2014._08.atomic.oa.userinfo.types.GetNewUserList")
    @ResponseWrapper(localName = "getNewUserListResponse", targetNamespace = "http://www.allinfnt.com/2014/08/atomic/oa/userInfo/types", className = "com.allinfnt._2014._08.atomic.oa.userinfo.types.GetNewUserListResponse")
    public List<User> getNewUserList();

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<com.allinfnt._2014._08.atomic.oa.userinfo.types.User>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getUserList", targetNamespace = "http://www.allinfnt.com/2014/08/atomic/oa/userInfo/types", className = "com.allinfnt._2014._08.atomic.oa.userinfo.types.GetUserList")
    @ResponseWrapper(localName = "getUserListResponse", targetNamespace = "http://www.allinfnt.com/2014/08/atomic/oa/userInfo/types", className = "com.allinfnt._2014._08.atomic.oa.userinfo.types.GetUserListResponse")
    public List<User> getUserList(
        @WebParam(name = "arg0", targetNamespace = "")
        UserSearch arg0);

}
