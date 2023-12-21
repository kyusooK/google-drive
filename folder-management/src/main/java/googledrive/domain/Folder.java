package googledrive.domain;

import googledrive.FolderManagementApplication;
import googledrive.domain.FolderCreated;
import googledrive.domain.FolderDeleted;
import googledrive.domain.FolderShared;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Folder_table")
@Data
//<<< DDD / Aggregate Root
public class Folder {

    @Id
    private String folderId;

    private String folderName;

    @PostPersist
    public void onPostPersist() {
        FolderCreated folderCreated = new FolderCreated(this);
        folderCreated.publishAfterCommit();

        FolderShared folderShared = new FolderShared(this);
        folderShared.publishAfterCommit();

        FolderDeleted folderDeleted = new FolderDeleted(this);
        folderDeleted.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static FolderRepository repository() {
        FolderRepository folderRepository = FolderManagementApplication.applicationContext.getBean(
            FolderRepository.class
        );
        return folderRepository;
    }

    //<<< Clean Arch / Port Method
    public void moveFolder(MoveFolderCommand moveFolderCommand) {
        //implement business logic here:

        FolderMoved folderMoved = new FolderMoved(this);
        folderMoved.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
