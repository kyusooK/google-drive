package googledrive.domain;

import googledrive.domain.*;
import googledrive.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class FileShared extends AbstractEvent {

    private String fileId;
    private String sharedWithEmail;
    private String permission;
}
