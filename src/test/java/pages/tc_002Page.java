package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import java.io.File;
import java.nio.file.Paths;
import java.awt.Desktop;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;
import java.io.IOException;

public class tc_002Page {
    WebDriver driver;

    public tc_002Page(WebDriver driver) {
        this.driver = driver;
    }

    public void loginToApplication() {
        // Code for logging in to the application
    }

    public void exportClaimAccountingReport() {
        // Code to navigate and click to download the report
    }

    public boolean isReportDownloaded() {
        // Logic to check if the report is downloaded
        String downloadPath = System.getProperty("user.home") + "/Downloads";
        File file = Paths.get(downloadPath, "ClaimAccountingReport.xlsx").toFile();
        return file.exists();
    }

    public boolean isEstadoCodigoColumnCorrectlyPositioned() {
        // Logic to open Excel and verify column position
        String downloadPath = System.getProperty("user.home") + "/Downloads/ClaimAccountingReport.xlsx";
        try (FileInputStream fis = new FileInputStream(downloadPath)) {
            Workbook workbook = WorkbookFactory.create(fis);
            Sheet sheet = workbook.getSheetAt(0);
            Row row = sheet.getRow(0);
            Cell cell = row.getCell(8); // Assuming column 'i' is index 8
            String header = cell.getStringCellValue();
            Cell nextCell = row.getCell(9);
            String nextHeader = nextCell.getStringCellValue();
            workbook.close();
            return "Estado Código".equals(nextHeader);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}