package googledrive.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class MoveFolderCommand {

    private String folderId;
    private String destinationFolderId;
}
