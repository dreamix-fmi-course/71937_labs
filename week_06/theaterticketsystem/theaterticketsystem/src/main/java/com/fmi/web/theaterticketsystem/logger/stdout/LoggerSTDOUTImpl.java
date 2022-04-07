package com.fmi.web.theaterticketsystem.logger.stdout;

import com.fmi.web.theaterticketsystem.config.AppConfig;
import com.fmi.web.theaterticketsystem.logger.Logger;
import com.fmi.web.theaterticketsystem.vo.LoggerLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Date;

@Profile("local")
@Component
public class LoggerSTDOUTImpl implements Logger {
    private LoggerLevel level;

    @Autowired
    public LoggerSTDOUTImpl(final AppConfig config) {
        this.level = LoggerLevel.valueOf(config.getLogger().getLevel());
    }

    @Override
    public void info(Object toLog) {
        this.logInformation(toLog, LoggerLevel.INFO);
    }

    @Override
    public void debug(Object toLog) {
        if (this.level.getCode() >= LoggerLevel.DEBUG.getCode()) {
            this.logInformation(toLog, LoggerLevel.DEBUG);
        }
    }

    @Override
    public void trace(Object toLog) {
        if (this.level.getCode() >= LoggerLevel.TRACE.getCode()) {
            this.logInformation(toLog, LoggerLevel.TRACE);
        }
    }

    @Override
    public void error(Object toLog) {
        if (this.level.getCode() >= LoggerLevel.ERROR.getCode()) {
            this.logInformation(toLog, LoggerLevel.ERROR);
        }
    }

    private void logInformation(Object toLog, LoggerLevel currentLoggerLevel) {
        System.out.println(new Date() + " [" + currentLoggerLevel.getLabel() + "] - " + toLog);
    }
}
