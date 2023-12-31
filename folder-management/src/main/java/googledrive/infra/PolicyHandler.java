package googledrive.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import googledrive.config.kafka.KafkaProcessor;
import googledrive.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    FolderRepository folderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='FileShared'"
    )
    public void wheneverFileShared_FileSharingPolicy(
        @Payload FileShared fileShared
    ) {
        FileShared event = fileShared;
        System.out.println(
            "\n\n##### listener FileSharingPolicy : " + fileShared + "\n\n"
        );
        // Sample Logic //
        Folder folder = Folder.repository().findById(event.getFileId()).get();
        ShareFolderCommand shareFolderCommand = new ShareFolderCommand();
        shareFolderCommand.setFolderId(folder.getFolderId());
        shareFolderCommand.setSharedWithEmail(event.getSharedWithEmail());
        shareFolderCommand.setPermission(event.getPermission());
        folder.shareFolder(shareFolderCommand);
    }
}
