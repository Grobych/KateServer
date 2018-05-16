package server;

import java.util.Random;

public class PromoCode {
    private final long id;
    private final int code;

    public long getId() {
        return id;
    }

    public int getCode() {
        return code;
    }

    public PromoCode(long id, int code){
        this.id = id;
        this.code = code;
    }
}
