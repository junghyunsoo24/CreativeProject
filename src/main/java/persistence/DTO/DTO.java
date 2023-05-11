package persistence.DTO;

import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.lang.reflect.Field;

public abstract class DTO {
    public DTO(String[] line) throws IOException, CsvException {
        Class<?> dtoClass = this.getClass();

        Field[] fields = dtoClass.getDeclaredFields();
        for (int i = 0; i < fields.length - 1; i++) {
            Field cur = fields[i + 1];
            cur.setAccessible(true);
            String type = cur.getType().toString();

            try {
                if (type.equals("double")) {
                    cur.set(this, Double.parseDouble(line[i]));
                } else if (type.contains("String")) {
                    cur.set(this, line[i]);
                } else if (type.equals("int")) {
                    cur.set(this, Integer.parseInt(line[i]));
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
