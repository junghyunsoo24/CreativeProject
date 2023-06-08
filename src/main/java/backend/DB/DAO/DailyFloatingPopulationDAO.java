package backend.DB.DAO;

import backend.DB.DTO.DTO;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class DailyFloatingPopulationDAO extends DAO<DTO> {
    public DailyFloatingPopulationDAO(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }


    @Override
    public List<DTO> selectAll() {
        return select("mapper.DFPMapper.selectAll");
    }

    @Override
    public List<DTO> selectOrderByMonth() {
        return select("mapper.DFPMapper.selectOrderByMonth");
    }

    @Override
    public List<DTO> selectOrderByDongName() {
        return select("mapper.DFPMapper.selectOrderByDongName");
    }
    public List<DTO> selectOrderByDFP() {
        return select("mapper.DFPMapper.selectOrderByDFP");
    }

    @Override
    public void insertAll(List<DTO> list) {
        insert("mapper.DFPMapper.insert", list);
    }

    @Override
    public void insertOne(DTO element) {
        insert("mapper.DFPMapper.insert", element);
    }
}
