package hello.business.controller;

import hello.business.entity.User;
import hello.business.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import util.XaResult;

/**
 * Created by lenovo on 2016/7/14.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/findById")
    public XaResult<User>  findByUserId(
            @RequestParam(value = "id") Long id
    ){
        XaResult<User> xr = new XaResult<>();
            User user = userRepository.findById(id);
            xr.setObject(user);
        return xr;
    }

    @RequestMapping("/saveUser")
    public XaResult<String> saveUser(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "args") Integer args
    ){
        userRepository.save(new User(name,args));
        XaResult<String> xr = new XaResult<>();
        xr.setMessage("保存成功");
        return xr;
    }
}
