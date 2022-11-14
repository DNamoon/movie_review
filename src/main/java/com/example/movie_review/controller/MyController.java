package com.example.movie_review.controller;

import com.example.movie_review.jdbc.ContentsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {

    @Autowired
    ContentsDao contentsDao;

    @GetMapping("/")
    String index() {
        return "index";
    }

    //loacation.replace로 이동한 페이지는 뒤로 가기 했을 때 index.html로 돌아간다.
    //그래서 따로 매핑해주었다. location.replace 쓰지 말아야 하나? 나중에 리팩토링 해야겠다.
    @GetMapping("/index")
    String main() {
        return "redirect:/";
    }

    @GetMapping("/login")
    String login() {
        return "login";
    }

    @GetMapping("/register")
    String register() {
        return "register";
    }

    @GetMapping("/search")
    String search() {
        return "search";
    }

    @GetMapping("/contents")
    String contents(Model model) {
        model.addAttribute("list", contentsDao.list());
        return "contents";
    }

    @GetMapping("/find_movie")
    String findMovie() {
        return "find_movie";
    }

    @GetMapping("/write")
    String write() {
        return "write";
    }

    @GetMapping("/write_confirm")
    String writeConfirm() {
        return "write_confirm";
    }

//    @GetMapping("/review")
//    String review() {
//        return "review";
//    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("list", contentsDao.list());
        return "listUser";
    }

    @GetMapping("/input")
    public String input(@RequestParam String movie,
                        @RequestParam String title,
                        @RequestParam String review,
                        @RequestParam String writer) {
        int res = contentsDao.insert(movie, title, review, writer);
        //log.info("============= " + res+ "건이 입력되었습니다.");
        return "/write_confirm";
    }

    @GetMapping("/header")
    public String input() {

        return "header.html";
    }

    @GetMapping("/list2")
    public String list2(Model model) {
        model.addAttribute("listTest",contentsDao.list2());
        return "listTest";
    }

//    @GetMapping("/review")
//    public String review(Model model) {
//        model.addAttribute("reviewContent",contentsDao.review());
//        return "review";
//    }
}
