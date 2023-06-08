package persistence.DAO;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import persistence.DTO.AdminDTO;
import persistence.DTO.DTO;

import java.util.List;

public class AdminDAO extends DAO<DTO> {
    public AdminDAO(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }

    @Override
    public List<DTO> selectAll() {
        return select("mapper.AdminMapper.selectAll");
    }

    public boolean findByIdAndPassword(AdminDTO target) {
        SqlSession session = sqlSessionFactory.openSession();
        AdminDTO admin = null;

        try {
            admin = session.selectOne("mapper.AdminMapper.findByIdAndPassword", target);
        } finally {
            session.commit();
            session.close();
        }

        return admin != null;
    }

    @Override
    public void insertAll(List<DTO> list) {
        insert("mapper.AdminMapper.insert", list);
    }

    @Override
    public void insertOne(DTO element) {
        insert("mapper.AdminMapper.insert", element);
    }
}
