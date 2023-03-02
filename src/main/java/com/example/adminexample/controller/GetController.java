

package com.example.adminexample.controller;

import com.example.adminexample.model.SearchParam;
import com.example.adminexample.model.network.Header;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api") //localhost:9080/api
public class GetController {

    @RequestMapping(method = RequestMethod.GET, path = "/getMethod") //localhost:9080/api/getMethod
    public String getRequest(){

        return "Hi getMethod";
    }

    @GetMapping("/getParameter") //localhost:9080/api/getParameter?id=1234&password=abcd
    public String getParameter(@RequestParam String id, @RequestParam(name = "password") String pwd){

        String password; //만약 이렇게 있으면 param자리에 password를 못 쓰니 pwd라고 쓰되 이러면 mapping을 못해주니
        // (name = "password")이런식으로 이름을 지정해준다.

        System.out.println("id : " + id);
        System.out.println("pwd : " + pwd);

        return id + pwd;
    }

    //localhost:9080/api/multiParameter?account=abcd@mail.com&page=10 이렇게 검색에 대한변수가 늘어나는 상황
    @GetMapping("/getMultiParameter")
    public SearchParam getMultiParameter(SearchParam searchParam){
        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());

        // SpringBoot에서는 딱히 설정을 해주지 않아도 객체를 통신을 위한 형태인 json형태로 알아서 변환시켜준다.
        // { "account" : "", "email" : "", "page" : 0 } 이런식으로 말이다.
        return searchParam;
    }

    @GetMapping("/header")
    public Header getHeader(){

        // {"resultCode": "OK" , "description" : "OK" }
        return Header.builder().resultCode("OK").description("OK").build();


    }

}

