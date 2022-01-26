package com.uildsonsantos.consultacep.services.impl;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import com.uildsonsantos.consultacep.model.Cliente;
import com.uildsonsantos.consultacep.services.AbstractEmailService;

@Service
public class SendgridEmailService extends AbstractEmailService {

	@Autowired
	private SendGrid sendGrid;

	@Value("${default.sender}")
	private String sender;

	@Value("${default.name}")
	private String name;

	private static final Logger LOG = LoggerFactory.getLogger(SendgridEmailService.class);

	@Override
	public void sendEmail(Cliente cliente) {

		Email from = new Email(sender, name);
		String subject = "Confirmação de acesso!";
		Email to = new Email(cliente.getEmail());

		Content content = new Content("text/html",
				"Alguem <strong> Alterou os seus dados</strong>. Se não foi você, entre em contato com nossa central. <a href=\"https://github.com/UildsonSantos/lab_gof_GFT_consulta-cep-API\">Click aqui!</a>");

		Mail mail = new Mail(from, subject, to, content);

		Request request = new Request();

		try {
			request.setMethod(Method.POST);
			request.setEndpoint("mail/send");
			request.setBody(mail.build());

			LOG.info("Sending email to: " + cliente.getEmail());
			Response response = sendGrid.api(request);

			if (response.getStatusCode() >= 400 && response.getStatusCode() <= 500) {
				LOG.error("Error sending email: " + response.getBody());
			} else {
				LOG.info("Email sent! Status = " + response.getStatusCode());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
