package mismascotas;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.miscontactos.R;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Contacto extends AppCompatActivity {

    EditText nombre,email,comentario;


    Button hacer;

    Session session = null;
    ProgressDialog pdialog = null;
    Context context = null;

    String rec, subject, textMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        context = this;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nombre = (EditText) findViewById(R.id.input_name);
        email = (EditText) findViewById(R.id.input_email);
        comentario = (EditText) findViewById(R.id.input_descripcion);

        hacer = (Button) findViewById(R.id.buttonx);

        hacer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rec = email.getText().toString();
                subject = "Mensaje para"+nombre.getText().toString();
                textMessage = comentario.getText().toString();

                Properties props = new Properties();
                props.put("mail.smtp.host", "smtp.gmail.com");
                props.put("mail.smtp.socketFactory.port", "465");
                props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.port", "465");

                session = Session.getDefaultInstance(props, new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("josejulianfigueroa@gmail.com", "xxx");
                    }
                });

                pdialog = ProgressDialog.show(context, "", "Enviando Correo...", true);

                RetreiveFeedTask task = new RetreiveFeedTask();
                task.execute();
            }

            class RetreiveFeedTask extends AsyncTask<String, Void, String> {

                @Override
                protected String doInBackground(String... params) {

                    try{
                        Message message = new MimeMessage(session);
                        message.setFrom(new InternetAddress("josejulianfigueroa@gmail.com"));
                        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(rec));
                        message.setSubject(subject);
                        message.setContent(textMessage, "text/html; charset=utf-8");
                        Transport.send(message);
                    } catch(MessagingException e) {
                        e.printStackTrace();
                    } catch(Exception e) {
                        e.printStackTrace();
                    }
                    return null;
                }

                @Override
                protected void onPostExecute(String result) {
                    pdialog.dismiss();
                    nombre.setText("");
                    email.setText("");
                    comentario.setText("");
                    Toast.makeText(getApplicationContext(), "Mensaje Enviado", Toast.LENGTH_LONG).show();
                }
            }
            });
    }
}
