package backend.Server;

import com.opencsv.exceptions.CsvException;
import backend.DB.DAO.*;
import backend.DB.DTO.AdminDTO;
import backend.DB.DTO.DTO;
import backend.DB.MyBatisConnectionFactory;
import backend.DB.Protocol.Protocol;
import backend.DB.Protocol.ProtocolType;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ServerControl {
    private final ConsumptionAmountDAO CADAO;
    private final ConsumptionAmountForeignerDAO CAFDAO;
    private final ConsumptionAmountOutsiderDAO CAODAO;
    private final DailyFloatingPopulationDAO DFPDAO;
    private final AdminDAO adminDAO;

    public ServerControl() {
        CADAO = new ConsumptionAmountDAO(MyBatisConnectionFactory.getSqlSessionFactory());
        CAFDAO = new ConsumptionAmountForeignerDAO(MyBatisConnectionFactory.getSqlSessionFactory());
        CAODAO = new ConsumptionAmountOutsiderDAO(MyBatisConnectionFactory.getSqlSessionFactory());
        DFPDAO = new DailyFloatingPopulationDAO(MyBatisConnectionFactory.getSqlSessionFactory());
        adminDAO = new AdminDAO(MyBatisConnectionFactory.getSqlSessionFactory());
    }

    public void DBUpdateRequest(File csv) throws IOException, CsvException, InvalidNameFormatException {
        List<DTO> list;
        final String FILE_NAME = csv.getName();

        if (FILE_NAME.contains("유성구_법정동별 소비금액 데이터")) {
            list = new DTOListBuilder(csv).CAListBuild();
            CADAO.insertAll(list);
        } else if (FILE_NAME.contains("유성구_외국인소비정보")) {
            list = new DTOListBuilder(csv).CAFListBuild();
            CAFDAO.insertAll(list);
        } else if (FILE_NAME.contains("유성구_법정동별 외지인(내국인) 소비 금액 데이터")) {
            list = new DTOListBuilder(csv).CAOListBuild();
            CAODAO.insertAll(list);
        } else if (FILE_NAME.contains("법정동별 일평균 유동인구 데이터")) {
            list = new DTOListBuilder(csv).DFPListBuild();
            DFPDAO.insertAll(list);
        } else {
            throw new InvalidNameFormatException("[치명적 오류] 파일 이름 형식이 잘못되었습니다.");
        }
    }

    public List<DTO> selectAllRequest(Protocol<?> protocol) {
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

    public List<DTO> selectOrderByMonthRequest(Protocol<?> protocol) {
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

    public List<DTO> selectOrderByDongNameRequest(Protocol<?> protocol) {
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

    public List<DTO> selectOrderByIndustryCodeRequest(Protocol<?> protocol) {
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

    public List<DTO> selectOrderByAmountRequest(Protocol<?> protocol) {
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

    public Long selectSumRequest(Protocol<?> protocol) {
        Long sum = null;

        if (protocol.getTYPE() == ProtocolType.CA) {
            sum = CADAO.selectSum((String) protocol.getDATA());
        } else if (protocol.getTYPE() == ProtocolType.CAF) {
            sum = CAFDAO.selectSum((String) protocol.getDATA());
        } else if (protocol.getTYPE() == ProtocolType.CAO) {
            sum = CAODAO.selectSum((String) protocol.getDATA());
        }

        return sum;
    }

    public Boolean findByIdAndPassword(AdminDTO target) {
        return adminDAO.findByIdAndPassword(target);
    }
}
