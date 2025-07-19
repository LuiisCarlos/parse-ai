package dev.luisworks.parse_ai.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import net.sourceforge.tess4j.TesseractException;

public interface OcrService {

    String extractTextFromImage(MultipartFile file) throws IOException, TesseractException;

}
