package persistence.DAO;

import persistence.DTO.ConsumptionAmountForeignerDTO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class ConsumptionAmountForeignerDAO extends DAO<ConsumptionAmountForeignerDTO> {
    public ConsumptionAmountForeignerDAO(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }

    @Override
    public List<ConsumptionAmountForeignerDTO> selectAll() {
        return select("mapper.CAFMapper.selectAll");
    }

    @Override
    public List<ConsumptionAmountForeignerDTO> selectOrderByMonth() {
        return select("mapper.CAFMapper.selectOrderByMonth");
    }

    @Override
    public List<ConsumptionAmountForeignerDTO> selectOrderByDongName() {
        return select("mapper.CAFMapper.selectOrderByDongName");
    }

    public List<ConsumptionAmountForeignerDTO> selectOrderByIndustryCode() {
        return select("mapper.CAFMapper.selectOrderByIndustryCode");
    }

    public List<ConsumptionAmountForeignerDTO> selectOrderByAmount() {
        return select("mapper.CAFMapper.selectOrderByAmount");
    }

    @Override
    public void insertAll(List<ConsumptionAmountForeignerDTO> list) {
        insert("mapper.CAFMapper.insert", list);
    }

    @Override
    public void insertOne(ConsumptionAmountForeignerDTO element) {
        insert("mapper.CAFMapper.insert", element);
    }
}
