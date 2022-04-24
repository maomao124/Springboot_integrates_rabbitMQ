package mao.springboot_integrates_rabbitmq.controller;

import mao.springboot_integrates_rabbitmq.data.Data;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Project name(项目名称)：Springboot_integrates_rabbitMQ
 * Package(包名): mao.springboot_integrates_rabbitmq.controller
 * Class(类名): MyController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/4/24
 * Time(创建时间)： 12:55
 * Version(版本): 1.0
 * Description(描述)： 无
 */


@RestController
public class MyController
{
    /**
     * The Rabbit template.
     */
    @Autowired
    RabbitTemplate rabbitTemplate;

    /**
     * Test 1 string.
     *
     * @param msg the msg
     * @return the string
     */
    @GetMapping("/test/{msg}")
    @ResponseBody
    public String test1(@PathVariable String msg)
    {
        rabbitTemplate.convertAndSend("directExchange1", "key1", "hello-world-你好:" + msg);
        return msg;
    }

    /**
     * Test 2 data.
     *
     * @return the data
     */
    @GetMapping("/test2")
    @ResponseBody
    public Data test2()
    {
        Data data = new Data(5687, "张三", "男", 19);
        rabbitTemplate.convertAndSend("directExchange1", "key1", data);
        return data;
    }
}