package googledrive.infra;

import googledrive.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class SearchHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Search>> {

    @Override
    public EntityModel<Search> process(EntityModel<Search> model) {
        return model;
    }
}
