package ru.v10tov.services;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;
import ru.v10tov.entity.PriceEntity;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelHelper {
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERs = {"id", "electrician", "finishing", "plumbing", "conditioners", "design", "view", "names", "unit", "price"};
    static String SHEET = "PriceEntity";

    public static boolean hasExcelFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }
    public static List<PriceEntity> excelToPriceEntity(InputStream is) {
        try {
            Workbook workbook = new XSSFWorkbook(is);

            Sheet sheet = workbook.getSheet(SHEET);
            Iterator<Row> rows = sheet.iterator();

            List<PriceEntity> priceEntityList = new ArrayList<PriceEntity>();

            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();

                // skip header
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cellsInRow = currentRow.iterator();

                PriceEntity priceEntity = new PriceEntity();

                int cellIdx = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();

                    switch (cellIdx) {
                        case 0:
                            priceEntity.setId((long) currentCell.getNumericCellValue());
                            break;

                        case 1:
                            priceEntity.setElectrician(currentCell.getBooleanCellValue());
                            break;

                        case 2:
                            priceEntity.setFinishing(currentCell.getBooleanCellValue());
                            break;

                        case 3:
                            priceEntity.setPlumbing(currentCell.getBooleanCellValue());
                            break;

                        case 4:
                            priceEntity.setAirConditioners(currentCell.getBooleanCellValue());
                            break;

                        case 5:
                            priceEntity.setDesign(currentCell.getBooleanCellValue());
                            break;

                        case 6:
                            priceEntity.setView(currentCell.getStringCellValue());
                            break;

                        case 7:
                            priceEntity.setNames(currentCell.getStringCellValue());
                            break;

                        case 8:
                            priceEntity.setUnit(currentCell.getStringCellValue());
                            break;

                        case 9:
                            priceEntity.setPrice((long) currentCell.getNumericCellValue());
                            break;

                        default:
                            break;
                    }

                    cellIdx++;
                }

                priceEntityList.add(priceEntity);
            }

            workbook.close();

            return priceEntityList;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }
}
