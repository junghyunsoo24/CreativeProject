package persistence;

import persistence.DAO.AdminDAO;
import persistence.DTO.AdminDTO;

public class DummyAdminInserter {
    public static void main(String[] args) {
        AdminDAO adminDAO = new AdminDAO(MyBatisConnectionFactory.getSqlSessionFactory());
        adminDAO.insertOne(new AdminDTO("admin", "admin"));
        System.out.println("데이터 삽입 완료");
    }

}
