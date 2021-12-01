package com.leon.hello.swagger.controller;

import com.google.common.collect.Lists;
import com.leon.hello.swagger.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiOperationSupport;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * @PROJECT_NAME: hello-swagger
 * @CLASS_NAME: UserController
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/12/1 19:30
 * @Version 1.0
 * @DESCRIPTION:
 **/
@RestController
@RequestMapping("/user")
@Api(value = "UserController", tags = "用户信息") // tags
public class UserController {

    /**
     * 用户列表查询
     *
     * @param user
     * @return
     */
    @PostMapping("/list")
    @ApiOperationSupport(order = 1, author = "OceanLeonAI")
    @ApiOperation(value = "用户列表查询", notes = "传入User对象作为查询条件")
    public List<User> list(@Valid @RequestBody User user) {

        System.out.println("入参 user ---> " + user);

        List<User> userList = Lists.newArrayList();
        for (int i = 0; i < 3; i++) {
            userList.add(
                    User.builder()
                            .name("张三" + (i + 1))
                            .age((i + 1))
                            .createDate(new Date())
                            .build()
            );
        }
        return userList;
    }

    /**
     * 单个用户查询
     *
     * @param id
     * @return
     */
    @GetMapping("/byId")
    @ApiOperation(value = "单个用户查询", notes = "传入用户id", position = 2)
    public User byId(@ApiParam(value = "主键", required = true) @RequestParam String id) {

        System.out.println("入参 id ---> " + id);

        return User.builder()
                .id(id)
                .name("张三")
                .age(1)
                .createDate(new Date())
                .build();
    }

}
