package googledrive.infra;

import googledrive.domain.*;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/folders")
@Transactional
public class FolderController {

    @Autowired
    FolderRepository folderRepository;

    @RequestMapping(
        value = "folders/{id}/",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Folder moveFolder(
        @PathVariable(value = "id") String id,
        @RequestBody MoveFolderCommand moveFolderCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /folder/moveFolder  called #####");
        Optional<Folder> optionalFolder = folderRepository.findById(id);

        optionalFolder.orElseThrow(() -> new Exception("No Entity Found"));
        Folder folder = optionalFolder.get();
        folder.moveFolder(moveFolderCommand);

        folderRepository.save(folder);
        return folder;
    }
}
//>>> Clean Arch / Inbound Adaptor
