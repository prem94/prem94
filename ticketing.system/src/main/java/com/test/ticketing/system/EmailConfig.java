package com.test.ticketing.system;
import java.io.IOException;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

public class EmailConfig {

  // Minimum required to send an email
  public static Mail buildHelloEmail() {
    Email from = new Email("yogesh@sinecycle.com");
    String subject = "Agent has Responded to your Ticket";
    Email to = new Email("alwaripremkumar@gmail.com");
    Content content = new Content("text/plain", "Please the ticket agent has added a comment");
    Mail mail = new Mail(from, subject, to, content);
    return mail;
  }

  public static void send(final Mail mail) throws IOException {
    final SendGrid sg = new SendGrid("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");

    final Request request = new Request();
    request.setMethod(Method.POST);
    request.setEndpoint("mail/send");
    request.setBody(mail.build());

    final Response response = sg.api(request);
    System.out.println(response.getStatusCode());
    System.out.println(response.getBody());
    System.out.println(response.getHeaders());
  }
  
}