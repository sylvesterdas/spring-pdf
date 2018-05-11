package in.tacto.springpdf;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController implements ErrorController {

    @RequestMapping("/")
    public String index(Model model, HttpServletRequest request) {
        model.addAttribute("title", "Spring PDF");

        switch (request.getMethod()) {
            case "GET":
                return "index";
            default:
                return "404";
        }
    }

    @RequestMapping(value = "/error")
    public String error() {
        return "404";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
