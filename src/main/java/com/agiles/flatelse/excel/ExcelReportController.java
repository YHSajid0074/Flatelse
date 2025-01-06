package com.agiles.flatelse.excel;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("Excel")
public class ExcelReportController {
    @Autowired
    public ExcelReportService excelReportService;

    @GetMapping
    public void generateExcelReport(HttpServletResponse response) throws IOException {

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=flatelse.xls";
        response.setHeader(headerKey, headerValue);
        excelReportService.generateExcelReport(response);
    }

}
