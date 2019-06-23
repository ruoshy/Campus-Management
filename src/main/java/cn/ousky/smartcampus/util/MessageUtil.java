package cn.ousky.smartcampus.util;

import cn.ousky.smartcampus.ident.HandleIdent;
import cn.ousky.smartcampus.model.Message;
import org.springframework.stereotype.Component;

@Component
public class MessageUtil {
    public Message getMessage(int code) {
        Message msg = new Message();
        msg.setCode(code);
        if (code == 0) {
            msg.setMsg("操作失败!");
        } else {
            msg.setMsg("操作成功!");
        }
        return msg;
    }

    public Message getMessage(HandleIdent handleIdent) {
        Message msg = new Message();
        switch (handleIdent) {
            case SUCCESS:
                msg.setCode(1);
                msg.setMsg("操作成功!");
                break;
            case FAIL:
                msg.setCode(0);
                msg.setMsg("操作失败!");
                break;
        }
        return msg;
    }
}
