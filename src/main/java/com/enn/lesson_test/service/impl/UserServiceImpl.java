package com.enn.lesson_test.service.impl;

import com.enn.lesson_test.Exception.BizException;
import com.enn.lesson_test.entity.User;
import com.enn.lesson_test.mapper.UserMapper;
import com.enn.lesson_test.service.IUserService;
import com.enn.lesson_test.service.ex.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;
    /**打印日志*/

    /**添加用户，即用户注册*/
    @Override
    public Map addUser(User user){
        /**添加时首先要看用户名是否已经被占用*/
        Map<String,String> map=new HashMap<>();
        try {
            String username=user.getUsername();
            User result=userMapper.findByName(username);
//        if(result!=null){
//            throw new UsernameDuplicationException();
//        }
            /**对密码进行加密操作*/
            String salt= UUID.randomUUID().toString().toUpperCase();
            String inputpassword=user.getPassword();
            String insertpassword=Md5password(inputpassword,salt);

            user.setPassword(insertpassword);
            user.setSalt(salt);
            user.setIsDelete(0);
            Integer res=userMapper.addUser(user);
            map.put("执行结果","添加用户成功！！！");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("执行结果","添加用户出现了错误");
            return map;
        }
//        if(res!=1){
//            throw new UserInsertException();
//        }

    }

    @Override
    public void addUser2(User user){
        /**添加时首先要看用户名是否已经被占用*/
        String username=user.getUsername();
        System.out.println("程序进这儿没！！！username");
        User result=userMapper.findByName(username);
        System.out.println("程序此时执行到这里，result="+result);
        if(result!=null){
            System.out.println("程序进入判断");
            throw new BizException(4000,"该用户已经被占用");
        }
        System.out.println("程序跳过了异常");
            /**对密码进行加密操作*/
        String salt= UUID.randomUUID().toString().toUpperCase();
        String inputpassword=user.getPassword();
        String insertpassword=Md5password(inputpassword,salt);

        user.setPassword(insertpassword);
        user.setSalt(salt);
        user.setIsDelete(0);
        Integer res=userMapper.addUser(user);
        if(res!=1){
            throw new BizException(4001,"用户添加出现未知错误");
        }

    }
    /**密码加密方式*/
    public String Md5password(String password,String salt){
        for(int i=0;i<3;i++){
            password= DigestUtils.md5DigestAsHex((salt+password+salt).getBytes()).toUpperCase();
        }
        return password;
    }

    @Override
    public User login(String username,String password){
        User result=userMapper.findByName(username);
        if(result==null){
            throw new UserNotFoundException();
        }
        if(!result.getIsDelete().equals(0)){
            throw new UserNotFoundException();
        }
        String salt=result.getSalt();
        if(!result.getPassword().equals(Md5password(password,salt))){
            throw new PasswordNotMatchException();
        };

        /**登录后返回的信息*/
        User user=new User();
        user.setUsername(username);
        user.setGender(result.getGender());
        user.setUid(result.getUid());
        return user;
    }


    /**通过id查询用户信息*/
    @Override
    public User findUser(Integer uid){
        User result=userMapper.findUser(uid);
        if(result==null){
            throw new UserNotFoundException();
        }
        return result;
    }

    @Override
    public User findByName(String username){
        User result=userMapper.findByName(username);
        if(result==null){
            throw new UserNotFoundException();
        }
        return result;
    }

    @Override
    public void updateUserPassword(Integer uid,String oldpassword,String newpassword){
        User result=userMapper.findUser(uid);
        if(result==null){
            throw new UserNotFoundException();
        }
        if(!result.getIsDelete().equals(0)){
            throw new UserNotFoundException();
        }

        /**查看旧密码是否匹配*/
        String salt=result.getSalt();
        if(!result.getPassword().equals(Md5password(oldpassword,salt))){
            throw new PasswordNotMatchException();
        }

        String insertpassword=Md5password(newpassword,salt);
        Integer res=userMapper.updateUserPassword(uid,insertpassword,salt);

        if(res!=1){
            throw new UpdatePasswordException();
        }

    }

    @Override
    public void deleteUserMessage(Integer uid){
        User result=userMapper.findUser(uid);
        Integer isd=result.getIsDelete();
        if(result==null){
            throw new UserNotFoundException();
        }
        if(isd==1){
            throw new UserNotFoundException();
        }
        Integer res=userMapper.deleteUserMessage(uid);
        if(res!=1){
            throw new DeleteUserException();
        }

    }

}
