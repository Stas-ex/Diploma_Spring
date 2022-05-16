package com.diplom.black_fox_ex.controllers.histories;

import com.diplom.black_fox_ex.model.User;
import com.diplom.black_fox_ex.service.HistoryService;
import com.diplom.black_fox_ex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HistoriesController {
    private final HistoryService historyService;
    private final UserService userService;

    @Autowired
    public HistoriesController(HistoryService historyService, UserService userService) {
        this.historyService = historyService;
        this.userService = userService;
    }


    @GetMapping("/histories/{nameTag}/{numPage}")
    public String getHistoriesByTag(@AuthenticationPrincipal User user, @PathVariable int numPage, @PathVariable String nameTag, Model model){
        var response = historyService.getAllHistoryByTag(nameTag, numPage);

        if(response.getError() != null){
            model.addAttribute("errorHistories",response.getError());
        }
        model.addAttribute("userMenu",userService.getUserMenu(user));
        model.addAttribute("allTags", response.getTags());
        model.addAttribute("histories",response.getListDto());
        model.addAttribute("pageNumbers", response.getPageNumbers());
        model.addAttribute("numPage", numPage);
        model.addAttribute("nameTag", nameTag);

        return "histories";
    }
}