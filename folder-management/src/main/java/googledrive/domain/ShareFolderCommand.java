package googledrive.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class ShareFolderCommand {

    private String folderId;
    private String sharedWithEmail;
    private String permission;
}
