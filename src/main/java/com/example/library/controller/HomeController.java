package com.example.library.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import java.util.List;
import com.example.library.entity.Book;
import com.example.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.example.library.repository.BookRepository;
import com.example.library.service.MemberService;
import com.example.library.entity.Member;


@Controller
public class HomeController {
    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private MemberService memberService;

    @GetMapping("/")
    public String index(Model model) {
        //Get all books using repository
        List<Book> books = bookRepository.findAll();

        //Get all books using service
        List<Book> books2 = bookService.getAllBooks();

        //Pass books to view
        model.addAttribute("books", books);
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/member")
    public String member(Model model) {
        List<Member> members = memberService.getAllMembers();
        model.addAttribute("members", members);
        return "member";
    }
}
