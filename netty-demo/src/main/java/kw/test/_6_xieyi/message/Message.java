package kw.test._6_xieyi.message;

import kw.test._6_xieyi.header.Header;

import java.io.Serializable;

public class Message implements Serializable {
    private Header header;
    private MessageBody body;

    public void setHeader(Header header) {
        this.header = header;
    }

    public Header getHeader() {
        return header;
    }

    public void setBody(MessageBody body) {
        this.body = body;
    }

    public MessageBody getBody() {
        return body;
    }
}
