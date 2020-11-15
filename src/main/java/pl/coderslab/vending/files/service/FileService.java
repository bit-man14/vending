package pl.coderslab.vending.files.service;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import pl.coderslab.vending.files.entity.File;
import pl.coderslab.vending.files.repository.FileRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FileService {
    @Autowired
    private FileRepository fileRepository;
    
    public File saveFile(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        try {
            File file1 = new File(fileName, file.getContentType(), file.getBytes());
            return fileRepository.save(file1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Optional<File> getFile(Integer fileId) {
        return fileRepository.findById(fileId);
    }
    
    public List<File> getFiles() {
        return fileRepository.findAll();
    }

    public void deleteFile(Integer id) throws ResourceNotFoundException {
        fileRepository.deleteById(id);
    }
}
