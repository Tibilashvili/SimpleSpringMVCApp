package ua.tibilashvili.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import ua.tibilashvili.exceptions.NotFoundException;

@ControllerAdvice
public class AdviceController {

    @ExceptionHandler(value = NotFoundException.class)
    public ModelAndView exception(NotFoundException exception) {
        ModelAndView modelAndView = new ModelAndView("exceptions/notFoundObject");
        modelAndView.addObject("errorMessage", exception.getMessage());
        return modelAndView;
    }
}