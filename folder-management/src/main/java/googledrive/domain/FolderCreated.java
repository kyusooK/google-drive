package googledrive.domain;

import googledrive.domain.*;
import googledrive.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class FolderCreated extends AbstractEvent {

    private String folderId;
    private String folderName;

    public FolderCreated(Folder aggregate) {
        super(aggregate);
    }

    public FolderCreated() {
        super();
    }
}
//>>> DDD / Domain Event
