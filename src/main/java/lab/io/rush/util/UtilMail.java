package lab.io.rush.util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import lab.io.rush.config.Constant;
//Email������
public class UtilMail {
    // �����˵� ���� �� ���루�滻Ϊ�Լ�����������룩
    private static String myEmailAccount = "13590290465@163.com";
    private static String myEmailPassword = "ab4802176";

    // ����������� SMTP ��������ַ, ����׼ȷ, ��ͬ�ʼ���������ַ��ͬ, һ���ʽΪ: smtp.xxx.com
    // ����163����� SMTP ��������ַΪ: smtp.163.com
    private static String myEmailSMTPHost = "smtp.163.com";

    // �ռ������䣨�滻Ϊ�Լ�֪������Ч���䣩
//    public static String receiveMailAccount = "1586213545@qq.com";

    public static void sendMail(String receiveMailAccount,String contentMail) throws Exception {
        // 1. ������������, ���������ʼ��������Ĳ�������
        Properties props = new Properties();                    // ��������
        props.setProperty("mail.transport.protocol", "smtp");   // ʹ�õ�Э�飨JavaMail�淶Ҫ��
        props.setProperty("mail.host", myEmailSMTPHost);        // �����˵������ SMTP ��������ַ
        props.setProperty("mail.smtp.auth", "true");            // ������֤���������������ʵ���й�

        // 2. �������ô����Ự����, ���ں��ʼ�����������
        Session session = Session.getDefaultInstance(props);
        session.setDebug(true);                                 // ����Ϊdebugģʽ, ���Բ鿴��ϸ�ķ��� log

        // 3. ����һ���ʼ�
        MimeMessage message = createMimeMessage(session, myEmailAccount, receiveMailAccount,contentMail);

        // 4. ���� Session ��ȡ�ʼ��������
        Transport transport = session.getTransport();

        // 5. ʹ�� �����˺� �� ���� �����ʼ�������
        //    ������֤����������� message �еķ���������һ�£����򱨴�
        transport.connect(myEmailAccount, myEmailPassword);

        // 6. �����ʼ�, �������е��ռ���ַ, message.getAllRecipients() ��ȡ�������ڴ����ʼ�����ʱ��ӵ������ռ���, ������, ������
        transport.sendMessage(message, message.getAllRecipients());

        // 7. �ر�����
        transport.close();
    }

    /**
     * ����һ��ֻ�����ı��ļ��ʼ�
     *
     * @param session �ͷ����������ĻỰ
     * @param sendMail ����������
     * @param receiveMail �ռ�������
     * @return
     * @throws Exception
     */
    public static MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail,String contentMail) throws Exception {
        // 1. ����һ���ʼ�
        MimeMessage message = new MimeMessage(session);

        // 2. From: ������
        message.setFrom(new InternetAddress(sendMail, Constant.NICKNAME, "UTF-8"));

        // 3. To: �ռ��ˣ��������Ӷ���ռ��ˡ����͡����ͣ�
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, "�����û�", "UTF-8"));

        // 4. Subject: �ʼ�����
        message.setSubject(Constant.SUBJECT, "UTF-8");

        // 5. Content: �ʼ����ģ�����ʹ��html��ǩ��
        message.setContent(Constant.CONTENT + contentMail, "text/html;charset=UTF-8");

        // 6. ���÷���ʱ��
        message.setSentDate(new Date());

        // 7. ��������
        message.saveChanges();

        return message;
}
}
