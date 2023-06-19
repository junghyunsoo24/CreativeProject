package backend.DB.DAO;

import backend.DB.DTO.DTO;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class ConsumptionAmountOutsiderDAO extends DAO<DTO> {
    public ConsumptionAmountOutsiderDAO(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }

    @Override
    public List<DTO> selectAll() {
        return select("mapper.CAOMapper.selectAll");
    }

    @Override
    public List<DTO> selectOrderByMonth() {
        return select("mapper.CAOMapper.selectOrderByMonth");
    }

    @Override
    public List<DTO> selectOrderByDongName() {
        return select("mapper.CAOMapper.selectDongName");
    }

    public List<DTO> selectOrderByIndustryCode() {
        return select("mapper.CAOMapper.selectIndustryCode");
    }

    public List<DTO> selectOrderByAmount() {
        return select("mapper.CAOMapper.selectOrderByAmount");
    }

    public Long selectSum(String params) {
        return 'A' <= params.charAt(0) && params.charAt(0) <= 'Z' ? select("mapper.CAOMapper.selectSumAmountWithIndustryCode", params) : select("mapper.CAOMapper.selectSumAmountWithDongName", params);
    }

    @Override
    public void insertAll(List<DTO> list) {
        insert("mapper.CAOMapper.insert", list);
    }

    @Override
    public void insertOne(DTO element) {
        insert("mapper.CAOMapper.insert", element);
    }
}
