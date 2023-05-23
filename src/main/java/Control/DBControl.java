package Control;

import Entity.Data;
import com.opencsv.exceptions.CsvException;
import persistence.DAO.ConsumptionAmountDAO;
import persistence.DAO.ConsumptionAmountForeignerDAO;
import persistence.DAO.ConsumptionAmountOutsiderDAO;
import persistence.DAO.DailyFloatingPopulationDAO;
import persistence.DTO.DTO;
import persistence.InvalidNameFormatException;
import persistence.MyBatisConnectionFactory;
import persistence.Protocol;
import persistence.ProtocolType;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class DBControl {
    private final ConsumptionAmountDAO CADAO;
    private final ConsumptionAmountForeignerDAO CAFDAO;
    private final ConsumptionAmountOutsiderDAO CAODAO;
    private final DailyFloatingPopulationDAO DFPDAO;

    public DBControl() {
        CADAO = new ConsumptionAmountDAO(MyBatisConnectionFactory.getSqlSessionFactory());
        CAFDAO = new ConsumptionAmountForeignerDAO(MyBatisConnectionFactory.getSqlSessionFactory());
        CAODAO = new ConsumptionAmountOutsiderDAO(MyBatisConnectionFactory.getSqlSessionFactory());
        DFPDAO = new DailyFloatingPopulationDAO(MyBatisConnectionFactory.getSqlSessionFactory());
    }

    public void DBUpdateRequest(File csv) throws IOException, CsvException, InvalidNameFormatException {
        Data data = new Data(csv);
        data.DBUpdate();
    }

    public List<DTO> selectAllRequest(Protocol<File> protocol) {
        List<DTO> result = null;

        if (protocol.getTYPE() == ProtocolType.CA) {
            result = CADAO.selectAll();
        } else if (protocol.getTYPE() == ProtocolType.CAF) {
            result = CAFDAO.selectAll();
        } else if (protocol.getTYPE() == ProtocolType.CAO) {
            result = CAODAO.selectAll();
        } else if (protocol.getTYPE() == ProtocolType.DFP) {
            result = DFPDAO.selectAll();
        }

        return result;
    }

    public List<DTO> selectOrderByMonthRequest(Protocol<File> protocol) {
        List<DTO> result = null;

        if (protocol.getTYPE() == ProtocolType.CA) {
            result = CADAO.selectOrderByMonth();
        } else if (protocol.getTYPE() == ProtocolType.CAF) {
            result = CAFDAO.selectOrderByMonth();
        } else if (protocol.getTYPE() == ProtocolType.CAO) {
            result = CAODAO.selectOrderByMonth();
        } else if (protocol.getTYPE() == ProtocolType.DFP) {
            result = DFPDAO.selectOrderByMonth();
        }

        return result;
    }

    public List<DTO> selectOrderByDongNameRequest(Protocol<File> protocol) {
        List<DTO> result = null;

        if (protocol.getTYPE() == ProtocolType.CA) {
            result = CADAO.selectOrderByDongName();
        } else if (protocol.getTYPE() == ProtocolType.CAF) {
            result = CAFDAO.selectOrderByDongName();
        } else if (protocol.getTYPE() == ProtocolType.CAO) {
            result = CAODAO.selectOrderByDongName();
        } else if (protocol.getTYPE() == ProtocolType.DFP) {
            result = DFPDAO.selectOrderByDongName();
        }

        return result;
    }

    public List<DTO> selectOrderByIndustryCodeRequest(Protocol<File> protocol) {
        List<DTO> result = null;

        if (protocol.getTYPE() == ProtocolType.CA) {
            result = CADAO.selectOrderByIndustryCode();
        } else if (protocol.getTYPE() == ProtocolType.CAF) {
            result = CAFDAO.selectOrderByIndustryCode();
        } else if (protocol.getTYPE() == ProtocolType.CAO) {
            result = CAODAO.selectOrderByIndustryCode();
        }

        return result;
    }

    public List<DTO> selectOrderByAmountRequest(Protocol<File> protocol) {
        List<DTO> result = null;

        if (protocol.getTYPE() == ProtocolType.CA) {
            result = CADAO.selectOrderByAmount();
        } else if (protocol.getTYPE() == ProtocolType.CAF) {
            result = CAFDAO.selectOrderByAmount();
        } else if (protocol.getTYPE() == ProtocolType.CAO) {
            result = CAODAO.selectOrderByAmount();
        }

        return result;
    }

    public List<DTO> selectOrderByDFPRequest() {
        return DFPDAO.selectOrderByDFP();
    }
}
