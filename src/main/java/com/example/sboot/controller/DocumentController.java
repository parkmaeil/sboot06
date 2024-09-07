package com.example.sboot.controller;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RestController
public class DocumentController {

    @PostMapping("/generate-doc")
    public ResponseEntity<byte[]> generateDoc(@RequestParam("content") String content) {

        Document document = Jsoup.parse(content);
        System.out.println(document.toString());
        // POI API
        XWPFDocument doc = new XWPFDocument();

        for (Element element : document.body().children()) {
            if (element.tagName().equals("p")) {
                XWPFParagraph paragraph = doc.createParagraph();
                paragraph.createRun().setText(element.text());
            } else if (element.tagName().equals("br")) {
                XWPFParagraph paragraph = doc.createParagraph();
                paragraph.createRun().addBreak();
            }
        }

        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            doc.write(out);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

            return new ResponseEntity<>(out.toByteArray(), headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

