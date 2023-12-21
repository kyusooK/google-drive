package googledrive;

import static org.junit.Assert.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import googledrive.config.kafka.KafkaProcessor;
import googledrive.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.context.ApplicationContext;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.MimeTypeUtils;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FileSharingPolicyTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileSharingPolicyTest.class);

    @Autowired
    private KafkaProcessor processor;

    @Autowired
    private MessageCollector messageCollector;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    public FolderRepository folderRepository;

    @Test
    @SuppressWarnings("unchecked")
    public void test0() throws Exception { 
        FolderMoved entity = new FolderMoved();

        entity.setFolderId("1");

        // folderMoved 객체를 Folder 객체로 변환
        Folder folder = new Folder();
        folder.setFolderId(entity.getFolderId());

        // entity를 저장하기 위해 save 메소드를 사용
        folderRepository.save(folder);

        FileShared event = new FileShared();

        event.setFileId("1");
        event.setSharedWithEmail("example@example.com");
        event.setPermission("read");

        FolderManagementApplication.applicationContext = applicationContext;

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String msg = objectMapper.writeValueAsString(event);

            processor
                .inboundTopic()
                .send(
                    MessageBuilder
                       