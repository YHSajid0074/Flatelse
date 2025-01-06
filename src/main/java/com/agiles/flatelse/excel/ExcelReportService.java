package com.agiles.flatelse.excel;

import com.agiles.flatelse.auth.model.User;
import com.agiles.flatelse.auth.repository.UserRepo;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@Service
public class ExcelReportService {
    public UserRepo userRepo;
    public ExcelReportService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    public void generateExcelReport(HttpServletResponse response) throws IOException {
        List<User> users = userRepo.findAll();
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Users");
        HSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("ID");
        row.createCell(1).setCellValue("Name");
        row.createCell(2).setCellValue("Email");
        row.createCell(3).setCellValue("Password");

        int dataRow = 1;
        for (User user : users) {
            HSSFRow row1 = sheet.createRow(dataRow);
            row1.createCell(0).setCellValue(user.getId());
            row1.createCell(1).setCellValue(user.getUsername());
            row1.createCell(3).setCellValue(user.getPassword());
            row1.createCell(2).setCellValue(user.getEmail());
            dataRow++;
        }
        sheet.setColumnWidth(0, 4000); // ID column
        sheet.setColumnWidth(1, 8000); // Name column
        sheet.setColumnWidth(2, 10000); // Email column
        sheet.setColumnWidth(3, 10000); // Password column

        // Optionally auto-size all columns based on content
        for (int i = 0; i < 4; i++) {
            sheet.autoSizeColumn(i);
        }
        ServletOutputStream ops= response.getOutputStream();
       workbook.write(ops);
       ops.close();

    }
}
