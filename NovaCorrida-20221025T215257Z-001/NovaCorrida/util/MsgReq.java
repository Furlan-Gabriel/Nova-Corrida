package util;

import java.io.Serializable;

public class MsgReq implements Serializable {
    private double aposta;
    private String cavalo;

    public MsgReq(double aposta, String cavalo) {
        this.aposta = aposta;
        this.cavalo = cavalo;
    }

    public String getCavalo() {
        return cavalo;
    }

    public double getAposta() {
        return aposta;
    }
}
