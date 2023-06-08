package persistence.Protocol;

import java.io.Serializable;

public enum ProtocolQuery implements Serializable {
    insert,
    selectAll,
    selectOrderByMonth,
    selectOrderByDongName,
    selectOrderByIndustryCode,
    selectOrderByAmount,
    selectOrderByDFP,
    findByIdAndPassword,
    response
}
