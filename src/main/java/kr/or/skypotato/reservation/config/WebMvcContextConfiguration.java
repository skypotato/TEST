package kr.or.skypotato.reservation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "kr.or.skypotato.reservation.controller" })
public class WebMvcContextConfiguration extends WebMvcConfigurerAdapter {

	private static final int RESOURCE_CACHE_PERIOD_SECONDS = 31556926;
	/**
	 * 리소스 핸들러 설정 <resources location="/resources/" mapping="/resources/**">
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(RESOURCE_CACHE_PERIOD_SECONDS);
		registry.addResourceHandler("/font/**").addResourceLocations("/font/").setCachePeriod(RESOURCE_CACHE_PERIOD_SECONDS);
		registry.addResourceHandler("/img/**").addResourceLocations("/img/").setCachePeriod(RESOURCE_CACHE_PERIOD_SECONDS);
		registry.addResourceHandler("/img_map/**").addResourceLocations("/img_map/").setCachePeriod(RESOURCE_CACHE_PERIOD_SECONDS);
		registry.addResourceHandler("/js/**").addResourceLocations("/js/").setCachePeriod(RESOURCE_CACHE_PERIOD_SECONDS);
	}

	/**
	 * Default servlet handler 사용설정
	 */
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	/**
	 * View Controller 설정
	 */
	@Override
	public void addViewControllers(final ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("/main");
	}

}
