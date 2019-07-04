package com.yosra.bibliophiles.controller;

import com.yosra.bibliophiles.Repository.BookRepository;
import com.yosra.bibliophiles.Repository.LinkRepository;
import com.yosra.bibliophiles.Repository.VoteRepository;
import com.yosra.bibliophiles.domain.Book;
import com.yosra.bibliophiles.domain.Link;
import com.yosra.bibliophiles.domain.Vote;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class VoteController {
    private VoteRepository voteRepository;
    private LinkRepository linkRepository;
    private BookRepository bookRepository;

    public VoteController(VoteRepository voteRepository, LinkRepository linkRepository, BookRepository bookRepository) {
        this.voteRepository = voteRepository;
        this.linkRepository = linkRepository;
        this.bookRepository = bookRepository;
    }

    @Secured({"ROLE_USER"})
    @GetMapping("/vote/link/{linkID}/direction/{direction}/votecount/{voteCount}")
    public int voteLink(@PathVariable Long linkID, @PathVariable short direction,
                    @PathVariable int voteCount) {
        Optional<Link> optionalLink = linkRepository.findById(linkID);
        if( optionalLink.isPresent() ) {
            Link link = optionalLink.get();
            Vote vote = new Vote(direction,link);
            voteRepository.save(vote);
            int updatedVoteCount = voteCount + direction;
            link.setVoteCount(updatedVoteCount);
            linkRepository.save(link);
            return updatedVoteCount;
        }
        return voteCount;
    }

    @Secured({"ROLE_USER"})
    @GetMapping("/vote/book/{bookID}/direction/{direction}/votecount/{voteCount}")
    public int voteBook(@PathVariable Long bookID, @PathVariable short direction,
                    @PathVariable int voteCount) {
        Optional<Book> optionalBook = bookRepository.findById(bookID);
        if( optionalBook.isPresent() ) {
            Book book = optionalBook.get();
            Vote vote = new Vote(direction,book);
            voteRepository.save(vote);
            int updatedVoteCount = voteCount + direction;
            book.setVoteCount(updatedVoteCount);
            bookRepository.save(book);
            return updatedVoteCount;
        }
        return voteCount;
    }
}
