package mao.springboot_integrates_rabbitmq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Project name(项目名称)：Springboot_integrates_rabbitMQ
 * Package(包名): mao.springboot_integrates_rabbitmq
 * Class(类名): Consumer2
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/4/24
 * Time(创建时间)： 12:54
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Component
public class Consumer2
{
    //@RabbitListener(queues = {"queue1"})
    public void receive(Message message)
    {
        System.out.println("调用");
        System.out.println(new String(message.getBody()));
    }
}
