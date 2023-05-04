package DB.DAO;

import DB.DTO.DTO;

import java.util.List;

public interface DAO<T> {
    public List<T> selectAll();

    public void insertAll(List<T> list);
}
