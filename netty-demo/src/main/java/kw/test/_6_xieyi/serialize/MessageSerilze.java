package kw.test._6_xieyi.serialize;

import org.jboss.marshalling.ByteInputStream;
import org.jboss.marshalling.ByteOutputStream;

import java.io.*;

public enum MessageSerilze {
    java{
        @Override
        public <T> T decoder(byte[] bytes) {
            Object oo = null;
            try(ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
                ObjectInputStream ois = new ObjectInputStream(inputStream);
            ) {
                oo = ois.readObject();
            }catch (Exception e){
                e.printStackTrace();
            }
            return (T)oo;
        }

        @Override
        public byte[] encoder(Object msg) {
            super.encoder(msg);
            byte[] b = null;
            try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                 ObjectOutputStream outputStream = new ObjectOutputStream(byteArrayOutputStream);
            ){
                outputStream.writeObject(msg);
                b = byteArrayOutputStream.toByteArray();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return b;
        }
    };

    public <T> T decoder(byte[] bytes){
        return null;
    }

    public byte[] encoder(Object msg){
        return null;
    }
}
