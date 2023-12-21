package googledrive.domain;

import googledrive.domain.*;
import googledrive.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class FilteringSearch extends AbstractEvent {

    private String filter;

    public FilteringSearch(Search aggregate) {
        super(aggregate);
    }

    public FilteringSearch() {
        super();
    }
}
//>>> DDD / Domain Event
