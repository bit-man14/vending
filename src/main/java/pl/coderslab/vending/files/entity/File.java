package pl.coderslab.vending.files.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "files")
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fileName;
    private String fileType;
    
    @Lob
    private byte[] data;
    public File() {}
    
    public File(String fileName, String fileType, byte[] data) {
        super();
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
    }
}