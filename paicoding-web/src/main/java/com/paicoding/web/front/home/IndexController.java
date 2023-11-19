package com.paicoding.web.front.home;

import com.paicoding.web.front.home.helper.IndexRecommendHelper;
import com.paicoding.web.front.home.vo.IndexVO;
import com.paicoding.web.global.BaseViewController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController extends BaseViewController {
    @Autowired
    private IndexRecommendHelper indexRecommendHelper;

    @GetMapping(path = {"/", "", "/index", "login"})
    public String index(Model model, HttpServletRequest request) {
        String activeTab = request.getParameter("category");
        IndexVO vo = indexRecommendHelper.buildIndexVO(activeTab);
        model.addAttribute("vo",vo);
        return "views/home/index";
    }
}
