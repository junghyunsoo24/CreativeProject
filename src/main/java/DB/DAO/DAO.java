package DB.DAO;

import java.util.List;

public interface DAO<T> {
    public List<T> selectAll();

    public void insertAll(List<T> list);

    public void insertOne(T element);
}
