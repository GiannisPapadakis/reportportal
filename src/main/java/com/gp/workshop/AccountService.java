package com.gp.workshop;

import com.gp.workshop.model.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountService {


    public boolean logAccount(Account account){
        List<String> list = new ArrayList<>();
        list.add("test");
        System.out.println(account.getUsername());
        System.out.println(account.getPassword());
        return true;
    }
}
