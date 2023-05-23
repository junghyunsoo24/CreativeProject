package persistence.DAO;

import persistence.DTO.ConsumptionAmountForeignerDTO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import persistence.DTO.DTO;

import java.util.List;

public class ConsumptionAmountForeignerDAO extends DAO<DTO> {
    public ConsumptionAmountForeignerDAO(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }

    @Override
    public List<DTO> selectAll() {
        return select("mapper.CAFMapper.selectAll");
    }

    @Override
    public List<DTO> selectOrderByMonth() {
        return select("mapper.CAFMapper.selectOrderByMonth");
    }

    @Override
    public List<DTO> selectOrderByDongName() {
        return select("mapper.CAFMapper.selectOrderByDongName");
    }

    public List<DTO> selectOrderByIndustryCode() {
        return select("mapper.CAFMapper.selectOrderByIndustryCode");
    }

    public List<DTO> selectOrderByAmount() {
        return select("mapper.CAFMapper.selectOrderByAmount");
    }

    @Override
    public void insertAll(List<DTO> list) {
        insert("mapper.CAFMapper.insert", list);
    }

    @Override
    public void insertOne(DTO element) {
        insert("mapper.CAFMapper.insert", element);
    }
}
