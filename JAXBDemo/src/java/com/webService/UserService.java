/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webService;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.netbeans.xml.schema.user.Birthday;
import org.netbeans.xml.schema.user.Name;
import org.netbeans.xml.schema.user.UserInfo;
import org.netbeans.xml.schema.user.UserList;

/**
 *
 * @author birui
 */
@WebService(serviceName = "UserService")
public class UserService {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Login")
    public UserInfo Login(@WebParam(name = "username") String username, @WebParam(name = "password") String password) {
        //TODO write your implementation code here:
        UserList userList = null;
        List<UserInfo> list = new ArrayList<UserInfo>();
        UserInfo userInfo = null;
        try {
            JAXBContext jaxbc = JAXBContext.newInstance("org.netbeans.xml.schema.user");
            Unmarshaller unmarshaller = jaxbc.createUnmarshaller();
            userList = (UserList) ((JAXBElement) unmarshaller.unmarshal(new File("UserList.xml"))).getValue();

            list = userList.getUserInfo();
            for (int i = 0; i < list.size(); i++) {
                UserInfo user = list.get(i);
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    userInfo = user;
                    return userInfo;
                }
            }

        } catch (JAXBException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return userInfo;
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Register")
    public Boolean Register(@WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "birth_year") String year, @WebParam(name = "birth_month") String month, @WebParam(name = "email") String email, @WebParam(name = "first_name") String first_name, @WebParam(name = "last_name") String last_name) {
        //TODO write your implementation code here:
        UserList newList = new UserList();
        UserInfo newUser = new UserInfo();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setEmail(email);
        Birthday birthday = new Birthday();
        birthday.setBirthYear(year);
        birthday.setBirthMonth(month);
        newUser.setBirth(birthday);
        Name name = new Name();
        name.setFirstName(first_name);
        name.setLastName(last_name);
        newUser.setName(name);  
        try {
            JAXBContext jaxbc = JAXBContext.newInstance("org.netbeans.xml.schema.user");
            Unmarshaller unmarshaller = jaxbc.createUnmarshaller();
            newList = (UserList) ((JAXBElement) unmarshaller.unmarshal(new File("UserList.xml"))).getValue();
            newList.addUserInfo(newUser);
            Marshaller marshaller = jaxbc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
            marshaller.marshal(newList,new File("UserList.xml"));
            marshaller.marshal(newList,System.out);
            return true;
        } catch (JAXBException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    /**
     * This is a sample web service operation
     */
}
