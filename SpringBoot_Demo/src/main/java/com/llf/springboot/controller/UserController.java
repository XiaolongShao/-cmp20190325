package com.llf.springboot.controller;

import com.llf.springboot.common.responseUtil.Response;
import com.llf.springboot.model.UserJpa;
import com.llf.springboot.repository.UserPagingAndSortingRepository;
import com.llf.springboot.repository.UserRepository;
import com.llf.springboot.repository.UserRepositoryTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/demo")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserPagingAndSortingRepository userPagingAndSortingRepository;
    @Autowired
    private UserRepositoryTest userRepositoryTest;

    @GetMapping(path = "/add")
    @ResponseBody
    public Response addNewUser(@RequestParam String name, @RequestParam String email) {
        UserJpa n = new UserJpa();
        n.setName(name);
        n.setEmail(email);
        UserJpa userSave = userRepository.save(n);
        return new Response(userSave.getId());
    }

    @GetMapping(path = "/add1/{name}/{email}")
    @ResponseBody
    public Long addNewUserT(@PathVariable(name = "name") String name, @PathVariable(name = "email") String email) {
        UserJpa no = new UserJpa();
        no.setName(name);
        no.setEmail(email);
        return userRepository.save(no).getId();
    }

    @PostMapping(path = "/add2")
    @ResponseBody
    public Long addNewUserF(@RequestBody UserJpa userJpa) {
        return userRepository.save(userJpa).getId();
    }

    @GetMapping(path = "/all")
    @ResponseBody
    public Iterable<UserJpa> getAllUsers() {
        Iterable<UserJpa> all = userRepositoryTest.findByName("First");
        return all;
    }



    @GetMapping(path = "/getPage")
    @ResponseBody
    public Page<UserJpa> getAllUsersPage(@RequestParam final int pageSize, @RequestParam final int pageNum) {
        Page<UserJpa> all = userPagingAndSortingRepository.findAll(new Pageable() {
            @Override
            public int getPageNumber() {
                return pageNum;
            }

            @Override
            public int getPageSize() {
                return pageSize;
            }

            @Override
            public int getOffset() {
                return 0;
            }

            @Override
            public Sort getSort() {
                return null;
            }

            @Override
            public Pageable next() {
                return null;
            }

            @Override
            public Pageable previousOrFirst() {
                return null;
            }

            @Override
            public Pageable first() {
                return null;
            }

            @Override
            public boolean hasPrevious() {
                return false;
            }
        });
//                new PageRequest(1, 10, new Sort(new
//                        Sort.Order(Sort.Direction.DESC,""))));
        return all;
    }


}

