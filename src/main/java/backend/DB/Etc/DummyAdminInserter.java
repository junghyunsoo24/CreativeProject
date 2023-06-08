package backend.DB.Etc;

import backend.DB.DAO.AdminDAO;
import backend.DB.DTO.AdminDTO;
import backend.DB.MyBatisConnectionFactory;

public class DummyAdminInserter {
    public static void main(String[] args) {
        AdminDAO adminDAO = new AdminDAO(MyBatisConnectionFactory.getSqlSessionFactory());
        adminDAO.insertOne(new AdminDTO("admin", "admin"));
        System.out.println("데이터 삽입 완료");
    }

}
