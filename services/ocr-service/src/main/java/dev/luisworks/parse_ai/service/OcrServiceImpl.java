package dev.luisworks.parse_ai.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

@Slf4j
@Service
public class OcrServiceImpl implements OcrService {

    public String extractTextFromImage(MultipartFile file) throws IOException, TesseractException {
        Tesseract tesseract = new Tesseract();

        // Set the path to your tessdata directory
        tesseract.setDatapath("/usr/share/tessdata");
        // tesseract.setTessVariable("user_defined_dpi", "300");

        // Save the uploaded file to a temporary location
        Path tempFile = Files.createTempFile("tempImage", file.getOriginalFilename());
        file.transferTo(tempFile.toFile());

        // Perform OCR on the image
        String result = tesseract.doOCR(tempFile.toFile());

        // Delete the temporary file
        Files.delete(tempFile);

        return result;
    }

}
