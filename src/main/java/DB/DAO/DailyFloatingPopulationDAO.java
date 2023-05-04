package DB.DAO;

import DB.DTO.DailyFloatingPopulationDTO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class DailyFloatingPopulationDAO implements DAO<DailyFloatingPopulationDTO> {
    private final SqlSessionFactory sqlSessionFactory;

    public DailyFloatingPopulationDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }


    @Override
    public List<DailyFloatingPopulationDTO> selectAll() {
        List<DailyFloatingPopulationDTO> list;

        try (SqlSession session = sqlSessionFactory.openSession()) {
            list = session.selectList("mapper.DFPMapper.selectAll");
        }

        return list;
    }

    @Override
    public void insertAll(List<DailyFloatingPopulationDTO> list) {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            for (DailyFloatingPopulationDTO element : list) {
                session.insert("mapper.DFPMapper.insertAll", element);
            }
        } finally {
            session.commit();
            session.close();
        }
    }
}
