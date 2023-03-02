package com.example.adminexample.controller;

import com.example.adminexample.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api") //localhost:9080/api    method끼리에 RequestMapping의 주소가 겹치면 오류가 나지만 객체끼리는 같아도 된다.
public class PostController {

    // HTML <Form>
    // ajax 검색
    // http post body -> data
    /* json, xml, multipart-form / text-plain 이렇게 여러가지 형식이 있는데 그걸 다 지원할 수 없으니
    @PostMapping(value = "/postMethod", produces = {"application-json"})
    이런식으로 제공하는 타입을 지정해 줄 수 있다.
    이렇게 안해주면 기본적으로 json형식을 지원한다. */

    //    @RequestMapping(method = RequestMethod.POST , path = "/postMethod") 이렇게도 쓸 수 있으나 너무 기니깐 밑에 방식으로 하자.
    @PostMapping("/postMethod")
    public SearchParam postMethod(@RequestBody SearchParam searchParam){


        return searchParam;
    }

    @PutMapping("/putMethod")
    public void put(){

    }

    @PatchMapping("/patchMethod")
    public void patch(){

    }

}

