package googledrive.domain;

import googledrive.domain.*;
import googledrive.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class FileShared extends AbstractEvent {

    private String fileId;
    private String sharedWithEmail;
    private String permission;

    public FileShared(File aggregate) {
        super(aggregate);
    }

    public FileShared() {
        super();
    }
}
//>>> DDD / Domain Event
