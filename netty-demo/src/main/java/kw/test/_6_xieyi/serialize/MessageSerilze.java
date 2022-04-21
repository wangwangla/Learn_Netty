package kw.test._6_xieyi.serialize;

public enum MessageSerilze {
    java{
        @Override
        public <T> T decoder(byte[] bytes, Class<T> c) {
            return super.decoder(bytes, c);
        }

        @Override
        public byte[] encoder(Object msg) {
            super.encoder(msg);
            return null;
        }
    };

    public <T> T decoder(byte[] bytes,Class<T> c){
        return null;
    }

    public byte[] encoder(Object msg){
        return null;
    }
}
