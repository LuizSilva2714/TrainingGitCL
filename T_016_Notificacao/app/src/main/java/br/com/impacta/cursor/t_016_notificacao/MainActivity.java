package br.com.impacta.cursor.t_016_notificacao;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    private Context context;
    //
    private Button btn_notificacao;
    private Button btn_cancelar;
    //
    private int idNotificacao = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);
        //
        context = getBaseContext();
        //
        btn_notificacao = (Button) findViewById(R.id.btn_notificacao);
        btn_notificacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(context, MainActivity.class);
                //
                PendingIntent pi = PendingIntent.getActivity(context, 0, mIntent, 0);
                //
                NotificationManager nm = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
                //
                Notification.Builder notificacao = new Notification.Builder(context);
                notificacao.setContentIntent(pi)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setAutoCancel(true)
                        .setContentTitle("Sincronismo")
                        .setContentText("Download efetuado com sucesso!!!");
                //
                notificacao.setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE);
                //
                int versao = Build.VERSION.SDK_INT; // Versao do android do equipamento
                //
                if ( versao >= Build.VERSION_CODES.JELLY_BEAN_MR1){
                    nm.notify(idNotificacao, notificacao.build());
                } else {
                    nm.notify(idNotificacao, notificacao.getNotification());
                }

            }
        });
        btn_cancelar = (Button) findViewById(R.id.btn_cancelar);
        btn_cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationManager nm = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
                nm.cancel(idNotificacao);
            }
        });
        //

    }


}
