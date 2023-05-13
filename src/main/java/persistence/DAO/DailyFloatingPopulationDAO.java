package persistence.DAO;

import persistence.DTO.DailyFloatingPopulationDTO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class DailyFloatingPopulationDAO extends DAO<DailyFloatingPopulationDTO> {
    public DailyFloatingPopulationDAO(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }


    @Override
    public List<DailyFloatingPopulationDTO> selectAll() {
        return select("mapper.DFPMapper.selectAll");
    }

    @Override
    public List<DailyFloatingPopulationDTO> selectOrderByMonth() {
        return select("mapper.DFPMapper.selectOrderByMonth");
    }

    @Override
    public List<DailyFloatingPopulationDTO> selectOrderByDongName() {
        return select("mapper.DFPMapper.selectOrderByDongName");
    }
    public List<DailyFloatingPopulationDTO> selectOrderByDFP() {
        return select("mapper.DFPMapper.selectOrderByDFP");
    }

    @Override
    public void insertAll(List<DailyFloatingPopulationDTO> list) {
        insert("mapper.DFPMapper.insert", list);
    }

    @Override
    public void insertOne(DailyFloatingPopulationDTO element) {
        insert("mapper.DFPMapper.insert", element);
    }
}
