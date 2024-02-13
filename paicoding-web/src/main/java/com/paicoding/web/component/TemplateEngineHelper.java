package com.paicoding.web.component;

import com.paicoding.core.util.MapUtils;
import com.paicoding.web.global.GlobalInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.annotation.Resource;

@Component
public class TemplateEngineHelper {
    //@Autowired
    @Resource
    private SpringTemplateEngine springTemplateEngine;

    //@Autowired
    @Resource
    private GlobalInitService globalInitService;

    /**
     * 模板渲染
     * @param template
     * @param attrName
     * @param attrVal
     * @param <T>
     * @return
     */
    public <T> String render(String template, String attrName, T attrVal) {
        Context context = new Context();
        context.setVariable(attrName, attrVal);
        context.setVariable("global", globalInitService.globalAttr());
        return springTemplateEngine.process(template, context);
    }

    public <T> String render(String template,T attr) {
        return render(template, "vo", attr);
    }

    /**
     * 模板渲染，传参属性放在vo包装类下
     * @param template 模板
     * @param second 实际的data属性
     * @param val 传参
     * @param <T>
     * @return
     */
    public <T> String renderToVo(String template, String second, T val) {
        Context context = new Context();
        context.setVariable("vo", MapUtils.create(second, val));
        return springTemplateEngine.process(template, context);
    }
}
