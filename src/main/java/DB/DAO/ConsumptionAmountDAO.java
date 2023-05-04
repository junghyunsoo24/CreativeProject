package DB.DAO;

import DB.DTO.ConsumptionAmountDTO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class ConsumptionAmountDAO implements DAO<ConsumptionAmountDTO> {
    private final SqlSessionFactory sqlSessionFactory;

    public ConsumptionAmountDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public List<ConsumptionAmountDTO> selectAll() {
        List<ConsumptionAmountDTO> list;

        try (SqlSession session = sqlSessionFactory.openSession()) {
            list = session.selectList("mapper.CAMapper.selectAll");
        }

        return list;
    }

    @Override
    public void insertAll(List<ConsumptionAmountDTO> list) {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            for (ConsumptionAmountDTO element : list) {
                session.insert("mapper.CAMapper.insertAll", element);
            }
        } finally {
            session.commit();
            session.close();
        }
    }
}
