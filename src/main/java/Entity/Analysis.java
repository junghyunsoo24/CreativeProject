package Entity;

import org.example.Main;
import persistence.DTO.DTO;
import persistence.Protocol.ProtocolQuery;
import persistence.Protocol.ProtocolType;

import java.io.IOException;
import java.util.List;

public class Analysis {
    public List<DTO> select(ProtocolQuery query, ProtocolType type) throws IOException, ClassNotFoundException {
        return Main.getDB().selectRequest(query, type);
    }
}
