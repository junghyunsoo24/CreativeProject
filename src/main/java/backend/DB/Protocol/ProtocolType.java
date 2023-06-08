package backend.DB.Protocol;

import java.io.Serializable;

public enum ProtocolType implements Serializable {
    insert,
    CA,
    CAF,
    CAO,
    DFP,
    admin,
    response
}
