package com.company.client;
import com.company.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/*
 * · @FeignClient : we use this annotation to provide the api that we wil consume
 *
 */

@FeignClient(url  = "https://jsonplaceholder.typicode.com/",name = "USER-CLIENT")
public interface UserClient {

     @GetMapping("/users")
     List<User> getUsers();
    /*
     * · When we call the getUsers() method, @FeignClient URL will be triggered, and it will assign the 3rd party api in the list User
     */


}
