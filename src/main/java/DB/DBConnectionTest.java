package DB;

import DB.DAO.ConsumptionAmountDAO;
import DB.DTO.ConsumptionAmountDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnectionTest {
    public static void main(String[] args) {
        ConsumptionAmountDAO CADAO = new ConsumptionAmountDAO(MyBatisConnectionFactory.getSqlSessionFactory());
//        ConsumptionAmountDTO CADTO = ConsumptionAmountDTO.builder()
//                .year(2020)
//                .dong_code("F")
//                .dong_name("구암동")
//                .industry_code("F")
//                .industry_name("건설업(41~42)")
//                .amount(14850400)
//                .build();
//
//        List<ConsumptionAmountDTO> list = new ArrayList<>();
//        list.add(CADTO);
//        CADAO.insertAll(list);
        System.out.println(CADAO.selectAll().get(0).toString());
    }
}
