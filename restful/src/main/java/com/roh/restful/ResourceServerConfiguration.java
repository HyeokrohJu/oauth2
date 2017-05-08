package com.roh.restful;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
public class ResourceServerConfiguration {
	@Bean
	public ResourceServerConfigurerAdapter resourceServerConfigurerAdapter() {
		return new ResourceServerConfigurerAdapter() {
			@Override
			public void configure(HttpSecurity http) throws Exception {
				http.headers().frameOptions().disable();
				http.authorizeRequests()
					.antMatchers("/members", "/members/**").access("#oauth2.hasScope('read')")
					.anyRequest().authenticated();
			}
		};
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(MemberRepository memberRepository){
		return args -> {
			memberRepository.save(new Member("이철수", "chulsoo", "test111"));
			memberRepository.save(new Member("김정인", "jungin11", "test222"));
			memberRepository.save(new Member("류정우", "jwryu991", "test333"));
		};
	}
}
