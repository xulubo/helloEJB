package ca.loobo.learn.ejb.session;

import javax.ejb.Remote;

@Remote
public interface HelloWorld {
    String sayHello(String name);
}
