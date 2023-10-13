package email.sender.api.consumers;

import email.sender.api.dtos.EmailDto;
import email.sender.api.models.EmailModel;
import email.sender.api.services.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {
    @Autowired
    EmailService emailService;

    // Método ouvinte, que escuta o arquivos de configurações
    @RabbitListener(queues = "${spring.rabbitmq.queue}") // Escuta a fila que já foi definida
    public void listen(@Payload EmailDto emailDto){
        EmailModel emailModel = new EmailModel();

        BeanUtils.copyProperties(emailDto, emailModel);
        emailService.sendEmail(emailModel);
        System.out.println("Email Status " + emailModel.getStatusEmail().toString());

    }

}
