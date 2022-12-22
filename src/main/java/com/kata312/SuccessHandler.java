@Configuration
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

  
  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
    Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());

    if (roles.contains("ADMIN")) {
      response.sendRedirect("/admin/users");
    } else if (roles.contains("user")) {
      response.sendRedirect("/user");
    }
    else {
      response.sendRedirect("/login");
    }
  }
}
