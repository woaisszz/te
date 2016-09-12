package hello.business.controller;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import hello.business.entity.Customer;
import hello.business.repository.CustomerRepository;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import util.XaResult;
import util.XaUtil;

import java.util.List;

/**
 * Created by lenovo on 2016/5/5.
 */
@Api(value = "顾客接口", description = "顾客接口", position = 10)
@RestController
@RequestMapping("api/customer")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @ApiOperation(value="查询所有顾客",notes="查询所有,当返回的code=1时，取出object进行显示,存放为数组对象")
    @ResponseBody
    @RequestMapping(value = "/findAll",method = RequestMethod.POST)
    public XaResult<List<Customer>> findAll(){

         XaResult<List<Customer>> xr= new XaResult<>();

          List<Customer> customers = (List<Customer>) customerRepository.findAll();

        xr.setObject(customers);
        return xr;
    }

    @ApiOperation(value="通过id查询",notes="查询一个客户,当返回的code=1时，取出object进行显示,存放为数组对象")
    @ResponseBody
    @RequestMapping(value = "/findId",method = RequestMethod.POST)
    public XaResult<Customer> findById(
            @RequestParam(value = "id") Long id
    ){
        XaResult<Customer> xr = new XaResult<>();
        Customer customer =  customerRepository.findUser(id);
        if(XaUtil.isEmpty(customer)){
            xr.error("查询结果不存在");
            return xr;
        }
        xr.setObject(customer);
        return xr;
    }

    @ApiOperation(value="通过名字查询",notes="查询一个客户,当返回的code=1时，取出object进行显示,存放为数组对象")
    @ResponseBody
    @RequestMapping(value = "/findByLastName",method = RequestMethod.POST)
    public List<Customer> findByLastName(
            @RequestParam(value = "name") String name
    ){
        List<Customer> customers =  customerRepository.findByLastName(name);
        return customers;
    }
}
