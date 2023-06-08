package persistence.DAO;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public abstract class DAO<T> {
    protected final SqlSessionFactory sqlSessionFactory;

    public DAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    protected List<T> select(String statement) {
        List<T> list;

        try (SqlSession session = sqlSessionFactory.openSession()) {
            list = session.selectList(statement);
        }

        return list;
    }
    public abstract List<T> selectAll();
    public abstract List<T> selectOrderByMonth();
    public abstract List<T> selectOrderByDongName();

    protected void insert(String statement, List<T> list) {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            for (T element : list) {
                session.insert(statement, element);
            }
        } finally {
            session.commit();
            session.close();
        }
    }

    protected void insert(String statement, T element) {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            session.insert(statement, element);
        } finally {
            session.commit();
            session.close();
        }
    }

    public abstract void insertAll(List<T> list);
    public abstract void insertOne(T element);
}
