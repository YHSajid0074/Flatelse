package com.agiles.flatelse.excel;

import com.agiles.flatelse.auth.model.User;
import com.agiles.flatelse.auth.repository.UserRepo;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExcelReportService {
    public UserRepo userRepo;
    public ExcelRepo excelRepo;
    public ExcelReportService(UserRepo userRepo, ExcelRepo excelRepo) {
        this.userRepo = userRepo;
        this.excelRepo= excelRepo;
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

        row.setHeightInPoints(25);
        CellStyle wrapStyle = workbook.createCellStyle();
        wrapStyle.setWrapText(true); // Enable text wrapping

        int dataRow = 1;
        for (User user : users) {
            HSSFRow row1 = sheet.createRow(dataRow);
            row1.createCell(0).setCellValue(user.getId());
            row1.createCell(1).setCellValue(user.getUsername());
            row1.createCell(2).setCellValue(user.getEmail());
            Cell passwordCell = row1.createCell(3);
            passwordCell.setCellValue(user.getPassword());
            passwordCell.setCellStyle(wrapStyle);
            row1.setHeightInPoints(30);
            dataRow++;
        }

        sheet.setColumnWidth(0, 4000); // ID column width
        sheet.setColumnWidth(1, 8000); // Name column width
        sheet.setColumnWidth(2, 8000); // Email column width
        sheet.setColumnWidth(3, 10000);

        ServletOutputStream ops= response.getOutputStream();
       workbook.write(ops);
       ops.close();


    }


    @Transactional
    public void saveExcelData(MultipartFile file) {
        try (InputStream inputStream = file.getInputStream()) {
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(0); // Get the first sheet

            List<ExcelUser> users = new ArrayList<>();
            for (int i = 1; i <= sheet.getLastRowNum(); i++) { // Start from row 1 to skip header
                Row row = sheet.getRow(i);

                if (row == null) {
                    continue; // Skip empty rows
                }

                ExcelUser user = new ExcelUser();

                // Safely get ID
                Cell idCell = row.getCell(0);
                if (idCell != null && idCell.getCellType() == CellType.NUMERIC) {
                    user.setId((long) idCell.getNumericCellValue());
                } else {
                    // Handle invalid or missing ID (you can throw an exception or skip the row)
                    continue;
                }

                // Safely get username
                Cell usernameCell = row.getCell(1);
                if (usernameCell != null) {
                    user.setUsername(usernameCell.getStringCellValue());
                }

                // Safely get email
//                Cell emailCell = row.getCell(2);
//                if (emailCell != null) {
//                    user.setEmail(emailCell.getStringCellValue());
//                }
//
//                // Safely get password
//                Cell passwordCell = row.getCell(3);
//                if (passwordCell != null) {
//                    user.setPassword(passwordCell.getStringCellValue());
//                }

                users.add(user);
            }

            // Save all the users in the database
            excelRepo.saveAll(users);

        } catch (Exception e) {
            // Log the exception for debugging
            System.err.println("Error while reading Excel file: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Failed to read Excel file", e);
        }
    }











}
