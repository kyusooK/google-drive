package googledrive.domain;

import googledrive.domain.*;
import googledrive.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class KeywordSearch extends AbstractEvent {

    private String keyword;

    public KeywordSearch(Search aggregate) {
        super(aggregate);
    }

    public KeywordSearch() {
        super();
    }
}
//>>> DDD / Domain Event
