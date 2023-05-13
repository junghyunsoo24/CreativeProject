package persistence.DAO;

import persistence.DTO.ConsumptionAmountDTO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class ConsumptionAmountDAO extends DAO<ConsumptionAmountDTO>{
    public ConsumptionAmountDAO(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }

    @Override
    public List<ConsumptionAmountDTO> selectAll() {
        return select("mapper.CAMapper.selectAll");
    }

    @Override
    public List<ConsumptionAmountDTO> selectOrderByMonth() {
        return select("mapper.CAMapper.selectOrderByMonth");
    }

    @Override
    public List<ConsumptionAmountDTO> selectOrderByDongName() {
        return select("mapper.CAMapper.selectOrderByDongName");
    }

    public List<ConsumptionAmountDTO> selectOrderByIndustryCode() {
        return select("mapper.CAMapper.selectOrderByIndustryCode");
    }

    public List<ConsumptionAmountDTO> selectOrderByAmount() {
        return select("mapper.CAMapper.selectOrderByAmount");
    }

    @Override
    public void insertAll(List<ConsumptionAmountDTO> list) {
        insert("mapper.CAMapper.insert", list);
    }

    @Override
    public void insertOne(ConsumptionAmountDTO element) {
        insert("mapper.CAMapper.insert", element);
    }
}
