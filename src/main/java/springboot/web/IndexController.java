package springboot.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import springboot.config.auth.LoginUser;
import springboot.config.auth.dto.SessionUser;
import springboot.service.PostsService;
import springboot.web.dto.PageMaker;
import springboot.web.dto.Pagination;
import springboot.web.dto.PostsResponseDto;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user, Pagination page) {
        PageMaker pageMaker = new PageMaker();

        pageMaker.setPage(page);
        pageMaker.setTotalCount(postsService.getTotalCnt(page));

        model.addAttribute("posts", postsService.findListDesc(page));
        model.addAttribute("pageMaker", pageMaker);

        if (user != null) {
            model.addAttribute("userName", user.getName());
        }

        if(page.getKeyword() != ""){
            return "index";
        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(Model model, @LoginUser SessionUser user) {

        model.addAttribute("userName", user.getName());

        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }

}
