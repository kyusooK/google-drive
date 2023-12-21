package googledrive.domain;

import googledrive.SearchEngineApplication;
import googledrive.domain.FilteringSearch;
import googledrive.domain.KeywordSearch;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Search_table")
@Data
//<<< DDD / Aggregate Root
public class Search {

    @Id
    private String keyword;

    private String filter;

    @PostPersist
    public void onPostPersist() {
        KeywordSearch keywordSearch = new KeywordSearch(this);
        keywordSearch.publishAfterCommit();

        FilteringSearch filteringSearch = new FilteringSearch(this);
        filteringSearch.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static SearchRepository repository() {
        SearchRepository searchRepository = SearchEngineApplication.applicationContext.getBean(
            SearchRepository.class
        );
        return searchRepository;
    }
}
//>>> DDD / Aggregate Root
