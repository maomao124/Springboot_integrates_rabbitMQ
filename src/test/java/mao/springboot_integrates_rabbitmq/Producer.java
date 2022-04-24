package mao.springboot_integrates_rabbitmq;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.charset.StandardCharsets;

/**
 * Project name(项目名称)：Springboot_integrates_rabbitMQ
 * Package(包名): mao.springboot_integrates_rabbitmq
 * Class(类名): Producer
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/4/24
 * Time(创建时间)： 12:12
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@SpringBootTest
public class Producer
{
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    void send1()
    {
        Message message = new Message("消息1".getBytes(StandardCharsets.UTF_8));
        rabbitTemplate.send(message);
    }


}
