package DB.DAO;

import DB.DTO.ConsumptionAmountDTO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
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
                session.insert("mapper.CAMapper.insert", element);
            }
        } finally {
            session.commit();
            session.close();
        }
    }

    @Override
    public void insertOne(ConsumptionAmountDTO element) {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            session.insert("mapper.CAMapper.insert", element);
        } finally {
            session.commit();
            session.close();
        }
    }
}
