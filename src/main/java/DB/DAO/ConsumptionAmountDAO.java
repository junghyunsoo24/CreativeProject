package DB.DAO;

import DB.DTO.ConsumptionAmountDTO;
import DB.DTO.DTO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class ConsumptionAmountDAO implements DAO {
    private final SqlSessionFactory sqlSessionFactory;

    public ConsumptionAmountDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public List<DTO> selectAll() {
        return null;
    }
}
