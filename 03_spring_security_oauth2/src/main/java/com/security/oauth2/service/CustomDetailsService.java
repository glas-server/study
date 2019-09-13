package com.security.oauth2.service;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.oauth2.entity.CustomUser;
import com.security.oauth2.entity.UserEntity;

@Service
public class CustomDetailsService implements UserDetailsService {

   @Override
   public CustomUser loadUserByUsername(final String username) throws UsernameNotFoundException {
      UserEntity userEntity = null;
      if(username.equals("user")) {
    	  throw new UsernameNotFoundException("User " + username + " was not found in the database");
      }
      try {
         userEntity = new UserEntity();
         userEntity.setPassword(new BCryptPasswordEncoder().encode("password"));
         userEntity.setUsername("user");
         return new CustomUser(userEntity);
      } catch (Exception e) {
         e.printStackTrace();
         throw new UsernameNotFoundException("User " + username + " was not found in the database");
      }
   }
} 