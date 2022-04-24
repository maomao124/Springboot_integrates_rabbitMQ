package mao.springboot_integrates_rabbitmq.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Project name(项目名称)：Springboot_integrates_rabbitMQ
 * Package(包名): mao.springboot_integrates_rabbitmq.config
 * Class(类名): RabbitMQConfig
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/4/24
 * Time(创建时间)： 12:19
 * Version(版本): 1.0
 * Description(描述)： 无
 */


@Configuration
public class RabbitMQConfig
{
    /**
     * Gets message converter.
     *
     * @return the message converter
     */
    @Bean
    public MessageConverter getMessageConverter()
    {
        return new Jackson2JsonMessageConverter();
    }

    /**
     * 声明交换机
     *
     * @return directExchange1 direct exchange
     */
    @Bean
    public DirectExchange directExchange1()
    {
        return new DirectExchange("directExchange1", false, false);
    }

    /**
     * 声明队列
     *
     * @return queue1 queue
     */
    @Bean
    public Queue queue1()
    {
        return new Queue("queue1", false, false, false);
    }

    /**
     * Queue 1 binding direct exchange 1 binding.
     *
     * @param queue1          the queue 1
     * @param directExchange1 the direct exchange 1
     * @return the binding
     */
    @Bean
    public Binding queue1_binding_directExchange1(@Qualifier("queue1")
                                                          Queue queue1, @Qualifier("directExchange1")
                                                          DirectExchange directExchange1)
    {
        return BindingBuilder.bind(queue1).to(directExchange1).with("key1");
    }

}
