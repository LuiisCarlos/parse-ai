package dev.luisworks.parse_ai.document.service;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StorageServiceClient {

    private final WebClient webClient;

    // private final DocumentService documentService;

    public void uploadFileAsync(MultipartFile multipartFile) {
        webClient.post()
                .uri("http://storage-service:8092/storage/upload")
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .body(BodyInserters.fromMultipartData("file", multipartFile))
                .retrieve()
                .bodyToMono(String.class)
                .subscribe(response -> {
                    System.out.println(response);
                }, error -> {

                });
    }

}
