package pl.coderslab.vending.files.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pl.coderslab.vending.files.entity.File;
import pl.coderslab.vending.files.service.FileService;

import java.util.List;

@Controller
public class FileController {

    @Autowired
    private FileService fileService;

    @GetMapping("/getfiles")
    public String get(Model model) {
        List<File> files = fileService.getFiles();
        model.addAttribute("files", files);
        return "file";
    }

    @PostMapping("/uploadFiles")
    public String uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        for (MultipartFile file : files) {
            fileService.saveFile(file);

        }
        return "redirect:/getfiles";
    }

    @GetMapping("/downloadFile/{fileId}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable Integer fileId) {
        File file = fileService.getFile(fileId).get();
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(file.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment:filename=\"" + file.getFileName() + "\"")
                .body(new ByteArrayResource(file.getData()));
    }

    @GetMapping("/deletefile/{fileId}")
    public String deleteFile(@PathVariable Integer fileId) {
        fileService.deleteFile(fileId);
        return "redirect:/getfiles";
    }


}