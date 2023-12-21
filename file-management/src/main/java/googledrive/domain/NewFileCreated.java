package googledrive.domain;

import googledrive.domain.*;
import googledrive.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class NewFileCreated extends AbstractEvent {

    private String fileId;
    private String fileName;
    private String fileType;

    public NewFileCreated(File aggregate) {
        super(aggregate);
    }

    public NewFileCreated() {
        super();
    }
}
//>>> DDD / Domain Event
