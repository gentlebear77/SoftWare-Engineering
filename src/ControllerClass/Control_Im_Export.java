package ControllerClass;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.*;
import EntityClass.*;
public class Control_Im_Export {
    public static void Export_Module_Excel(Student s,String dest_filename) throws Exception {

        //创建工作表 工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("sheet1");

        int rowCount = 0;

        Row row = sheet.createRow(rowCount);
        int columnCount = 0;
        //表头
        for (columnCount = 0; columnCount < 5; columnCount++) {
            Cell cell = row.createCell(columnCount);
            switch (columnCount) {
                case 0:
                    cell.setCellValue("ModuleNum");
                    break;
                case 1:
                    cell.setCellValue("ModuleName");
                    break;
                case 2:
                    cell.setCellValue("Grade");
                    break;
                case 3:
                    cell.setCellValue("Credit");
                    break;
                case 4:
                    cell.setCellValue("Mark");
                    break;
            }
        }
        //利用modulelist填写表格具体内容
        for (rowCount = 1; rowCount <= (s.moduleList.size()); rowCount++) {
            row = sheet.createRow(rowCount);
            for (columnCount = 0; columnCount < 5; columnCount++) {
                Cell cell = row.createCell(columnCount);
                switch (columnCount) {
                    case 0:
                        cell.setCellValue(s.moduleList.get(rowCount - 1).getModuleNum());
                        break;
                    case 1:
                        cell.setCellValue(s.moduleList.get(rowCount - 1).getModuleName());
                        break;
                    case 2:
                        cell.setCellValue(s.moduleList.get(rowCount - 1).getGrade());
                        break;
                    case 3:
                        cell.setCellValue(s.moduleList.get(rowCount - 1).getCredit());
                        break;
                    case 4:
                        cell.setCellValue(s.moduleList.get(rowCount - 1).getMark());
                        break;
                }
            }
        }

        //        Excel输出路径
        try (FileOutputStream outputStream = new FileOutputStream(dest_filename)) {
            workbook.write(outputStream);
        }
    }
}
