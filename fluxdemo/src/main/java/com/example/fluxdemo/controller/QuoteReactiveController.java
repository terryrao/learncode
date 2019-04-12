package com.example.fluxdemo.controller;

import com.example.fluxdemo.model.Quote;
import com.example.fluxdemo.service.QuoteMongoReactiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

/**
 * @author raowei
 * @date 2019-04-09
 */
@RestController
public class QuoteReactiveController {

    private static final int DELAY_PER_ITEM_MS = 100;

    private QuoteMongoReactiveRepository quoteMongoReactiveRepository;
    @Autowired
    public QuoteReactiveController(final QuoteMongoReactiveRepository quoteMongoReactiveRepository) {
        this.quoteMongoReactiveRepository = quoteMongoReactiveRepository;
    }

    @RequestMapping("/quotes-reactive")
    public Flux<Quote> getQuoteFlux() {
        return quoteMongoReactiveRepository.findAll().delayElements(Duration.ofMillis(DELAY_PER_ITEM_MS));
    }

    @RequestMapping("/quotes-reactive-paged")
    public Flux<Quote> getQuoteFlux(final @RequestParam(name = "page") int page,
                                    final @RequestParam(name = "size") int size) {
        return quoteMongoReactiveRepository.retrieveAllQuotesPaged(PageRequest.of(page,size))
                .delayElements(Duration.ofMillis(DELAY_PER_ITEM_MS));
    }

}
