package org.fabric3.samples.hibernate;

import java.util.Collections;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @version $Rev$ $Date$
 */
@XmlRootElement
public class MessageList {
    private List<Message> messages = Collections.emptyList();

    public MessageList() {
    }

    public MessageList(List<Message> messages) {
        this.messages = messages;
    }

    @XmlElementWrapper(name = "messages")
    @XmlElement(name = "message")
    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
