package googledrive.domain;

import googledrive.domain.*;
import googledrive.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class FolderDeleted extends AbstractEvent {

    private String folderId;

    public FolderDeleted(Folder aggregate) {
        super(aggregate);
    }

    public FolderDeleted() {
        super();
    }
}
//>>> DDD / Domain Event
