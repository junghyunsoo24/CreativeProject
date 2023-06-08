package backend.DB.DAO;

import org.apache.ibatis.session.SqlSessionFactory;
import backend.DB.DTO.DTO;

import java.util.List;

public class ConsumptionAmountDAO extends DAO<DTO>{
    public ConsumptionAmountDAO(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }

    @Override
    public List<DTO> selectAll() {
        return select("mapper.CAMapper.selectAll");
    }

    @Override
    public List<DTO> selectOrderByMonth() {
        return select("mapper.CAMapper.selectOrderByMonth");
    }

    @Override
    public List<DTO> selectOrderByDongName() {
        return select("mapper.CAMapper.selectOrderByDongName");
    }

    public List<DTO> selectOrderByIndustryCode() {
        return select("mapper.CAMapper.selectOrderByIndustryCode");
    }

    public List<DTO> selectOrderByAmount() {
        return select("mapper.CAMapper.selectOrderByAmount");
    }

    @Override
    public void insertAll(List<DTO> list) {
        insert("mapper.CAMapper.insert", list);
    }

    @Override
    public void insertOne(DTO element) {
        insert("mapper.CAMapper.insert", element);
    }
}
