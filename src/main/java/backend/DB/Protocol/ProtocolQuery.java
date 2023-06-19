package backend.DB.Protocol;

import java.io.Serializable;

public enum ProtocolQuery implements Serializable {
    insert,
    selectAll,
    selectOrderByMonth,
    selectOrderByDongName,
    selectOrderByIndustryCode,
    selectOrderByAmount,
    selectOrderByDFP,
    selectSum,
    findByIdAndPassword,
    response
}
