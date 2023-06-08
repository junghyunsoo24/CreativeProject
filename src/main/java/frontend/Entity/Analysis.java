package frontend.Entity;

import frontend.ClientApp;
import backend.DB.DTO.DTO;
import backend.DB.Protocol.ProtocolQuery;
import backend.DB.Protocol.ProtocolType;

import java.io.IOException;
import java.util.List;

public class Analysis {
    public List<DTO> select(ProtocolQuery query, ProtocolType type) throws IOException, ClassNotFoundException {
        return ClientApp.getDB().selectRequest(query, type);
    }
}
