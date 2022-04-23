package kw.test._6_xieyi.header;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public final class Header implements Serializable {
    private int crcCode = 0x00002;//魔数
    private int length;//message length
    private long sessionId;//通话session
    private byte type;//标识消息的类型
    private byte priority;
    private Map<String,Object> attachment = new HashMap<>();

    public final void setCrcCode(int crcCode) {
        this.crcCode = crcCode;
    }

    public final int getCrcCode() {
        return crcCode;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public long getSessionId() {
        return sessionId;
    }

    public void setSessionId(long sessionId) {
        this.sessionId = sessionId;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public byte getPriority() {
        return priority;
    }

    public void setPriority(byte priority) {
        this.priority = priority;
    }

    public Map<String, Object> getAttachment() {
        return attachment;
    }

    public void setAttachment(Map<String, Object> attachment) {
        this.attachment = attachment;
    }

    @Override
    public String toString() {
        return "Header{" +
                "crcCode=" + crcCode +
                ", length=" + length +
                ", sessionId=" + sessionId +
                ", type=" + type +
                ", priority=" + priority +
                ", attachment=" + attachment +
                '}';
    }
}
