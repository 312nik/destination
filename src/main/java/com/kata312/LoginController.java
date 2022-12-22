@Controller
public class UserController {

    @GetMapping("/")
    public String start(){
        return "/login";
    }

    @PostMapping("/login")
    public String getLogin(RequestParam(value = "login", required = false) String login,
                           Model model){
      
        model.addAttribute("login", login);
        return "login";
    }
}
