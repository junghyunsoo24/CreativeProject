package DB.DAO;

import DB.DTO.ConsumptionAmountOutsiderDTO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class ConsumptionAmountOutsiderDAO implements DAO<ConsumptionAmountOutsiderDTO> {
    private final SqlSessionFactory sqlSessionFactory;

    public ConsumptionAmountOutsiderDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public List<ConsumptionAmountOutsiderDTO> selectAll() {
        List<ConsumptionAmountOutsiderDTO> list;

        try (SqlSession session = sqlSessionFactory.openSession()) {
            list = session.selectList("mapper.CAOMapper.selectAll");
        }

        return list;
    }

    @Override
    public void insertAll(List<ConsumptionAmountOutsiderDTO> list) {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            for (ConsumptionAmountOutsiderDTO element : list) {
                session.insert("mapper.CAOMapper.insertAll", element);
            }
        } finally {
            session.commit();
            session.close();
        }
    }
}
