package com.basov.springbootjpa.AOP;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @AfterThrowing("execution(* getAuthorById(..))")
    public void afterThrowingGetAuthorByIdAdvice(){
        logger.trace("***TRACE*** getAuthorById method: EXCEPTION");
        logger.debug("***DEBUG*** getAuthorById method: EXCEPTION");
        logger.info("***INFO*** getAuthorById method: EXCEPTION");
        logger.warn("***WARN*** getAuthorById method: EXCEPTION");
        logger.error("***ERROR*** getAuthorById method: EXCEPTION");
    }

    @AfterThrowing("execution(* deleteAuthorById(..))")
    public void afterThrowingDeleteAuthorByIdAdvice(){
        logger.info("***INFO*** deleteAuthorById method: EXCEPTION");
    }

    @AfterThrowing("execution(* getFileById(..))")
    public void afterThrowingGetFileByIdAdvice(){
        logger.info("***INFO*** getFileById method: EXCEPTION");
    }

    @AfterThrowing("execution(* deleteFileById(..))")
    public void afterThrowingDeleteFileByIdAdvice(){
        logger.info("***INFO*** deleteFileById method: EXCEPTION");
    }

    @AfterThrowing("execution(* getFileTypeById(..))")
    public void afterThrowingGetFileTypeByIdAdvice(){
        logger.info("***INFO*** getFileTypeById method: EXCEPTION");
    }

    @AfterThrowing("execution(* deleteFileTypeById(..))")
    public void afterThrowingDeleteFileTypeByIdAdvice(){
        logger.info("***INFO*** deleteFileTypeById method: EXCEPTION");
    }

    @AfterThrowing("execution(* addFileTypeToAuthor(..))")
    public void afterThrowingAddFileTypeToAuthorAdvice(){
        logger.info("***INFO*** addFileTypeToAuthor method: EXCEPTION");
    }

    @AfterThrowing("execution(* addAuthorToFileType(..))")
    public void afterThrowingAddAuthorToFileTypeAdvice(){
        logger.info("***INFO*** addAuthorToFileType method: EXCEPTION");
    }
}
