package DB.DTO;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DTOListBuilder {
    private CSVReader csvReader;
    private List<String[]> csvVal;

    public DTOListBuilder(File csv) throws IOException, CsvException {
        csvReader = new CSVReader(new FileReader(csv));
        csvVal = csvReader.readAll();
    }


    public List<ConsumptionAmountDTO> CAListBuild() throws IOException, CsvException {
        List<ConsumptionAmountDTO> list = new ArrayList<>();

        for (int i = 1; i < csvVal.size(); i++) {
            ConsumptionAmountDTO dto = new ConsumptionAmountDTO(csvVal.get(i));
            list.add(dto);
        }

        return list;
    }

    public List<ConsumptionAmountForeignerDTO> CAFListBuild() throws IOException, CsvException {
        List<ConsumptionAmountForeignerDTO> list = new ArrayList<>();

        for (int i = 1; i < csvVal.size(); i++) {
            ConsumptionAmountForeignerDTO dto = new ConsumptionAmountForeignerDTO(csvVal.get(i));
            list.add(dto);
        }

        return list;
    }

    public List<ConsumptionAmountOutsiderDTO> CAOListBuild() throws IOException, CsvException {
        List<ConsumptionAmountOutsiderDTO> list = new ArrayList<>();

        for (int i = 1; i < csvVal.size(); i++) {
            ConsumptionAmountOutsiderDTO dto = new ConsumptionAmountOutsiderDTO(csvVal.get(i));
            list.add(dto);
        }

        return list;
    }

    public List<DailyFloatingPopulationDTO> DFPListBuild() throws IOException, CsvException {
        List<DailyFloatingPopulationDTO> list = new ArrayList<>();

        for (int i = 1; i < csvVal.size(); i++) {
            DailyFloatingPopulationDTO dto = new DailyFloatingPopulationDTO(csvVal.get(i));
            list.add(dto);
        }

        return list;
    }
}
