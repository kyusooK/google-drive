package googledrive.domain;

import googledrive.FileManagementApplication;
import googledrive.domain.FileDownloaded;
import googledrive.domain.FileShared;
import googledrive.domain.FileUploaded;
import googledrive.domain.NewFileCreated;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "File_table")
@Data
//<<< DDD / Aggregate Root
public class File {

    @Id
    private String fileId;

    private String fileName;

    private String fileType;

    private String fileContent;

    @PostPersist
    public void onPostPersist() {
        NewFileCreated newFileCreated = new NewFileCreated(this);
        newFileCreated.publishAfterCommit();

        FileUploaded fileUploaded = new FileUploaded(this);
        fileUploaded.publishAfterCommit();

        FileShared fileShared = new FileShared(this);
        fileShared.publishAfterCommit();

        FileDownloaded fileDownloaded = new FileDownloaded(this);
        fileDownloaded.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static FileRepository repository() {
        FileRepository fileRepository = FileManagementApplication.applicationContext.getBean(
            FileRepository.class
        );
        return fileRepository;
    }
}
//>>> DDD / Aggregate Root
