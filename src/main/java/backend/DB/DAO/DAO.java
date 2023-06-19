package backend.DB.DAO;

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

    protected Long select(String statement, String params) {
        Long sum;

        try (SqlSession session = sqlSessionFactory.openSession()) {
            sum = session.selectOne(statement, params);
        }

        return sum;
    }

    public abstract List<T> selectAll();
    public List<T> selectOrderByMonth() {
        return null;
    }
    public List<T> selectOrderByDongName() {
        return null;
    }

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
