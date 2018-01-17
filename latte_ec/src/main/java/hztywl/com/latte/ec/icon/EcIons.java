package hztywl.com.latte.ec.icon;

import com.joanzapata.iconify.Icon;

/**
 * Created by ${梅鹏} on 2018/1/17.
 */

public enum EcIons implements Icon {
    icon_scon('\ue64b'),

    icon_ali_pay('\ue657');

    private char character;

    EcIons(char character) {
        this.character = character;
    }

    @Override
    public String key() {
        return this.name().replace('_', '-');
    }

    @Override
    public char character() {
        return character;
    }
}
