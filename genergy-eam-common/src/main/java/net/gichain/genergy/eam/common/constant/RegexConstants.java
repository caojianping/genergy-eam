package net.gichain.genergy.eam.common.constant;

public interface RegexConstants {
    String REGEX_PASSWORD = "^(?![a-z]+$)(?![A-Z]+$)(?![\\W_]+$)(?![0-9]+$)[a-zA-Z0-9\\W_][^\\u4e00-\\u9fa5]{7,14}$";

    String REGEX_MOBILE = "^(0|86|17951)?(1[0-9][0-9])[0-9]{8}$";

    String REGEX_EMAIL = "^([0-9A-Za-z\\-_\\.]+)@([0-9a-z]+\\.[a-z]{2,3}(\\.[a-z]{2})?)$";
}
