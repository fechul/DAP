package com.skcc.dataanalysis.csvfileread.service;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import org.springframework.stereotype.Service;

import com.skcc.dataanalysis.common.vo.PersonVO;
import com.skcc.dataanalysis.csvfileread.vo.CsvFileVO;


@Service("csvFileReadService")
public class CsvFileReadService {

	public void readCsvFile(CsvFileVO csvFileVO) {
		try{
			Reader reader = Files.newBufferedReader(Paths.get(csvFileVO.getCsvFilePath()));
			ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
            strategy.setType(PersonVO.class);
            String[] memberFieldsToBindTo = {"gender", "age", "major", "area", "grade", "character", "career"};
            strategy.setColumnMapping(memberFieldsToBindTo);
			
            CsvToBean csvToBean = 
            		new CsvToBeanBuilder(reader)
                    .withMappingStrategy(strategy)
                    .withSkipLines(1)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            
            List<PersonVO> personVoList = csvToBean.parse();

            for (PersonVO person : personVoList) {
                System.out.println("gender : " + person.getGender());
                System.out.println("age : " + person.getAge());
                System.out.println("area : " + person.getArea());
                System.out.println("grade : " + person.getGrade());
                System.out.println("character : " + person.getCharacter());
                System.out.println("career : " + person.getCareer());
                System.out.println("---------------------------");
            }
            
		} catch (Exception e){
			e.printStackTrace();
		}
		
	}

}
