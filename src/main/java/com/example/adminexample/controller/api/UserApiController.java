package com.example.adminexample.controller.api;


import com.example.adminexample.ifs.CrudInterface;
import com.example.adminexample.model.network.Header;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
public class UserApiController implements CrudInterface {

    @Override
    @PostMapping("")  // /api/user    create 생성 할 때 PostMapping 해주기 규칙
    public Header create() {
        return null;
    }

    @Override
    @GetMapping("{id}")  // /api/user/{id} read 생성 할 떄는 @GetMapping 으로 @GetMapping("{'받을값'}") 이런식으로 해주기 규칙
    public Header read(@PathVariable(name = "id") Long id) {  // mapping 과 같으면 안해도 되지만 다르면 해주기
        return null;
    }

    @Override
    @PostMapping("")  // /api/user    update 생성 할 때 PostMapping 해주기 규칙
    public Header update() {
        return null;
    }

    @Override
    @GetMapping("{id}")  // /api/user/{id} delete 생성 할 떄는 @GetMapping 으로 @GetMapping("{'받을값'}") 이런식으로 해주기 규칙
    public Header delete(@PathVariable Long id) {  //PathVariable 해주면 매칭해줌 변수명이랑 다르면 name = "변수명"해줘야됨
        return null;
    }
}
