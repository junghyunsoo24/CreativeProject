package DB.DAO;

import DB.DTO.ConsumptionAmountForeignerDTO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class ConsumptionAmountForeignerDAO implements DAO<ConsumptionAmountForeignerDTO> {
    private final SqlSessionFactory sqlSessionFactory;

    public ConsumptionAmountForeignerDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public List<ConsumptionAmountForeignerDTO> selectAll() {
        List<ConsumptionAmountForeignerDTO> list;

        try (SqlSession session = sqlSessionFactory.openSession()) {
            list = session.selectList("mapper.CAFMapper.selectAll");
        }

        return list;
    }

    @Override
    public void insertAll(List<ConsumptionAmountForeignerDTO> list) {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            for (ConsumptionAmountForeignerDTO element : list) {
                session.insert("mapper.CAFMapper.insertAll", element);
            }
        } finally {
            session.commit();
            session.close();
        }
    }
}
