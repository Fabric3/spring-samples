package org.fabric3.samples.hibernate;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;

/**
 * @version $Rev$ $Date$
 */
public class HibernateClient {
    private static final String BASE_URI = "http://localhost:8181/messages";

    public static void main(String[] args) {
        Message message = new Message();
        message.setText("Test message " + System.currentTimeMillis());

        ClientConfig cc = new DefaultClientConfig();
        cc.getClasses().add(JacksonJaxbJsonProvider.class);
        Client client = Client.create(cc);
        UriBuilder uri = UriBuilder.fromUri(BASE_URI);
        WebResource resource = client.resource(uri.path("message").build());

        System.out.println("Creating message");
        ClientResponse r = resource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, message);
        String location = r.getHeaders().get("location").get(0);
        resource = client.resource(location);
        Message response = resource.type(MediaType.APPLICATION_JSON).get(Message.class);

        System.out.println("Response test was: " + response.getText());
        WebResource messagesResource = client.resource(BASE_URI);
        MessageList messages = messagesResource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).get(MessageList.class);
        for (Message entry : messages.getMessages()) {
            System.out.println("The message text for id " + entry.getId() + " is: " + entry.getText());
        }

        // resource.delete();
    }
}
