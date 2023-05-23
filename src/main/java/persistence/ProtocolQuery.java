package persistence;

import java.io.Serializable;

public enum ProtocolQuery implements Serializable {
    insert,
    selectAll,
    selectOrderByMonth,
    selectOrderByDongName,
    selectOrderByIndustryCode,
    selectOrderByAmount,
    selectOrderByDFP,
    response
}
