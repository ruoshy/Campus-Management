package cn.ousky.smartcampus.util;

import cn.ousky.smartcampus.model.Login;
import com.alibaba.fastjson.JSON;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Date;

@Component
public class TokenUtil {

    // 公钥
    @Value("${rsa.public-key}")
    private String publicKey;

    // 私钥
    @Value("${rsa.private-key}")
    private String privateKey;

    public Boolean addCookie(Login login, HttpServletResponse response) {
        try{
            // 生成token
            String token = getToken(login);
            // 获取当前时间
            String verify = String.valueOf(new Date().getTime());
            // 返回cookie
            response.addCookie(new Cookie("token", token));
            response.addCookie(new Cookie("verify", verify));
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }


    /**
     * 验证token
     *
     * @param token token
     * @return 验证结果
     */
    public boolean verify(String token) {
        // 解密
        String deToken = decrypt(token);
        return false;
    }

    /**
     * 根据登录信息 加密生成token
     *
     * @param login 登录数据
     * @return token
     */
    public String getToken(Login login) {
        return encryption(JSON.toJSONString(login));
    }

    /**
     * rsa加密
     *
     * @param value 待加密字符串
     * @return token
     */
    public String encryption(String value) {
        String outStr = null;
        try {
            //base64编码的公钥
            byte[] decoded = Base64.decodeBase64(publicKey);
            RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decoded));
            //RSA加密
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, pubKey);
            outStr = Base64.encodeBase64String(cipher.doFinal(value.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return outStr;
    }

    /**
     * rsa解密
     *
     * @param token 待解密字符串
     * @return 解密后的字符串
     */
    public String decrypt(String token) {
        String outStr = null;
        try {
            //64位解码加密后的字符串
            byte[] inputByte = Base64.decodeBase64(token.getBytes(StandardCharsets.UTF_8));
            //base64编码的私钥
            byte[] decoded = Base64.decodeBase64(privateKey);
            RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decoded));
            //RSA解密
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, priKey);
            outStr = new String(cipher.doFinal(inputByte));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return outStr;
    }
}
