package googledrive.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class ShareFileCommand {

    private String fileId;
    private String sharedWithEmail;
    private String permission;
}
