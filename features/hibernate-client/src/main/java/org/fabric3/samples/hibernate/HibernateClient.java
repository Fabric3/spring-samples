/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.fabric3.samples.hibernate;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import org.glassfish.jersey.client.filter.HttpBasicAuthFilter;

/**
 *
 */
public class HibernateClient {
    private static final String BASE_URI = "http://localhost:8181/messages";

    public static void main(String[] args) {
        Message message = new Message();
        message.setText("Test message " + System.currentTimeMillis());

        Client client = ClientBuilder.newClient();
        client.register(JacksonJaxbJsonProvider.class);

        // set basic auth filter
        HttpBasicAuthFilter filter = new HttpBasicAuthFilter("foo", "bar");
        client.register(filter);

        UriBuilder uri = UriBuilder.fromUri(BASE_URI);
        WebTarget target = client.target(uri.path("message").build());

        System.out.println("Creating message");
        Response r = target.request(MediaType.APPLICATION_JSON).post(Entity.entity(message, MediaType.APPLICATION_JSON));
        String location = (String) r.getHeaders().get("location").get(0);

        target = client.target(BASE_URI + "/message/" + location);

        Message response = target.request(MediaType.APPLICATION_JSON).get(Message.class);

        WebTarget messagesResource = client.target(BASE_URI);
        MessageList messages = messagesResource.request(MediaType.APPLICATION_JSON).get(MessageList.class);
        for (Message entry : messages.getMessages()) {
            System.out.println("The message text for id " + entry.getId() + " is: " + entry.getText());
        }

        // resource.delete();
    }
}
