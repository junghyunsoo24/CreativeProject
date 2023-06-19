package backend.DB.DAO;

import org.apache.ibatis.session.SqlSessionFactory;
import backend.DB.DTO.DTO;

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

    public Long selectSum(String params) {
        return 'A' <= params.charAt(0) && params.charAt(0) <= 'Z' ? select("mapper.CAFMapper.selectSumAmountWithIndustryCode", params) : select("mapper.CAFMapper.selectSumAmountWithDongName", params);
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
