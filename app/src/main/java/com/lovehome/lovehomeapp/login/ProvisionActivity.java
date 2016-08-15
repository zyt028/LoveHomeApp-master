package com.lovehome.lovehomeapp.login;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.lovehome.lovehomeapp.R;

import java.util.Date;

public class ProvisionActivity extends Activity {
    String msg="       本软件在国家相关法律法规规定的范围内，只按现有状况提供虚拟物品在线交易第三方网络平台服务，本软件及其所有者非交易一方，也非交易任何一方之代理人或代表;同时，本软件及其所有者也未授权任何人代表或代理本软件及其所有者从事任何网络交易行为或做出任何承诺、保证或其他类似行为，除非有明确的书面授权。\n\n" +
            "     鉴于互联网及网络交易的特殊性，本软件无法鉴别和判断相关交易各主体之民事权利和行为能力、资质、信用等状况，也无法鉴别和判断虚拟交易或正在交易或已交易虚拟物品来源、权属、真伪、性能、规格、质量、数量等权利属性、自然属性及其他各种状况。因此，交易各方在交易前应加以仔细辨明，并慎重考虑和评估交易可能产生的各项风险。\n\n" +
            "     本软件不希望出现任何因虚拟物品交易而在用户之间及用户与游戏开发运营商之间产生纠纷，但并不保证不发生该类纠纷。对于因前述各类情形而产生的任何纠纷，将由交易各方依据中华人民共和国现行的有关法律通过适当的方式直接加以解决，本软件及其所有者不参与其中；对于因此类交易而产生的各类纠纷之任何责任和后果，由交易各方承担，本软件及其所有者不承担任何责任及后果。\n\n" +
            "     本软件不希望出现任何人利用本软件或因使用本软件而侵犯他人合法权益的行为，但并不保证不会发生此类行为或类似行为。本软件将依据中国法律采取必要的措施防止发生前述各类行为或降低发生这类行为的可能性或者降低由此造成的损失及其后果。对于因前述各类情形而产生的任何纠纷，将由权利受到侵害之人和侵权方依据中华人民共和国现行的有关法律通过适当的方式直接加以解决，本软件及其所有者不参与其中；对于因此类行为产生的各类纠纷之任何责任和后果，由相关责任方承担，本软件及其所有者不承担任何责任及后果。\n\n" +
            "     任何非本软件责任而产生的任何其他纠纷，概由纠纷各方依据中国相关法律以适当的方式直接加以解决，本软件不参与其中；对于因该类行为产生的各类纠纷之任何责任和后果，由相关各方承担，本软件及其所有者不承担任何责任及后果。\n\n"+
            "     如果您对本协议有任何疑问，请及时与我们去的联系。\n";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provision);
        Date date=new Date(System.currentTimeMillis());
        String d=date.toLocaleString();
        ((TextView) findViewById(R.id.t1)).setText(msg);
        ((TextView)findViewById(R.id.t2)).setText("生效日期："+d);
    }
}
