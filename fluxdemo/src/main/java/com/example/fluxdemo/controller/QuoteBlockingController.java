package com.example.fluxdemo.controller;

import com.example.fluxdemo.model.Quote;
import com.example.fluxdemo.service.QuoteMongoBlockingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author raowei
 * @date 2019-04-09
 */
@RestController
public class QuoteBlockingController {
    private static final int DELAY_PER_ITEM_MS = 100;
    private QuoteMongoBlockingRepository quoteMongoBlockingRepository;

    @Autowired
    public QuoteBlockingController(final QuoteMongoBlockingRepository quoteMongoBlockingRepository) {
        this.quoteMongoBlockingRepository = quoteMongoBlockingRepository;
    }

    @GetMapping("/quotes-blocking")
    public Iterable<Quote> getQuotesBlocking() throws InterruptedException {
        Thread.sleep(DELAY_PER_ITEM_MS * quoteMongoBlockingRepository.count());
        return quoteMongoBlockingRepository.findAll();

    }

    @GetMapping("/quotes-blocking-paged")
    public Iterable<Quote> getQuotesBlocking(@RequestParam(name = "page") int page,
                                             @RequestParam(name = "size") int size) throws InterruptedException {
        Thread.sleep(DELAY_PER_ITEM_MS * size);
        return quoteMongoBlockingRepository.retrieveAllQuotesPaged(PageRequest.of(page, size));

    }
}
