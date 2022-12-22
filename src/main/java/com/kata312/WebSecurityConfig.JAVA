@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserService userService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf()
                    .disable()
                    //Доступ только для пользователей с ролью Администратор
                    .antMatchers("/admin/**").hasRole("ADMIN")
                    .antMatchers("/ user/**").hasRole("USER")
                    //Доступ разрешен всем пользователей
          
                .and()
                    //Настройка для входа в систему
                    .formLogin().permitAll()
                    .loginPage("/login")
                    
                .and()
                    .logout()
                    .permitAll()
                    .logoutSuccessUrl("/login");
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder());
    }
}
