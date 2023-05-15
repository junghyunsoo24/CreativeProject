package persistence.DAO;

import persistence.DTO.ConsumptionAmountOutsiderDTO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class ConsumptionAmountOutsiderDAO extends DAO<ConsumptionAmountOutsiderDTO> {
    public ConsumptionAmountOutsiderDAO(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }

    @Override
    public List<ConsumptionAmountOutsiderDTO> selectAll() {
        return select("mapper.CAOMapper.selectAll");
    }

    @Override
    public List<ConsumptionAmountOutsiderDTO> selectOrderByMonth() {
        return select("mapper.CAOMapper.selectOrderByMonth");
    }

    @Override
    public List<ConsumptionAmountOutsiderDTO> selectOrderByDongName() {
        return select("mapper.CAOMapper.selectDongName");
    }

    public List<ConsumptionAmountOutsiderDTO> selectOrderByIndustryCode() {
        return select("mapper.CAOMapper.selectIndustryCode");
    }

    public List<ConsumptionAmountOutsiderDTO> selectOrderByAmount() {
        return select("mapper.CAOMapper.selectOrderByAmount");
    }

    @Override
    public void insertAll(List<ConsumptionAmountOutsiderDTO> list) {
        insert("mapper.CAOMapper.insert", list);
    }

    @Override
    public void insertOne(ConsumptionAmountOutsiderDTO element) {
        insert("mapper.CAOMapper.insert", element);
    }
}
