package persistence;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class Protocol<T> implements Serializable {
    private final ProtocolQuery QUERY;
    private final ProtocolType TYPE;
    private final T DATA;

    public Protocol(ProtocolQuery q, ProtocolType t, T d) {
        QUERY = q;
        TYPE = t;
        DATA = d;
    }
}
