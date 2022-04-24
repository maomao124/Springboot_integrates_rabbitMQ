package mao.springboot_integrates_rabbitmq;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Project name(项目名称)：Springboot_integrates_rabbitMQ
 * Package(包名): mao.springboot_integrates_rabbitmq
 * Class(类名): Producer2
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/4/24
 * Time(创建时间)： 12:41
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@SpringBootTest
public class Producer2
{
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    void send1()
    {
        rabbitTemplate.convertAndSend("key1", "hello-world-你好");
    }
}
