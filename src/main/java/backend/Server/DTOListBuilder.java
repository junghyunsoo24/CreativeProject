package backend.Server;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import backend.DB.DTO.*;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DTOListBuilder {
    private File csv;
    private CSVReader csvReader;
    private List<String[]> csvVal;

    public DTOListBuilder(File csv) throws IOException, CsvException {
        this.csv = csv;
        csvReader = new CSVReader(new FileReader(csv));
        csvVal = csvReader.readAll();

        if (!csvVal.get(0)[0].contains("기준")) {
            csvReader = new CSVReader(new InputStreamReader(Files.newInputStream(csv.toPath()), "EUC-KR"));
            csvVal = csvReader.readAll();
        }
    }


    public List<DTO> CAListBuild() throws IOException, CsvException {
        List<DTO> list = new ArrayList<>();

        for (int i = 1; i < csvVal.size(); i++) {
            DTO dto = new ConsumptionAmountDTO(csvVal.get(i));
            list.add(dto);
        }

        return list;
    }

    public List<DTO> CAFListBuild() throws IOException, CsvException {
        List<DTO> list = new ArrayList<>();

        for (int i = 1; i < csvVal.size(); i++) {
            DTO dto = new ConsumptionAmountForeignerDTO(csvVal.get(i));
            list.add(dto);
        }

        return list;
    }

    public List<DTO> CAOListBuild() throws IOException, CsvException {
        List<DTO> list = new ArrayList<>();

        for (int i = 1; i < csvVal.size(); i++) {
            DTO dto = new ConsumptionAmountOutsiderDTO(csvVal.get(i));
            list.add(dto);
        }

        return list;
    }

    public List<DTO> DFPListBuild() throws IOException, CsvException {
        List<DTO> list = new ArrayList<>();

        for (int i = 1; i < csvVal.size(); i++) {
            DTO dto = new DailyFloatingPopulationDTO(csvVal.get(i));
            list.add(dto);
        }

        return list;
    }
}
