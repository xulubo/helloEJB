package ca.loobo.learn.ejb.session;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless(name = "HelloWorldSession", mappedName = "SessionEJB-Project1-HelloWorldSession")
public class HelloWorldBean implements HelloWorld {
    @Resource
    SessionContext sessionContext;

    public String sayHello (String name) {
       return "Hello " + name;
    } 
}
