package com.paicoding.api.model.exception;

import com.paicoding.api.model.vo.constants.StatusEnum;

public class ExceptionUtil {
    public static ForumException of(StatusEnum status, Object... args) {
        return new ForumException(status, args);
    }
}
