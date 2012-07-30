package com.cognicap.site.web.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cognicap.site.web.util.ExceptionUtil;

/**
 * A simple Controller example that a developper can use as a tool
 * to call the throwException handler that throws on purpose an exception!
 * This is pretty useful to make sure that the error page displayed
 * in that case meets your expectations.
 *
 * Note: This controller name is forced only to minimize the risks of name collisions.
 * It is not used since controllers sit on top of everything else.
 */
@Controller
@RequestMapping("/admin/")
public class AdminController {

    private ExceptionUtil exceptionUtil = new ExceptionUtil();

    @RequestMapping("index")
    public void index(Model model) {
        model.addAttribute("adminForm", new AdminForm());
    }

    @RequestMapping("throwException")
    public void throwException(@ModelAttribute AdminForm adminForm) throws Exception {
        exceptionUtil.throwException(adminForm.getExceptionName());
    }
}