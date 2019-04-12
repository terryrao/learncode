package com.example.fluxdemo.service;

import com.example.fluxdemo.model.Quote;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

/**
 * @author raowei
 * @date 2019-04-09
 */
public interface QuoteMongoReactiveRepository extends ReactiveCrudRepository<Quote, String> {

    @Query("{id: {$exists: true }}")
    Flux<Quote> retrieveAllQuotesPaged(final Pageable page);


}
