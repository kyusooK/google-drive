package googledrive.domain;

import googledrive.domain.*;
import googledrive.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class FolderMoved extends AbstractEvent {

    private String folderId;
    private String destinationFolderId;

    public FolderMoved(Folder aggregate) {
        super(aggregate);
    }

    public FolderMoved() {
        super();
    }
}
//>>> DDD / Domain Event
