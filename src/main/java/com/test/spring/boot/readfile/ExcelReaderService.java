// ReadDataFromExcel.java
package com.test.spring.boot.readfile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.test.spring.boot.model.ValidationResult;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@Service
public class ExcelReaderService {

	private final SimpMessagingTemplate messagingTemplate;
	public String outputFilePath = "C:\\Users\\rajas\\Desktop\\Excelcompare\\PreviewTemplate.xlsx";

	@Autowired
	public ExcelReaderService(SimpMessagingTemplate messagingTemplate) {
		this.messagingTemplate = messagingTemplate;
	}

	public void validateExcelFile(MultipartFile file) {
		try {
			int totalSteps = 100;
			int currentStep = 0;

			sendProgressUpdate(10, "Validation complete! Report saved.");

			sendProgressUpdate(30, "Validation complete! Report saved.");

			sendProgressUpdate(50, "Validation complete! Report saved.");

			sendProgressUpdate(100, "Validation complete! Report saved.");

		} catch (Exception e) {
			sendProgressUpdate(0, "Error during validation: " + e.getMessage());
		}
	}

	private void sendProgressUpdate(int percentage, String message) {
		messagingTemplate.convertAndSend("/topic/progress", "progress:" + percentage);
		messagingTemplate.convertAndSend("/topic/progress", "message:" + message);
	}

	public String simulateProgressTask(int progress) {
		// TODO Auto-generated method stub
		return null;
	}

	public ValidationResult startValidation() {
		ValidationResult result = new ValidationResult();

		try {
			// Perform the validation logic
			int progress = 100; // Simulate progress completion
			String message = "Validation completed successfully.";
			String outputFolderLocation = "C:\\Users\\rajas\\Desktop\\TFS Search\\123456";

			// Set the validation results
			result.setProgressPercentage(progress);
			result.setMessage(message);
			result.setOutputFolderLocation(outputFolderLocation);

		} catch (Exception e) {
			// Handle exceptions
			result.setProgressPercentage(0);
			result.setMessage("Validation failed: " + e.getMessage());
			result.setOutputFolderLocation(null);
		}

		return result;
	}

	public String getOutputFilePath() {
		outputFilePath = "C:\\Users\\rajas\\Desktop\\Excelcompare\\PreviewTemplate.xlsx";
		return outputFilePath;
	}
	
	public String convertExcelToHtml(String filePath) {
		String storyNumber = "123456";
	    try (FileInputStream fis = new FileInputStream(filePath);
	         Workbook workbook = new XSSFWorkbook(fis)) {
	        Sheet sheet = workbook.getSheetAt(0);
	        StringBuilder htmlBuilder = new StringBuilder();
	        htmlBuilder.append("<table border='1'>");
	        for (Row row : sheet) {
	            htmlBuilder.append("<tr>");
	            for (Cell cell : row) {
	                htmlBuilder.append("<td>").append(cell.toString()).append("</td>");
	            }
	            htmlBuilder.append("</tr>");
	        }
	        htmlBuilder.append("</table>");
	        String htmlFilePath = "src/main/resources/static/previews/" + storyNumber + ".html";
	        try (FileWriter writer = new FileWriter(htmlFilePath)) {
	            writer.write(htmlBuilder.toString());
	        }
	        return htmlFilePath; // Return the path of the generated HTML
	    } catch (IOException e) {
	        e.printStackTrace();
	        return null;
	    }
	}
}
