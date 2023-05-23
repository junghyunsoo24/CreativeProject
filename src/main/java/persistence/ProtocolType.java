package persistence;

import java.io.Serializable;

public enum ProtocolType implements Serializable {
    insert,
    CA,
    CAF,
    CAO,
    DFP,
    response
}
