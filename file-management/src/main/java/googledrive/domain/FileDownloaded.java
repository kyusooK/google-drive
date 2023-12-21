package googledrive.domain;

import googledrive.domain.*;
import googledrive.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class FileDownloaded extends AbstractEvent {

    private String fileId;

    public FileDownloaded(File aggregate) {
        super(aggregate);
    }

    public FileDownloaded() {
        super();
    }
}
//>>> DDD / Domain Event
