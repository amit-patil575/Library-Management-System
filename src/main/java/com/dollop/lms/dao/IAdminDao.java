package com.dollop.lms.dao;

import java.util.List;

import com.dollop.lms.bean.Admin;

public interface IAdminDao {
    public Integer insertAdmin(List<Admin> admins);
    public Admin login(String userName,String password);
    public Boolean isAdminExist();

    public Boolean changeAdminStatus(String uuid);
}
 