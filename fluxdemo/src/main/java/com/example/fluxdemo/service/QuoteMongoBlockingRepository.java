package com.example.fluxdemo.service;

import com.example.fluxdemo.model.Quote;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author raowei
 * @date 2019-04-09
 */
public interface QuoteMongoBlockingRepository extends CrudRepository<Quote, String> {

    @Query("{ id: { $exists: true }}")
    List<Quote> retrieveAllQuotesPaged(final Pageable page);
}
