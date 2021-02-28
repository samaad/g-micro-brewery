package bee.org.guru.web.model;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class BeerPagedList extends PageImpl<BeerDtoV2> {

    public BeerPagedList(List<BeerDtoV2> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public BeerPagedList(List<BeerDtoV2> content){
        super(content);
    }
}
