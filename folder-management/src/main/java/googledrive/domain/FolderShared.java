package googledrive.domain;

import googledrive.domain.*;
import googledrive.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class FolderShared extends AbstractEvent {

    private String folderId;
    private String sharedWithEmail;
    private String permission;

    public FolderShared(Folder aggregate) {
        super(aggregate);
    }

    public FolderShared() {
        super();
    }
}
//>>> DDD / Domain Event
