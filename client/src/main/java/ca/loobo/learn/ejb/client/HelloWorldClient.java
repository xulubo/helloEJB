package ca.loobo.learn.ejb.client;

import java.util.Properties;

import javax.naming.CommunicationException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ca.loobo.learn.ejb.session.HelloWorld;

public class HelloWorldClient {
    public static void main(String[] args) {
        try {
            final Context context = getInitialContext();
            HelloWorld helloWorldSession =
                (HelloWorld)context.lookup("SessionEJB-Project1-HelloWorldSession#ca.loobo.learn.ejb.session.HelloWorld");
            System.out.println(helloWorldSession.sayHello( "world" ));
        } catch (CommunicationException ex) {
            System.out.println(ex.getClass().getName());
            System.out.println(ex.getRootCause().getLocalizedMessage());
            System.out.println("\n*** A CommunicationException was raised.  This typically\n*** occurs when the target WebLogic server is not running.\n");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static Context getInitialContext() throws NamingException {
    	Properties properties = new Properties();
        // WebLogic Server 10.x connection details
        properties.setProperty(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory" );
        properties.setProperty(Context.PROVIDER_URL, "t3://127.0.0.1:7001");
        return new InitialContext( properties );
    }
}
