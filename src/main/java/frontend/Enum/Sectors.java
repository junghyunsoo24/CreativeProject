package frontend.Enum;

import java.util.ArrayList;
import java.util.List;

//업종별
public enum Sectors {
    제조업("C","제조업"),
    건섭업("F", "건설업"),
    도매_및_소매업("G","도매 및 소매업"),
    운수_및_창고업("H","운수 및 창고업"),
    숙박_및_음식점업("I","숙박 및 음식점업"),
    정보통신업("J","정보통신업"),
    금융_및_보험업("K","금융 및 보험업"),
    부동산업("L","부동산업"),
    전문_과학_및_기술_서비스업("M", "전문,과학 및 기술 서비스업"),
    사업시설_관리_사업_지원_및_임대_서비스업("N","사업시설 관리, 사업 지원 및 임대 서비스업"),
    공공행정_국방_및_사회보장_행정("O", "공공 행정, 국방 및 사회보장 행정"),
    교육_서비스업("P","교육 서비스업"),
    보건업_및_사회복지_서비스업("Q", "보건업 및 사회복지 서비스업"),
    예술_스포츠_및_여가관련_서비스업("R", "예술, 스포츠 및 여가관련 서비스업"),
    협회_및_단체_수리_및_기타_개인_서비스업("S","협회 및 단체, 수리 및 기타 개인 서비스업");

    private final String code;
    private final String industry;
    Sectors(String code, String industry) {
        this.code = code;
        this.industry = industry;
    }

    public String getCode() {
        return code;
    }

    public String getIndustry() {
        return industry;
    }

    public static List<Sectors> getList(){
        List<Sectors> sectorsList = new ArrayList<>();
        for(Sectors sectors : values()){
            sectorsList.add(sectors);
        }
        return sectorsList;
    }
}
